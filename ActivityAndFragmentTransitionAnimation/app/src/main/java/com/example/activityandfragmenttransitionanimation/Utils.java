package com.example.activityandfragmenttransitionanimation;

import android.graphics.Color;

import java.util.Random;

public class Utils {

    public static int generateRandomColor(final Random random) {
        return Color.argb(
                0xff,
                (int) (random.nextDouble() * 255),
                (int) (random.nextDouble() * 255),
                (int) (random.nextDouble() * 255)
        );
    }
}
