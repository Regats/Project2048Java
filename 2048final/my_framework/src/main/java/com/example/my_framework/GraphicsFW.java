package com.example.my_framework;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

public class GraphicsFW {

    private AssetManager assetManagerGame;
    private Bitmap frameBufferGame;
    private Canvas canvasGame;
    private Paint paintGame;
    private Bitmap textureGame;
    private final int sizeRect = 90;

    public GraphicsFW(AssetManager assetManagerGame, Bitmap frameBufferGame) {

        this.assetManagerGame = assetManagerGame;
        this.frameBufferGame = frameBufferGame;
        this.canvasGame = new Canvas(frameBufferGame);
        this.paintGame = new Paint();
    }

    public void clearScene(int colorRGB){

        canvasGame.drawRGB(colorRGB, colorRGB, colorRGB);
    }

    public void drawPixel(int x, int y, int color){

        paintGame.setColor(color);
        canvasGame.drawPoint(x, y, paintGame);
    }

    public void drawRect(int xLeft, int yTop, int xRight,int yBottom, int color){

        paintGame.setColor(color);
        canvasGame.drawRect(xLeft, yTop, xRight, yBottom - 15, paintGame);
    }

    public void drawMap(int x, int y, int color){

        paintGame.setColor(color);

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                canvasGame.drawRect(x + i * (sizeRect + 10), y + j * (sizeRect - 15),
                        x + sizeRect + i * (sizeRect + 10), y + (sizeRect - 15) + j * (sizeRect - 15) - 5, paintGame);
            }
        }
    }

    public void drawText(String text, int x, int y,
                         int color, int sizeText, Typeface font){

        paintGame.setColor(color);
        paintGame.setTextSize(sizeText);
        paintGame.setTypeface(font);
        canvasGame.drawText(text, x, y, paintGame);
    }

    public void drawTexture(Bitmap textureGame, int x, int y){

        canvasGame.drawBitmap(textureGame, x, y, null);
    }

    public int getWidthFrameBuffer(){

        return frameBufferGame.getWidth();
    }

    public int getHeightFrameBuffer(){

        return frameBufferGame.getHeight();
    }

    public Bitmap newTexture(String fileName) throws IOException {

        InputStream inputStream = null;

        inputStream = assetManagerGame.open(fileName);
        textureGame = BitmapFactory.decodeStream(inputStream);

        if(textureGame == null){

            throw new RuntimeException("Невозможно загрузить фаил " + fileName);
        }

        if(inputStream != null){
            inputStream.close();
        }

        return textureGame;
    }

    public Bitmap newSprite(Bitmap textureAtlas, int x, int y,
                            int widthSprite, int heightSprite){

        return Bitmap.createBitmap(textureAtlas, x, y, widthSprite, heightSprite);
    }

}
