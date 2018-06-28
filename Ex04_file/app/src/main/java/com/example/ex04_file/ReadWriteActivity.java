package com.example.ex04_file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadWriteActivity extends AppCompatActivity {

    Button btnSave, btnLoad, btnDelete;
    EditText edit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        edit1 = (EditText) findViewById(R.id.edit1);

        // 불러오기 버튼
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // 내부 메모리에 저장된 파일을 열기 위한 스트림
                    // /data/data/패키지/files 디렉토리에 있는 test.txt 파일 조회
                    InputStream is = openFileInput("test.txt");

                    if (is != null) {
                        // new InputStreamReader(스트림, 문자셋)
                        InputStreamReader reader = new InputStreamReader(is, "utf-8");
                        BufferedReader br = new BufferedReader(reader);
                        String str = "";
                        StringBuilder sb = new StringBuilder();

                        // 한 라인씩 읽음
                        while((str = br.readLine()) != null) {
                            sb.append(str + "\n");
                        }

                        is.close();     // 스트림 닫기

                        edit1.setText(sb.toString());   // 붙임
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 저장 버튼 클릭
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // /data/data/패키지이름/files : 내부 메모리 파일 전용 디렉토리
                // '패키지명을 com.example.ex04_file을 적어도 되지만 바뀔 수도 있는 등의 확장성 고려
                File dir = new File("/data/data/" + getPackageName() + "/files");

                // 디렉토리가 존재하지 않으면
                if (!dir.exists()) {
                    // 디렉토리 생성
                    dir.mkdir();
                }

                File file = new File("/data/data/" + getPackageName() + "/files/test.txt");

                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    String str = edit1.getText().toString();    // '사용자가 입력한 내용

                    // 문자열.getBytes() : 문자열을 바이트 배열로
                    // write(바이트 배열)
                    fos.write(str.getBytes());
                    fos.close();
                    Toast.makeText(ReadWriteActivity.this,
                            "저장되었습니다.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
