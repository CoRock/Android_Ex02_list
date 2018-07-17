package com.corock.ex10_animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimation extends AppCompatActivity {

    Button btnStart, btnStop;
    ImageView image1;
    AnimationDrawable ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animation);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        image1 = (ImageView) findViewById(R.id.image1);

        // 이미지뷰의 background 속성에 지정된 애니메이션 효과를 불러옴
        ani = (AnimationDrawable) image1.getBackground();

        // 이미지뷰에 애니메이션 효과 적용
        image1.post(new Runnable() {
            @Override
            public void run() {
                ani.start();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ani.start();    // 애니메이션 시작
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ani.stop();     // 애니메이션 멈춤
            }
        });
    }

}
