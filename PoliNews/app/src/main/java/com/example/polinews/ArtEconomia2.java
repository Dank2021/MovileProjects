package com.example.polinews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArtEconomia2 extends AppCompatActivity {

    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_economia2);

        volver = (Button) findViewById(R.id.btnMenu);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ArtEconomia2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}