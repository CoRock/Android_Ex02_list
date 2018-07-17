package com.corock.ex09_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {

    Button button1;
    String[] items = {"coffee", "cocoa", "milk", "cola"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SelectActivity.this)
                        .setTitle("주문")
                        // .setItems(배열, 이벤트 핸들러)
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // int which : 선택한 아이템의 인덱스 값
                                Toast.makeText(SelectActivity.this,
                                        "주문한 메뉴는 " + items[which] + "입니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SelectActivity.this,
                                        "취소되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

}
