package com.corock.ex07_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class ShapeActivity extends AppCompatActivity {

    // 변수 선언
    int x = 50, y = 50;             // 원의 중심 좌표
    int width, height;              // 화면의 가로, 세로 길이
    int moveX = 5, moveY = 10;
    int red, green, blue;
    boolean isRun;                  // 스레드의 실행 여부
    Thread th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml 대신 사용자 정의 뷰를 화면 레이아웃으로 사용(커스텀 뷰)
        setContentView(new MyView(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRun = false;      // 스레드 중지 상태로 변경
        th = null;
    }

    // 커스텀 레이아웃 내부 클래스
    class MyView extends View implements Runnable {
        // Alt + Insert, 생성자 추가
        public MyView(Context context) {
            super(context);

            // 백그라운드 스레드 객체 생성
            th = new Thread(this);
            th.start();     // run()이 호출됨
            isRun = true;   // 스레드 실행 상태로 변경
        }

        /**
         * onSizeChanged() : 뷰의 사이즈가 변경될 때 호출
         * 최초 뷰가 출력될 때, 폰의 가로/세로 방향이 바뀔 때
         */
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            // 폰의 가로, 세로 사이즈 계산
            width = getWidth();     // 뷰의 가로 사이즈
            height = getHeight();   // 뷰의 세로 사이즈
        }

        void setColor() {
            // 랜덤 객체 생성
            Random rand = new Random();

            // 랜덤 객체.nextInt(숫자) : 0 ~ (숫자 - 1) 사이의 난수 발생
            red = rand.nextInt(256);    // 0 ~ 255
            green = rand.nextInt(256);
            blue = rand.nextInt(256);
        }

        // [Alt + Insert] --> [Implement Methods]
        // 백그라운드 스레드에서 호출하는 코드(좌표 값을 변경, 그래픽 갱신 요청)
        @Override
        public void run() {
            while (isRun) {
                // 좌우 벽처리; 반지름 크기를 고려해야 함
                if (x > (width - 20) || x < 20) {
                    moveX = -moveX;
                    setColor();
                }

                // 상하 벽처리
                if (y > (height - 20) || y < 20) {
                    moveY = -moveY;
                    setColor();
                }

                // x, y 좌표 변경
                x += moveX;
                y += moveY;
                Log.i("thread test", "x: " + x + ", y: " + y);

                // 그래픽 갱신 요청(invalidate() --> onDraw()가 호출됨)
                postInvalidate();

                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }   // end of while loop
        }   // end of run()

        /**
         * onDraw() : 뷰가 화면에 출력될 때 실행됨(그래픽 처리)
         */
        @Override
        protected void onDraw(Canvas canvas) {
            // Canvas : 도화지 역할(바탕화면)
            // 캔버스의 색상 설정
            canvas.drawColor(Color.LTGRAY);     // 바탕화면 색상

            // Paint : 붓 역할
            // 페인트 객체
            Paint p = new Paint();

            // alpha : 투명도 0(완전 투명) ~ 255(완전 불투명)
            // Color.argb(투명도, red, green, blue)
            p.setColor(Color.argb(255, red, green, blue));  // 색상 설정

            // 캔버스에 원 그리기(x, y, 반지름, paint 객체)
            canvas.drawCircle(x, y, 20, p);

        /*
            for (int i = 1; i <= 200; i += 5) {
                canvas.drawCircle(x + i, y + i, 20, p);
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        */

            // p.setColor(Color.GREEN);
            // 사각형 그리기(x1, y1, x2, y2, 페인트 객체)
            // canvas.drawRect(200, 200, 300, 300, p);
        }
    }

}