package com.corock.ex09_dialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        // 액티비티 : 독립적인 화면
        // 다이얼로그 : 단독으로 화면을 띄울 수 없음
        button1 = (Button) findViewById(R.id.button1);

        // 버튼 클릭 이벤트
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다이얼로그 객체 생성
                // new Dialog(컨텍스트) 다이얼로그를 출력할 화면 지정
                Dialog dlg = new Dialog(DialogActivity.this);
                dlg.setTitle("다이얼로그 연습");   // 다이얼로그의 제목

                // 코드로 레이아웃 작성
                TextView text = new TextView(DialogActivity.this);
                text.setText("다이얼로그의 내용");


                // xml로 레이아웃 작성
                // 다이얼로그의 화면을 xml로 지정
                // dlg.setContentView(R.layout.test);

                // 다이얼로그의 내용
                // 다이얼로그의 화면을 코드로 지정
                dlg.setContentView(text);
                dlg.show();     // 다이얼로그를 화면에 표시
            }
        });
    }

}
