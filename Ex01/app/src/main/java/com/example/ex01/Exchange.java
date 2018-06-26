package com.example.ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Activity : 화면 처리 클래스
// Exchange.java        R.java        exchange.xml
public class Exchange extends AppCompatActivity {

    EditText dollar;
    Button button;
    TextView txtResult;

    // onCreate : 화면을 생성할 때 자동으로 생성되는 메서드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // exchange.xml을 현재 클래스의 화면 레이아웃으로 사용
        setContentView(R.layout.exchange);

        // 위젯 생성
        // (형변환)findVIewById(리소스의 아이디)
        dollar = (EditText) findViewById(R.id.dollar);
        button = (Button) findViewById(R.id.button);
        txtResult = (TextView) findViewById(R.id.txtResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast : 간단한 팝업메세지
                // Toast.makeText(토스트를 출력할 화면, 메세지, 표시시간).show();
                if (dollar.getText().toString().equals("")) {
                    Toast.makeText(Exchange.this, "숫자를 입력하세요",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                int intDollar = Integer.parseInt(dollar.getText().toString());
                int money = intDollar * 1100;
                txtResult.setText(intDollar + "달러 = " + money + "원입니다.");
            }
        });
    }
}
