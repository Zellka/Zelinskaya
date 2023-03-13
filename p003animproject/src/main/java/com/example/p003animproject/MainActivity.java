package com.example.p003animproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView carImageView = findViewById(R.id.car);
        Animation travelAnimation = AnimationUtils.loadAnimation(this, R.anim.travel);
        carImageView.startAnimation(travelAnimation);
    }
}