package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.Field;

public class ReflectionActivity extends AppCompatActivity {

    private AllPrivateData data = new AllPrivateData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Field []field = data.getClass().getDeclaredFields();

        for (Field field1 : field) {
            field1.setAccessible(true);
        }

    }
}