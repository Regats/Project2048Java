package com.example.project2048java;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = findViewById(R.id.mainlayout);

        ImageView imageView = new ImageView(this);

        imageView.setMaxWidth(100);
        imageView.setMaxHeight(100);
        imageView.setImageResource(R.drawable.icon);
        mainLayout.addView(imageView);
    }
}