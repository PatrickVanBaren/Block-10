package com.example.activityandfragmenttransitionanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PageFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.view_container, PageFragment.newInstance(0)).commit();
        }
    }

    @Override
    public void onOpenPage(final int number) {
        getSupportFragmentManager()
                .beginTransaction().addToBackStack(null)
                .setCustomAnimations(R.anim.in, R.anim.out, R.anim.in, R.anim.out)
                .replace(R.id.view_container, PageFragment.newInstance(number)).commit();
    }
}
