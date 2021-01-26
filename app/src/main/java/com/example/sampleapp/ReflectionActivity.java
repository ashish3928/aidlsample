package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionActivity extends AppCompatActivity {

    private AllPrivateData data = new AllPrivateData();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = findViewById(R.id.textView);
        textView.setText(data.toString());
    }

    public void invokeReflection(View view) {
        Method[]methods = data.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            try {
                Object object = method.invoke(data);
                android.util.Log.d("Ashish", object.toString());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        try {
            Field field = data.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(data, 5);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        textView.setText(data.toString());
    }
}