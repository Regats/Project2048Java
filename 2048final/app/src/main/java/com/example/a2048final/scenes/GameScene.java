package com.example.a2048final.scenes;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class GameScene extends SceneFW {

    public GameScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.rgb(231, 227, 235));
        graphicsFW.drawText("Игровая сцена", 100, 100, Color.BLACK, 40, null);
        graphicsFW.drawRect(90, 290, 500, 620, Color.argb(60, 209, 194, 225));
        graphicsFW.drawMap(100, 300, Color.argb(50, 148, 100, 172));
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
