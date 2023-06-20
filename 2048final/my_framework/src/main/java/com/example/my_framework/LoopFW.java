package com.example.my_framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Date;

public class LoopFW extends SurfaceView implements Runnable{

    private final double FPS = 60
            ;
    private final double SECOND = 1_000_000_000;
    private final double UPDATE_TIME = SECOND/FPS;

    private boolean running = false;

    Thread gameThread = null;
    CoreFW coreFW;
    Bitmap frameBuffer;
    SurfaceHolder surfaceHolder;
    Canvas canvas;
    Rect rect;

    double updates = 0;
    double drawing = 0;
    long timer = 0;

    public LoopFW(CoreFW coreFW, Bitmap frameBuffer) {

        super(coreFW);
        this.coreFW = coreFW;
        this.frameBuffer = frameBuffer;
        this.surfaceHolder = getHolder();
        rect = new Rect();
        canvas = new Canvas();
    }

    @Override
    public void run() {

        double lastTime = System.nanoTime();
        double delta = 0;
        timer = System.currentTimeMillis();

        while (running){

            double nowTime = System.nanoTime();
            double elapsedTime = nowTime - lastTime;

            lastTime = nowTime;
            delta += elapsedTime/UPDATE_TIME;

            if(delta > 1){

                updateGame();
                drawingGame();
                delta--;
            }

            if(System.currentTimeMillis() - timer > 1000){

                Date date = new Date();

                System.out.println("updates = " + updates +
                        " drawing = " + drawing + date.toString());

                updates = 0;
                drawing = 0;
                timer += 1000;
            }
        }
    }

    private void updateGame(){

        updates++;
        coreFW.getCurrentScene().update();
    }

    private void drawingGame(){

        drawing++;

        if(surfaceHolder.getSurface().isValid()){

            canvas = surfaceHolder.lockCanvas();
            canvas.getClipBounds(rect);
            canvas.drawBitmap(frameBuffer, null, rect, null);
            coreFW.getCurrentScene().drawing();
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void startGame(){

        if(running){

            return;
        }

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGame(){
        if(!running){

            return;
        }

        running = false;

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
