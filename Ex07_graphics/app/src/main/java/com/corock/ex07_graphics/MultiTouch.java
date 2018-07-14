package com.corock.ex07_graphics;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MultiTouch extends AppCompatActivity {

    final static float STEP = 200;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    ImageView mImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_touch);

        mImg = (ImageView) findViewById(R.id.img);
    }

    public boolean onTouchEvent(MotionEvent event) {
        // 포인터가 2개일 때(멀티터치)
        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int pureaction = action & MotionEvent.ACTION_MASK;

            // 멀티터치 시작
            if (pureaction == MotionEvent.ACTION_POINTER_DOWN) {
                // 두 손가락의 길이 구하기
                mBaseDist = getDistance(event);
                mBaseRatio = mRatio;
            } else {
                // 변화된 길이 - 처음 길이
                float delta = (getDistance(event) - mBaseDist) / STEP;
                float multi = (float) Math.pow(2, delta);
                mRatio = Math.min(1024.0f, Math.max(0.1f, mBaseRatio * multi));
                Matrix m = new Matrix();
                m.postScale(mRatio, mRatio);
                mImg.setImageMatrix(m);
            }
        }
        return true;
    }   // end of onTouchEvent()

    int getDistance(MotionEvent event) {
        // 손가락 두 개의 좌표 계산
        // 가로 길이의 제곱 + 세로 길이의 제곱 = 대각선의 제곱
        int dx = (int) (event.getX(0) - event.getX(1));
        int dy = (int) (event.getY(0) - event.getY(1));

        return (int) (Math.sqrt(dx * dx + dy * dy));
    }

}
