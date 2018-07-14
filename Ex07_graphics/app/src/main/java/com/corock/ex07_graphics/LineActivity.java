package com.corock.ex07_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LineActivity extends AppCompatActivity {

    // 좌푯값을 저장할 리스트
    List<Point> points = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));   // 커스텀 뷰 클래스
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        /**
         * onDraw() : 그래픽 처리
         */
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);     // 배경 색상
            Paint paint = new Paint();
            paint.setColor(Color.RED);

            for (int i = 0; i < points.size(); i++) {
                Point now = points.get(i);      // 현재 좌표

                // 그리기 상태이면
                if (now.isDraw) {
                    Point before = points.get(i - 1);   // 직전 좌표
                    // drawLine(x1, y1, x2, y2, paint 객체) : (x1, y1) ~ (x2, y2) 선 그리기
                    canvas.drawLine(before.x, before.y, now.x, now.y, paint);
                }
            }
        }   // end of onDraw()

        /**
         * onTouchEvent() : 터치 이벤트 처리
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // 터치 상태
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // 시작점이므로 아직 그림을 그리지 않음
                points.add(new Point(event.getX(), event.getY(), false));
                return true;
            }

            // 터치 후 드래그 상태
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                // 움직일 때마다 그림을 그림
                points.add(new Point(event.getX(), event.getY(), true));
                invalidate();   // onDraw() 호출
                return true;
            }
            return false;   // 터치 이벤트가 작동되지 않음
        }
    }   // end of class MyView

}
