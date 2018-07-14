package com.corock.ex07_graphics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomActivity extends AppCompatActivity {

    MyView myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom);

        myview = (MyView) findViewById(R.id.myview);
    }

    public void onClick(View v) {
        myview.clear();
    }

}
