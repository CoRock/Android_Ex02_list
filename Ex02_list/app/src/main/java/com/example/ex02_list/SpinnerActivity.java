package com.example.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    // 1. 변수 선언
    TextView txtResult;
    Spinner spinner1;
    String[] arr = { "포도", "사과", "배", "귤", "딸기", "감", "대추" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);

        txtResult = (TextView) findViewById(R.id.txtResult);
        spinner1 = (Spinner) findViewById(R.id.spinner1);

        // 2. 어댑터 생성
        // new ArrayAdapter(컨텍스트, 자식 뷰의 레이아웃 파일, 원본 데이터)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, arr);
        spinner1.setAdapter(adapter);

        // 스피너의 아이템 선택 이벤트
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // 아이템을 선택했을 때
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // position : 선택한 아이템의 인덱스 값
                txtResult.setText(arr[position]);
            }

            // 선택된 아이템이 없을 때
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
