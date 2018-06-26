package com.example.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);

        txtResult = (TextView) findViewById(R.id.txtResult);

        // 앞 화면에서 넘어온 인텐트 정보를 받음
        Intent intent = getIntent();

        // getStringExtra("String 변수명"); 보낸 값들을 받아 보자!
        // (자료형) intent.getSerializableExtra("객체직렬화된 객체");
        // '어떤 타입이 넘어올 지 모르기 때문에 return type is Serializable
        BmiDTO dto = (BmiDTO) intent.getSerializableExtra("dto");
        String result = dto.getResult();
        String name = dto.getName();
        int age =dto.getAge();
        double height = dto.getHeight();
        double weight = dto.getWeight();
        double bmi = dto.getBmi();

//        String result = intent.getStringExtra("result");
//        String name = intent.getStringExtra("name");
//        int age = intent.getIntExtra("age", 0);
//        double height = intent.getDoubleExtra("height", 0);
//        double weight = intent.getDoubleExtra("weight", 0);
//        double bmi = intent.getDoubleExtra("bmi", 0);

        txtResult.setText(
                "이름: " + name + "\n" + "나이: " + age + "\n"
              + "신장: " + height + "\n" + "체중: " + weight + "\n"
              + "bmi: " + bmi + "\n" + result);
    }
}
