package com.example.propertyanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.xml_button).setOnClickListener(this);
        findViewById(R.id.code_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xml_button:
                final AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.animation);
                animator.setTarget(findViewById(R.id.view_first));
                animator.start();
                break;
            case R.id.code_button:
                final ObjectAnimator route = ObjectAnimator.ofFloat(findViewById(R.id.view_second), "rotation", 0, 360);
                route.setDuration(1000);

                final ObjectAnimator translationX = ObjectAnimator.ofFloat(findViewById(R.id.view_second),"translationX", 0, 100);
                translationX.setDuration(1000);

                final ObjectAnimator translationY = ObjectAnimator.ofFloat(findViewById(R.id.view_second),"translationY", 0, 100);
                translationY.setDuration(1000);

                final ObjectAnimator alpha = ObjectAnimator.ofFloat(findViewById(R.id.view_second), "alpha", 1.0f, 0.3f);
                alpha.setDuration(1000);

                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(route, translationX, translationY, alpha);
                animatorSet.start();
                break;
        }
    }
}
