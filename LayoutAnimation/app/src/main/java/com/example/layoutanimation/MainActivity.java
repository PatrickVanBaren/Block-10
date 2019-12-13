package com.example.layoutanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Random mRandom = new Random();
    private ViewGroup list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.view_list);
        findViewById(R.id.view_add).setOnClickListener(this);
        findViewById(R.id.view_remove).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_add:
                final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(100, ViewGroup.LayoutParams.MATCH_PARENT);
                final int randomColor = Color.argb(
                        0xff,
                        (int)(mRandom.nextDouble() * 255),
                        (int)(mRandom.nextDouble() * 255),
                        (int)(mRandom.nextDouble() * 255)
                );
                final View view = new View(MainActivity.this);
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(randomColor);
                list.addView(view);
                break;
            case R.id.view_remove:
                final int childCount = list.getChildCount();
                if (childCount > 0) {
                    list.removeViewAt((int) mRandom.nextDouble() * childCount);
                }
                break;
        }
    }
}
