package com.example.parciali;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarDatos extends AppCompatActivity {

    TextView tvsuma, tvresta, tvmultiplicacion, tvdivision, tvtitulo;
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        tvsuma = (TextView)findViewById(R.id.suma);
        tvresta = (TextView)findViewById(R.id.resta);
        tvmultiplicacion = (TextView)findViewById(R.id.multiplicacion);
        tvdivision = (TextView)findViewById(R.id.division);
        tvtitulo =  (TextView)findViewById(R.id.textView2);
        btnOk = (Button)findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MostrarDatos.this, MainActivity.class );
                startActivity(intent);
            }
        });
        mostrarDato();
    }

    @SuppressLint("SuspiciousIndentation")
    private void mostrarDato() {
        Bundle datos = this.getIntent().getExtras();
        double num1 = datos.getDouble("a");
        double num2 = datos.getDouble("b");

        tvtitulo.setText("RESULTADOS ("+num1+" & "+num2+")");
        tvsuma.setText( Double.toString(num1+num2));
        tvresta.setText(Double.toString(num1-num2));
        tvmultiplicacion.setText(Double.toString(num1*num2));
        if (num2 == 0) {
            Toast.makeText(getApplicationContext(), "Error: no se puede dividir por cero", Toast.LENGTH_SHORT).show();
            tvdivision.setText("Error: no se puede dividir por cero");
            return;
        }else
        tvdivision.setText(Double.toString(num1/num2));

    }
}