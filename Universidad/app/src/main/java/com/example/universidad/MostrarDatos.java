package com.example.universidad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {

    TextView mostrar;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        mostrar = (TextView) findViewById(R.id.tArea);
        volver =  (Button) findViewById(R.id.botonVolver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(MostrarDatos.this, MainActivity.class);
                startActivity(inte);
            }
        });

        Bundle datos= this.getIntent().getExtras();
        String nombre, seleccionado;
        nombre = datos.getString("name");
        seleccionado = datos.getString("sel");

        Boolean masculino, femenino, ingenieria, administracion, derecho, medicina;
        masculino = datos.getBoolean("male");
        femenino = datos.getBoolean("female");
        ingenieria = datos.getBoolean("ing");
        administracion = datos.getBoolean("adm");
        derecho = datos.getBoolean("der");
        medicina = datos.getBoolean("med");

        String respuesta = "Hola, "+nombre;

        if (femenino == true) {
            respuesta += " tu genero es: femenino";
        }else if (masculino == true){
            respuesta += " tu genero es: masculino";
        }else {
            respuesta += " NO SELECCIONÓ GENERO";
        }

        if (ingenieria == true) {
            respuesta += " tu facultad es la de: Ingeniería";
        } else if (derecho == true) {
            respuesta += " tu facultad es la de: Derecho";
        } else if (administracion == true) {
            respuesta += " tu facultad es la de: Administración";
        } else if (medicina == true) {
            respuesta += " tu facultad es la de: Medicina";
        }else respuesta += " NO SELECCIONÓ FACULTAD";

        respuesta += " y tu carrera es: "+seleccionado;
        mostrar.setText(respuesta);
    }
}