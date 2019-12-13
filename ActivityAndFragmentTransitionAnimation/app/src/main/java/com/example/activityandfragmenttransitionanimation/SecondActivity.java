package com.example.activityandfragmenttransitionanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String NUMBER_EXTRA_KEY = "SecondActivity.NUMBER_EXTRA_KEY";

    private final Random mRandom = new Random();

    private int mNumber;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent = getIntent();
        if (intent != null) {
            mNumber = intent.getIntExtra(NUMBER_EXTRA_KEY, 0);
        }

        findViewById(R.id.view_page_layout).setBackgroundColor(Utils.generateRandomColor(mRandom));
        ((TextView) findViewById(R.id.view_number)).setText(String.valueOf(mNumber));
        findViewById(R.id.view_next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
                intent.putExtra(NUMBER_EXTRA_KEY, ++mNumber);
                startActivity(intent);
                overridePendingTransition(R.anim.in, R.anim.out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in, R.anim.out);
    }
}
