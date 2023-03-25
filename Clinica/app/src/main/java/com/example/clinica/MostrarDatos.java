package com.example.clinica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MostrarDatos extends AppCompatActivity {

    TextView mostrar;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        mostrar = (TextView) findViewById(R.id.tRespuesta);
        volver =  (Button) findViewById(R.id.botonVolver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(MostrarDatos.this, MainActivity.class);
                startActivity(inte);
            }
        });

        Bundle datos= this.getIntent().getExtras();
        String nombre, especialidad, fecha;
        nombre = datos.getString("name");
        especialidad = datos.getString("espe");
        fecha = validarFecha(datos.getString("fech"));


        Boolean remota, presencial, v0, v1, v2, v3;
        remota = datos.getBoolean("remo");
        presencial = datos.getBoolean("pres");
        v0 = datos.getBoolean("vac0");
        v1 = datos.getBoolean("vac1");
        v2 = datos.getBoolean("vac2");
        v3 = datos.getBoolean("vac3");

        String respuesta = "Hola, "+nombre
                + "\nEscogiste la especialidad: "+especialidad
                + "\nFecha cita: "+fecha
                + "\nModadalidad: "+validarModalidad(presencial, remota)
                + "\nDosis: "+validarDosis(v0, v1, v2, v3);
        mostrar.setText(respuesta);
    }

    static String validarFecha(String date){
        try {
        DateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");

        Date fecha = formatoEntrada.parse(date);

        Calendar calendario = Calendar.getInstance();


            calendario.setTime(fecha);
            int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

            if (diaSemana == Calendar.SUNDAY) {
                return "No hay servicio los domingos.";
            } else {
                return formatoEntrada.format(fecha);
            }
        } catch (ParseException e) {
            return "FECHA INVALIDA. Dijite fecha con formato (dd/MM/YYYY). Ejemplo: 05/03/2023 ";
        }
    }


    static String validarModalidad(Boolean presencial, Boolean remoto){

        if (presencial == true) {
            return "Presencial";
        } else if (remoto == true) {
            return "Remota";
        }
        else{
            return "No ha seleccionado modalidada";
        }
    }

    static String validarDosis(Boolean v0, Boolean v1, Boolean v2, Boolean v3){

        if (v0 == true) {
            return "No vacunado";
        } else if (v1 == true) {
            return "Vacunado 1 dosis";
        } else if (v2 == true) {
            return "Vacunado 2 dosis";
        } else if (v3 == true) {
            return "Vacunado 3 dosis";
        }else{
            return "No ha seleccionado opcion de dosis";
        }
    }
}