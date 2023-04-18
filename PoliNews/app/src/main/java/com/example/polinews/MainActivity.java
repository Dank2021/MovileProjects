package com.example.polinews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button internacional, economia, tecnologia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internacional = (Button) findViewById(R.id.btnInternacional);
        economia = (Button) findViewById(R.id.btnEconomia);
        tecnologia = (Button) findViewById(R.id.btnTecnologia);

        internacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MostrarInternacional.class);
                startActivity(i);
            }
        });

        economia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MostrarEconomia.class);
                startActivity(i);
            }
        });

        tecnologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MostrarTecnologia.class);
                startActivity(i);
            }
        });
    }
}