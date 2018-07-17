package com.corock.ex09_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다이얼로그 생성
                /**
                 * new AlertDialog.Builder(컨텍스트)
                 * setPositiveButton("버튼의 라벨", 이벤트 핸들러)
                 */
                // new AlertDialog.Builder(getApplicationContext())
                new AlertDialog.Builder(AlertActivity.this)
                        .setTitle("다이얼로그")
                        .setMessage("대화상자를 열었습니다.")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertActivity.this,
                                        "Yes를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertActivity.this,
                                        "No를 눌렀습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertActivity.this,
                                        "Cancel을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }   // end of onClick()
        });
    }   // end of onCreate()

}
