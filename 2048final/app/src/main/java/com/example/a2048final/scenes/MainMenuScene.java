package com.example.a2048final.scenes;

import android.graphics.Color;

import com.example.a2048final.R;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {

        if(coreFW.getTouchListenerFW().getTouchUp(200, 429, 227, 75)){

            coreFW.setSceneFW(new GameScene(coreFW));
        }
    }

    @Override
    public void drawing() {

        graphicsFW.clearScene(Color.rgb(231, 227, 235));
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame),
                 220, 100, Color.rgb( 118,  86, 130),
                80, null);
        graphicsFW.drawRect(200, 359, 427, 429, Color.rgb(209, 194, 225));
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame),
                210, 400, Color.rgb(148, 100, 172),
                40, null);
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
