package com.example.ex04_file;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BackupActivity extends AppCompatActivity {

    ProgressDialog pd;      // 진행률을 표시하는 다이얼로그
    long filesize;          // 진행률 표시를 위한 파일의 크기
    String path;            // 외부 메모리의 경로

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 화면은 사용하지 않음
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        showDlg();
    }

    void showDlg() {
        // [Alt + Enter] : import
        // 다이얼로그 생성기
        // new AlertDialog.Builder(컨텍스트)
        // 컨텍스트 : 다이얼로그가 출력될 Activity 클래스
        new AlertDialog.Builder(this)
                .setTitle("확인")
                .setMessage("백업을 하시겠습니까?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        createThreadAndDialog();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    void createThreadAndDialog() {
        pd = new ProgressDialog(this);                  // 진행률 다이얼로그 생성
        pd.setTitle("백업");    // 제목
        pd.setMessage("백업 작업이 진행중입니다.");             // 본문
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);   // 가로막대형, 회전형
        pd.setProgress(0);      // 현재 진행률
        pd.setMax(100);         // 최대값
        pd.show();              // 다이얼로그 표시

//        for (int i = 1; i <= 100; i++) {
//            pd.setProgress(i);  // 진행률 변경
//
//            try {
//                Thread.sleep(50);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        // single thread : 작업 단위가 1개
        // multi thread : 작업 단위가 2개 이상
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    pd.setProgress(i);      // 진행률 변경

                    try {
                        Thread.sleep(50);   // 시간 지연
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // Activity ....... that was originally added here
                // 백그라운드 스레드에서는 메인화면을 터치할 수 없음(소형 디바이스이므로)
//                Toast.makeText(BackupActivity.this,
//                        "백업이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                // 핸들러에게 메세지 전달
                handler.sendEmptyMessage(0);
            }
        });
        thread.start();     // 백그라운드 스레드 실행 요청
    }

    // 핸들러 작성 : 심부름 센터
    // (백그라운드 스레드는 메인화면을 터치할 수 없으므로 핸들러에게 요청하여 화면 변경 작업 처리)
    Handler handler = new Handler() {
        /**
         * handleMessage : 백그라운드 스레드에서 전달한 메세지를 처리하는 코드
         * @param msg
         */
        @Override   // [Alt + Insert]
        public void handleMessage(Message msg) {
            // 프로그레스 다이얼로그를 닫음
            pd.dismiss();

            // 화면 변경 작업
            Toast.makeText(BackupActivity.this,
                    "백업이 완료되었습니다.", Toast.LENGTH_SHORT).show();
        }
    };

}