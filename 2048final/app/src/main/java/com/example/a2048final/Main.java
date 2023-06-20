package com.example.a2048final;

import com.example.a2048final.scenes.MainMenuScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class Main extends CoreFW {

    @Override
    public SceneFW getStartScene() {
        return new MainMenuScene(this);
    }
}