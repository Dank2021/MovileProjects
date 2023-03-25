package com.example.parciali;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numero_one, numero_two;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero_one = (EditText) findViewById(R.id.numberOne);
        numero_two = (EditText) findViewById(R.id.numberTwo);
        calculate  = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num1 = Double.parseDouble(numero_one.getText().toString());
                    double num2 = Double.parseDouble(numero_two.getText().toString());

                    Intent i = new Intent(MainActivity.this, MostrarDatos.class);

                    i.putExtra("a", num1);
                    i.putExtra("b", num2);

                    startActivity(i);

                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Ingrese números válidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}