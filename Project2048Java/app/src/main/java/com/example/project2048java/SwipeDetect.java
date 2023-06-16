package com.example.project2048java;

import android.view.MotionEvent;

public abstract class SwipeDetect {

    private boolean isStarted = false;
    private float startX = 0;
    private float startY = 0;
    private int minTouchLen = 10;

    public abstract void onSwipeDetected(Direction direction);

    public SwipeDetect(int minTouchLen) {
        this.minTouchLen = minTouchLen * 5;
    }

    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                isStarted = true;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                float dx = event.getX() - startX;
                float dy = event.getY() - startY;
                if (calcDist(dx, dy) >= minTouchLen){
                    onSwipeDetected(Direction.get(caclAngel(dx, dy)));
                }
                startX = startY = 0;
                isStarted = false;
                break;
            default:
                startX = startY = 0;
                isStarted = false;
        }
        return false;

    }

    private int caclAngel(float dx, float dy) {
        return (int) ((Math.atan2(dy, dx) + Math.PI) * 180 / Math.PI + 180) % 360;
    }

    private double calcDist(float dx, float dy) {
        return Math.sqrt(dx*dx + dy*dy);
    }

    public enum Direction{
        UN_EXPT, // остаемся на месте
        LEFT,
        RIGHT,
        UP,
        DOWN;

        public static Direction get(int angel){
            Direction res = UN_EXPT;
            if (inRange(angel, 45, 135)) res = UP;
            else if (inRange(angel, 135, 225)) res = RIGHT;
            else if (inRange(angel, 225, 315)) res = DOWN;
            else if(inRange(angel, 315, 360)
                    | inRange(angel, 0, 45)) res = LEFT;
            return res;
        }

        private static boolean inRange(int angel, int min, int max){
            return angel >= min & angel <= max;
        }
    }
}
