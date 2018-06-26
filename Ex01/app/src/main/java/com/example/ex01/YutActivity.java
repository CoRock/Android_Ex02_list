package com.example.ex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class YutActivity extends AppCompatActivity {

    // 1. 변수 선언; 윳 이미지의 id 배열
    int[] imgYut = { R.drawable.yut_0, R.drawable.yut_1 };
    // 평평한 면 0, 둥근 면 1
    String [] strYut = { "윷", "걸", "개", "도", "모" };
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yut);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();         // 랜덤 객체 생성
                int n1 = rand.nextInt(2);   // 0~1
                int n2 = rand.nextInt(2);
                int n3 = rand.nextInt(2);
                int n4 = rand.nextInt(2);
                int sum = n1 + n2 + n3 + n4;

                // 이미지 출력
                ImageView img1 = (ImageView) findViewById(R.id.img1);
                ImageView img2 = (ImageView) findViewById(R.id.img2);
                ImageView img3 = (ImageView) findViewById(R.id.img3);
                ImageView img4 = (ImageView) findViewById(R.id.img4);

                // 'setImageResource(이미지의 ID)
                img1.setImageResource(imgYut[n1]);
                img2.setImageResource(imgYut[n2]);
                img3.setImageResource(imgYut[n3]);
                img4.setImageResource(imgYut[n4]);

                // 결과 출력
                TextView txtResult = (TextView) findViewById(R.id.txtResult);
                txtResult.setText(strYut[sum]);
            }
        });
    }
}