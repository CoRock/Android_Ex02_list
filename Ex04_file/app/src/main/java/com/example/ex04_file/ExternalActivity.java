package com.example.ex04_file;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class ExternalActivity extends AppCompatActivity {

    Button btnSave, btnLoad, btnDelete;
    EditText edit1;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_write);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        edit1 = (EditText) findViewById(R.id.edit1);

        // 외부 메모리의 경로(안드로이드 버전, 제조사마다 경로가 다름)
        // /storage/emulated/0
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.i("test", "외부 메모리 경로: " + path);

        // 3. 저장 버튼 클릭
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

        // 4. 불러오기 버튼 클릭
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });

        // 5. 삭제 버튼 클릭
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(path + "/test.txt");

                // 파일 객체.delete() 삭제, 삭제 성공하면 true 리턴
                if (file.delete()) {
                    edit1.setText("");

                    // 컨텍스트 : getApplicationContext(), 메인 클래스.this
                    Toast.makeText(ExternalActivity.this,
                            "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 내부 메모리, 외부 메모리 : 논리적 개념;     cf. '물리적인 개념(x)
    // 내부 메모리(앱에서 사용하는 전용 공간)
    void load() {
        try {
            // 파일 내용을 읽기 위한 스트림 생성
            FileInputStream is = new FileInputStream(path + "/test.txt");

            if (is != null) {
                // Stream 바이트 단위 입출력, Reader/Writer 문자 단위 입출력
                InputStreamReader reader = new InputStreamReader(is, "utf-8");

                // 처리 속도를 높이기 위해 버퍼 사용
                BufferedReader br = new BufferedReader(reader);
                String str = "";
                StringBuilder sb = new StringBuilder();

                // 한 라인씩 읽음
                while ((str = br.readLine()) != null) {
                    sb.append(str + "\n");
                }

                is.close();     // 스트림 닫기

                edit1.setText(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 안드로이드 6.0(마시멜로) API Level 23
    void check() {
        // 사용자 동의 여부를 개별적으로 체크
        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED ||
            checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {

            // 왜 이 사용 권한에 동의해야 하는지에 대한 설명(선택적)
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this,
                        "외부 메모리에 읽기, 쓰기 권한이 필요합니다.", Toast.LENGTH_SHORT).show();
            }

            // 사용 권한 요청 팝업창을 띄움
            // requestPermissions(사용권한배열, 요청코드)
            requestPermissions(new String[] {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE }, 1);
        } else {    // 이미 동의를 받은 상태이면 진행
            save();
        }
    }

    void save() {
        File file = new File(path + "/test.txt");

        try {
            // 파일 저장을 위한 스트림 생성
            FileOutputStream fos = new FileOutputStream(file);

            // 사용자의 입력 내용
            String str = edit1.getText().toString();

            // 스트링을 바이트 배열로 변환한 후 저장
            // 스트링.getBytes() : 스트링을 바이트 배열로 ~.
            fos.write(str.getBytes());
            fos.close();    // 스트림 닫기

            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 사용자의 동의 결과를 처리하는 메서드
    @Override
    public void onRequestPermissionsResult(int requestCode,
    @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {  // 요청 코드
            case 1:
                // grantResults.length 사용자의 동의결과 항목 수
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    // 모두 동의한 경우
                    save();
                } else {    // 동의하지 않은 경우
                    Toast.makeText(this,
                            "더 이상 외부 메모리를 사용할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
        }
    }

}