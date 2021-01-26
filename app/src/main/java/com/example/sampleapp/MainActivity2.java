package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        button1.setOnClickListener(v -> startActivity(new Intent(this, AIDLActivity.class)));

        button2.setOnClickListener(v -> startActivity(new Intent(this, RecyclerViewActivity.class)));

        button3.setOnClickListener(v -> startActivity(new Intent(this, ReflectionActivity.class)));
    }
}