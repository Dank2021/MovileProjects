package com.example.polinews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MostrarTecnologia extends AppCompatActivity {
    Button articulo1,articulo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_tecnologia);

        articulo1 = (Button) findViewById(R.id.btnArtTecnologia1);
        articulo2 = (Button) findViewById(R.id.btnArtTecnologia2);

        articulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTecnologia.this, ArtTecnologia1.class);
                startActivity(i);
            }
        });

        articulo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarTecnologia.this, ArtTecnologia2.class);
                startActivity(i);
            }
        });


    }
}