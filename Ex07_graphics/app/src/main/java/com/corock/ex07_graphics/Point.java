package com.corock.ex07_graphics;

public class Point {

    // 좌푯값을 저장하는 클래스
    float x, y;         // 좌푯값
    boolean isDraw;     // 그리기 상태

    // [Alt + Insert] --> [Constructor]
    public Point(float x, float y, boolean isDraw) {
        this.x = x;
        this.y = y;
        this.isDraw = isDraw;
    }

}
