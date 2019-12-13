package com.example.viewanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View mFirstView, mSecondView;
    private Button mXmlButton, mCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mXmlButton = findViewById(R.id.xml_button);
        mCodeButton = findViewById(R.id.code_button);
        mFirstView = findViewById(R.id.view_first);
        mSecondView = findViewById(R.id.view_second);

        mXmlButton.setOnClickListener(this);
        mCodeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.xml_button):
                mFirstView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,  R.anim.animation));
                break;
            case (R.id.code_button):
                final AnimationSet animationSet = new AnimationSet(true);
                animationSet.setInterpolator(new AccelerateInterpolator());
                animationSet.setFillAfter(true);

                final RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 100, 100);
                rotateAnimation.setDuration(1000);
                animationSet.addAnimation(rotateAnimation);

                final TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 100,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 100
                );
                translateAnimation.setDuration(1000);
                animationSet.addAnimation(translateAnimation);

                final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
                alphaAnimation.setDuration(1000);
                animationSet.addAnimation(alphaAnimation);

                mSecondView.startAnimation(animationSet);
                break;
        }
    }
}
