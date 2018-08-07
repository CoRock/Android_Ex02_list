package com.corock.ex10_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TweenAnimation extends AppCompatActivity {

    Button button1, button2, button3, button4, button5;
    Animation ani;
    ImageView image1;
    LinearLayout linear1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        image1 = (ImageView) findViewById(R.id.image1);
        linear1 = (LinearLayout) findViewById(R.id.linear1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 애니메이션 정보 로딩
                ani = AnimationUtils.loadAnimation(TweenAnimation.this, R.anim.translate);

                // 애니메이션 적용
                // image1.startAnimation(ani);
                linear1.startAnimation(ani);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 애니메이션 효과를 불러옴
                ani = AnimationUtils.loadAnimation(TweenAnimation.this, R.anim.rotate);

                // 이미지뷰에 애니메이션 효과를 적용시킴
                // image1.startAnimation(ani);
                linear1.startAnimation(ani);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 애니메이션 효과를 불러옴
                ani = AnimationUtils.loadAnimation(TweenAnimation.this, R.anim.alpha);

                // 이미지뷰에 애니메이션 효과를 적용시킴
                // image1.startAnimation(ani);
                linear1.startAnimation(ani);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 애니메이션 효과를 불러옴
                ani = AnimationUtils.loadAnimation(TweenAnimation.this, R.anim.scale);

                // 이미지뷰에 애니메이션 효과를 적용시킴
                // image1.startAnimation(ani);
                linear1.startAnimation(ani);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 애니메이션 효과를 불러옴
                ani = AnimationUtils.loadAnimation(TweenAnimation.this, R.anim.set);

                // 이미지뷰에 애니메이션 효과를 적용시킴
                // image1.startAnimation(ani);
                linear1.startAnimation(ani);
            }
        });
    }   // end of onCreate()

}
