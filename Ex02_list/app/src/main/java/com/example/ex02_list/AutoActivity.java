package com.example.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoActivity extends AppCompatActivity {

    // 1. 변수 선언
    TextView txtResult;
    AutoCompleteTextView auto1;
    String[] items = { "java", "java1", "java2", "java3",
            "c", "c++", "visual c++", "android", "apple" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto);

        // 2. 연결
        txtResult = (TextView) findViewById(R.id.txtResult);
        auto1 = (AutoCompleteTextView) findViewById(R.id.auto1);

        // 3. 어댑터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, items);
        auto1.setAdapter(adapter);

        // 4. 이벤트 처리
    }
}
