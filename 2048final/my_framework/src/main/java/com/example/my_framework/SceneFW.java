package com.example.my_framework;

public abstract class SceneFW {

    public CoreFW coreFW;
    public int sceneWidth;
    public int sceneHeight;
    public GraphicsFW graphicsFW;

    public SceneFW(CoreFW coreFW) {

        this.coreFW = coreFW;
        graphicsFW = coreFW.getGraphicsFW();
        sceneHeight = coreFW.getGraphicsFW().getHeightFrameBuffer();
        sceneWidth = coreFW.getGraphicsFW().getWidthFrameBuffer();
    }

    public abstract void update();
    public abstract void drawing();
    public abstract void pause();
    public abstract void resume();
    public abstract void dispose();
}
