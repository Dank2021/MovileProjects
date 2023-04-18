package com.example.universidad;

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

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    RadioButton rbMasculino, rbFemenino;
    CheckBox chbIngenieria, chbDerecho, chbAdministracion, chbMedicina;
    Spinner spProgramas;
    Button btIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre    =  (EditText) findViewById(R.id.campoNombre);
        btIngresar =  (Button) findViewById(R.id.botonIngresarDatos);
        rbMasculino =  (RadioButton) findViewById(R.id.rBMasculino);
        rbFemenino =  (RadioButton)findViewById(R.id.rBFemenino);
        chbIngenieria = (CheckBox)findViewById(R.id.cBIngenieria);
        chbDerecho = (CheckBox)findViewById(R.id.cBDerecho);
        chbAdministracion = (CheckBox)findViewById(R.id.cBAdministracion);
        chbMedicina = (CheckBox)findViewById(R.id.cBMedicina);
        spProgramas = (Spinner)findViewById(R.id.spProgramas);

        String [] programas = {"Seleccionar","Ing.Sistemas", "Ing,Industrial", "Derecho", "Ciencias Politicas",
                "Medicina", "Enfermeria", "Administracion", "Economica"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, programas);
        spProgramas.setAdapter(adaptador);

        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cap_nombre, seleccionado;
                cap_nombre = nombre.getText().toString();
                seleccionado = spProgramas.getSelectedItem().toString();

                Boolean cap_masculino, cap_femenino, cap_ing, cap_der, cap_adm, cap_med;
                cap_masculino = rbMasculino.isChecked();
                cap_femenino = rbFemenino.isChecked();
                cap_ing = chbIngenieria.isChecked();
                cap_der = chbDerecho.isChecked();
                cap_adm = chbAdministracion.isChecked();
                cap_med = chbMedicina.isChecked();

                Intent i = new Intent(MainActivity.this, MostrarDatos.class);
                i.putExtra("name", cap_nombre);
                i.putExtra("male", cap_masculino);
                i.putExtra("female", cap_femenino);
                i.putExtra("ing", cap_ing);
                i.putExtra("der", cap_der);
                i.putExtra("adm", cap_adm);
                i.putExtra("med", cap_med);
                i.putExtra("sel", seleccionado);

                startActivity(i);
            }
        });

    }
}