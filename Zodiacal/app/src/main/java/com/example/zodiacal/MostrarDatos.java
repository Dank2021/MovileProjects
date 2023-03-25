package com.example.zodiacal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MostrarDatos extends AppCompatActivity {

    TextView tvsigno;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvsigno = (TextView)findViewById(R.id.resultado);
        btnOk = (Button)findViewById(R.id.okBoton);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MostrarDatos.this, MainActivity.class );
                startActivity(intent);
            }
        });

        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String fecha = datos.getString("date");

        tvsigno.setText(leerFecha(nombre, fecha));
    }
    static String calcularSigno(int dia_Nacimiento, Month mes_Nacimiento) {
        String signo = "";
        if ((mes_Nacimiento == Month.MARCH && dia_Nacimiento >= 21) || (mes_Nacimiento == Month.APRIL && dia_Nacimiento <= 19)) {
            signo = "Aries";
        } else if ((mes_Nacimiento == Month.APRIL && dia_Nacimiento >= 20) || (mes_Nacimiento == Month.MAY && dia_Nacimiento <= 20)) {
            signo = "Tauro";
        } else if ((mes_Nacimiento == Month.MAY && dia_Nacimiento >= 21) || (mes_Nacimiento == Month.JUNE && dia_Nacimiento <= 20)) {
            signo = "Géminis";
        } else if ((mes_Nacimiento == Month.JUNE && dia_Nacimiento >= 21) || (mes_Nacimiento == Month.JULY && dia_Nacimiento <= 20)) {
            signo = "Cáncer";
        } else if ((mes_Nacimiento == Month.JULY && dia_Nacimiento >= 21) || (mes_Nacimiento == Month.AUGUST && dia_Nacimiento <= 22)) {
            signo = "Leo";
        } else if ((mes_Nacimiento == Month.AUGUST && dia_Nacimiento >= 23) || (mes_Nacimiento == Month.SEPTEMBER && dia_Nacimiento <= 23)) {
            signo = "Virgo";
        } else if ((mes_Nacimiento == Month.SEPTEMBER && dia_Nacimiento >= 24) || (mes_Nacimiento == Month.OCTOBER && dia_Nacimiento <= 23)) {
            signo = "Libra";
        } else if ((mes_Nacimiento == Month.OCTOBER && dia_Nacimiento >= 24) || (mes_Nacimiento == Month.NOVEMBER && dia_Nacimiento <= 22)) {
            signo = "Escorpio";
        } else if ((mes_Nacimiento == Month.NOVEMBER && dia_Nacimiento >= 23) || (mes_Nacimiento == Month.DECEMBER && dia_Nacimiento <= 22)) {
            signo = "Sagitario";
        } else if ((mes_Nacimiento == Month.DECEMBER && dia_Nacimiento >= 23) || (mes_Nacimiento == Month.JANUARY && dia_Nacimiento <= 22)) {
            signo = "Capricornio";
        } else if ((mes_Nacimiento == Month.JANUARY && dia_Nacimiento >= 23) || (mes_Nacimiento == Month.FEBRUARY && dia_Nacimiento <= 20)) {
            signo = "Acuario";
        } else if ((mes_Nacimiento == Month.FEBRUARY && dia_Nacimiento >= 21) || (mes_Nacimiento == Month.MARCH && dia_Nacimiento <= 20)) {
            signo = "Picis";
        } else {
            signo = "desconocido";
        }
        return signo;
    }

    public String leerFecha(String nom, String fec) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = null;

        try {
            fechaNacimiento = LocalDate.parse(fec, formatter);  //Leer Fecha Nacimiento
        } catch (Exception e) { //En caso de digitar mal la fecha:
            Toast.makeText(getApplicationContext(), "Fecha Invalida", Toast.LENGTH_SHORT).show();
            return "FECHA INVALIDA. Dijite fecha con formato (dd/MM/YYYY). Ejemplo: 05/03/2023 ";
        }
        // Cálculo de la edad
        LocalDate hoy = LocalDate.now();    //Fecha Actual
        int edad = Period.between(fechaNacimiento, hoy).getYears();     //Edad

        return "Hola "+nom+" tienes "+edad+" años y tu signo zodiacal es "+ calcularSigno(fechaNacimiento.getDayOfMonth(),fechaNacimiento.getMonth());
    }

}