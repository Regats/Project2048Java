package com.example.project2048java;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    private TableRow row0 = findViewById(R.id.tableRow0);
    private Button[][] gameMap = new Button[4][4];
    private Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = new Button(this);

        gameMap[0][0] = button.findViewById(R.id.place00);
        gameMap[0][1] = button.findViewById(R.id.place01);
        gameMap[0][2] = button.findViewById(R.id.place02);
        gameMap[0][3] = button.findViewById(R.id.place03);
        gameMap[1][0] = button.findViewById(R.id.place10);
        gameMap[1][1] = button.findViewById(R.id.place11);
        gameMap[1][2] = button.findViewById(R.id.place12);
        gameMap[1][3] = button.findViewById(R.id.place13);
        gameMap[2][0] = button.findViewById(R.id.place20);
        gameMap[2][1] = button.findViewById(R.id.place21);
        gameMap[2][2] = button.findViewById(R.id.place22);
        gameMap[2][3] = button.findViewById(R.id.place23);
        gameMap[3][0] = button.findViewById(R.id.place30);
        gameMap[3][1] = button.findViewById(R.id.place31);
        gameMap[3][2] = button.findViewById(R.id.place32);
        gameMap[3][3] = button.findViewById(R.id.place33);

        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        int startX = rnd.nextInt(4);
        int startY = rnd.nextInt(4);

        Button buttonStart = new Button(this);
        Button clone = gameMap[startX][startY];

        lParams.gravity = clone.getGravity();
        buttonStart.setX(clone.getX());
        buttonStart.setY(clone.getY());
        buttonStart.setText("Start");
        row0.addView(buttonStart, lParams);

    }




}