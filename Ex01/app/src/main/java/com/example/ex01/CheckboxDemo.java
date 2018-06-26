package com.example.ex01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckboxDemo extends AppCompatActivity {

    // F3: 소스 코드 보기, F4: 계층 구조 보기
    CheckBox check;
    // cf. RadioButton rdo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_demo);

        check = (CheckBox) findViewById(R.id.check);

        // 체크 박스의 체크 상태 변경 이벤트
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            // CompundButton : 체크 박스와 라디오 버튼
            // isChecked : 체크 박스의 체크 상태
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)  check.setText("체크된 상태");
                else            check.setText("체크되지 않은 상태");
            }
        });
    }
}
