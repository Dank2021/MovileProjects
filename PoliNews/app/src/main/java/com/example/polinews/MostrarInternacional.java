package com.example.polinews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MostrarInternacional extends AppCompatActivity {

    Button articulo1, articulo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_internacional);

        articulo1 = (Button) findViewById(R.id.btnArtInternacional1);
        articulo2 = (Button) findViewById(R.id.btnArtInternacional2);

        articulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarInternacional.this, ArtInternacional1.class);
                startActivity(i);
            }
        });

        articulo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MostrarInternacional.this, ArtInternacional2.class);
                startActivity(i);
            }
        });

    }
}