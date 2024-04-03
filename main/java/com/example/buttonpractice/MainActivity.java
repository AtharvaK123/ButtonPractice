package com.example.buttonpractice;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();

                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

                button.setBackgroundColor(color);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button2.setText("Practice 2");

                Random d = new Random();

                int num = d.nextInt(50);
                button2.setTextSize(num);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    button2.setWidth(button2.getTextSizeUnit() + 1);
                    button2.setHeight(button2.getTextSizeUnit() + 1);
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cde = (String) button.getText();
                button.setText(button2.getText());
                button2.setText(cde);
            }
        });


    }
}