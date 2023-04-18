package com.example.polinews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArtInternacional2 extends AppCompatActivity {

    Button volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_internacional2);

        volver = (Button) findViewById(R.id.btnMenu);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ArtInternacional2.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}