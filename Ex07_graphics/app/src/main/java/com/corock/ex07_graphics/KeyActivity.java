package com.corock.ex07_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class KeyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // xml 대신 사용자 정의 뷰 클래스를 화면 레이아웃으로 사용
        MyView view = new MyView(this);
        view.setFocusable(true);    // 키 이벤트를 받을 수 있도록 설정
        setContentView(view);
    }

    // 사용자 정의 뷰 클래스
    class MyView extends View {
        // 변수 선언
        float x = 50, y = 50;
        int width, height;

        public MyView(Context context) {
            super(context);
        }

        /**
         * onSizeChanged() : 뷰의 가로, 세로 사이즈가 변경될 때 호출
         */
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            width = getWidth();
            height = getHeight();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);                // 캔버스의 배경 색상
            Paint paint = new Paint();
            paint.setColor(Color.YELLOW);                  // 페인트 색상
            canvas.drawCircle(x, y, 20, paint);     // 원 그리기
        }

        /**
         * onTouchEvent() : 화면 터치 이벤트
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // 터치한 x, y 좌표 값
            x = event.getX();
            y = event.getY();

            // 화면 갱신 요청 --> onDraw()가 호출됨
            postInvalidate();

            return super.onTouchEvent(event);
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            // 입력한 키 코드 값에 따라 분기
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    x -= 5;
                    x = Math.max(20, x);            // 큰 값
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    x += 5;
                    x = Math.min(width - 20, x);    // 작은 값
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    y -= 5;
                    y = Math.max(20, y);
                    break;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    y += 5;
                    y = Math.min(height - 20, y);
                    break;
                case KeyEvent.KEYCODE_L:
                    x -= 5;
                    x = Math.max(20, x);
                    y += 5;
                    y = Math.min(height - 20, y);
                    break;
            }
            // 그래픽 갱신 요청(onDraw() 호출)
            postInvalidate();

            return super.onKeyDown(keyCode, event);
        }
    }   // end of class MyView

}