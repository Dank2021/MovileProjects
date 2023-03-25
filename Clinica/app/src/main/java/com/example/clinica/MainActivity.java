package com.example.clinica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText nombre, fecha;
    RadioButton rbRemoto, rbPresencial;
    CheckBox chbNoVacunado, chbVacunado1, chbVacunado2, chbVacunado3;
    Spinner spEspecialidad;
    Button btIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre    =  (EditText) findViewById(R.id.campoNombre);
        fecha    =  (EditText) findViewById(R.id.campoFecha);
        rbRemoto =  (RadioButton) findViewById(R.id.rBRemota);
        rbPresencial =  (RadioButton)findViewById(R.id.rBPresencial);
        chbNoVacunado = (CheckBox)findViewById(R.id.cBSinDosis);
        chbVacunado1 = (CheckBox)findViewById(R.id.cBPriDosis);
        chbVacunado2 = (CheckBox)findViewById(R.id.cBSegDosis);
        chbVacunado3 = (CheckBox)findViewById(R.id.cBTerDosis);
        spEspecialidad = (Spinner)findViewById(R.id.spProgramas);
        btIngresar =  (Button) findViewById(R.id.botonIngresarDatos);

        String [] programas = {"Seleccionar", "Medicina General","Cardiología", "Siquiatría", "Nefrología"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, programas);
        spEspecialidad.setAdapter(adaptador);

        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cap_nombre, cap_especialidad,cap_fecha;
                Boolean cap_remota, cap_presencial, cap_Vacunado0, cap_Vacunado1, cap_Vacunado2, cap_Vacunado3;

                cap_nombre = nombre.getText().toString();
                cap_fecha = fecha.getText().toString();

                cap_especialidad = spEspecialidad.getSelectedItem().toString();
                cap_remota = rbRemoto.isChecked();
                cap_presencial = rbPresencial.isChecked();
                cap_Vacunado0 = chbNoVacunado.isChecked();
                cap_Vacunado1 = chbVacunado1.isChecked();
                cap_Vacunado2 = chbVacunado2.isChecked();
                cap_Vacunado3 = chbVacunado3.isChecked();


                Intent i = new Intent(MainActivity.this, MostrarDatos.class);
                i.putExtra("name", cap_nombre);
                i.putExtra("espe", cap_especialidad);
                i.putExtra("fech", cap_fecha);
                i.putExtra("remo", cap_remota);
                i.putExtra("pres", cap_presencial);
                i.putExtra("vac0", cap_Vacunado0);
                i.putExtra("vac1", cap_Vacunado1);
                i.putExtra("vac2", cap_Vacunado2);
                i.putExtra("vac3", cap_Vacunado3);

                startActivity(i);

            }
        });
    }
}