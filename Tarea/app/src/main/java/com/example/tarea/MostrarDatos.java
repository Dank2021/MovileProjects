package com.example.tarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {

    TextView tvnombre, tvapellidos, tvedad, tvcorreo;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvnombre = (TextView)findViewById(R.id.tvNombre);
        tvapellidos = (TextView)findViewById(R.id.tvApellidos);
        tvedad = (TextView)findViewById(R.id.tvEdad);
        tvcorreo = (TextView)findViewById(R.id.tvCorreo);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MostrarDatos.this, MainActivity.class );
                startActivity(intent);
            }
        });
        mostrarDatos();
    }

    private void mostrarDatos() {
        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String apellido = datos.getString("ape");
        String edad = datos.getString("eda");
        String correo = datos.getString("email");

        tvnombre.setText(nombre);
        tvapellidos.setText(apellido);
        tvedad.setText(edad);
        tvcorreo.setText(correo);

    }
}