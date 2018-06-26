package com.example.ex01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

// Activity : 화면 처리 클래스
public class MainActivity extends AppCompatActivity {

    // 화면을 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 로그캣에 로그를 출력
        // Log.레벨함수("태그", "메세지");
        Log.i("test", "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test", "Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test", "onDestroy");
    }

    // onClick="mOnClick"
    // 클릭한 버튼의 id가 view 변수에 저장됨
    public void mOnClick(View view) {
        // new Intent(현재화면.this, 다음화면.class)
        Intent intent = null;

        // R class : java와 xml간의 리소스를 연결시키는 클래스
        switch (view.getId()) {  // 클릭한 버튼의 id
            case R.id.button1:
                intent = new Intent(this, ImageViewDemo.class);
                break;
            case R.id.button2:
                intent = new Intent(this, Exchange.class);
                break;
            case R.id.button3:
                intent = new Intent(this, BmiActivity.class);
                break;
            case R.id.button4:
                intent = new Intent(this, CheckboxDemo.class);
                break;
            case R.id.button5:
                intent = new Intent(this, RadioDemo.class);
                break;
            case R.id.button6:
                intent = new Intent(this, YutActivity.class);
                break;
            case R.id.button7:
                intent = new Intent(this, ScrollActivity.class);
                break;
        }
        startActivity(intent);
    }
}
