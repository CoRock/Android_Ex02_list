package com.corock.ex07_graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoRock in 2018.
 */

public class MyView extends View {

    List<Point> points = new ArrayList<>();

    public MyView(Context context) {
        super(context);
    }

    // [Alt + Insert] --> [Constructor]
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void clear() {
        points.clear();   // List의 모든 원소 삭제
        invalidate();
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
