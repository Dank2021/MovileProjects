package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellidos, edad, correo;
    Button aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre       = (EditText) findViewById(R.id.Nombre);
        apellidos    = (EditText) findViewById(R.id.Apellido);
        edad         = (EditText) findViewById(R.id.Edad);
        correo       = (EditText) findViewById(R.id.Correo);
        aceptar      = (Button) findViewById(R.id.Aceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombre.getText().toString();
                String apellido = apellidos.getText().toString();
                String años = edad.getText().toString();
                String email = correo.getText().toString();

                Intent i = new Intent(MainActivity.this, MostrarDatos.class);

                i.putExtra("name", name);
                i.putExtra("ape", apellido);
                i.putExtra("eda", años);
                i.putExtra("email", email);
                startActivity(i);
            }
        });
    }
}