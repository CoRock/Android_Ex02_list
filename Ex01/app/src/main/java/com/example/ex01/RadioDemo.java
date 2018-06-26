package com.example.ex01;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

// CompoundButton.OnCheckedChangeListener : 체크박스용
// RadioGroup.OnCheckedChangeListener : 라디오버튼용
public class RadioDemo extends AppCompatActivity
                       implements RadioGroup.OnCheckedChangeListener {
    // 1. 변수 선언
    RadioButton rdoRed, rdoGreen, rdoBlue;
    RadioGroup radio1;
    View layout1;

    // Alt + Insert
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // i(info), e(error), w(warning), d(debug), v(verbose)
        Log.i("test", "checkedID: " + checkedId);

        switch (checkedId) {
            case R.id.rdoRed:
                layout1.setBackgroundColor(Color.RED);      // 배경색상 변경
                break;
            case R.id.rdoGreen:
                layout1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.rdoBlue:
                layout1.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_demo);

        // 2. xml의 리소스를 참조
        rdoRed = (RadioButton) findViewById(R.id.rdoRed);
        rdoGreen = (RadioButton) findViewById(R.id.rdoGreen);
        rdoBlue = (RadioButton) findViewById(R.id.rdoBlue);
        radio1 = (RadioGroup) findViewById(R.id.radio1);
        layout1 = findViewById(R.id.layout1);

        // 라디오 그룹에 이벤트처리 코드 추가
        radio1.setOnCheckedChangeListener(this);
    }

}
