package com.corock.ex14_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(this, OptionMenuActivity.class);
                break;
            case R.id.btn2:
                intent = new Intent(this, OptionXmlActivity.class);
                break;
            case R.id.btn3:
                intent = new Intent(this, MenuCheckActivity.class);
                break;
        }
        startActivity(intent);
    }

}
