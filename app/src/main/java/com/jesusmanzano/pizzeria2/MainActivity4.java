package com.jesusmanzano.pizzeria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    Button Piza;
    Button suma;
    Button Suma2;
    Button Suma3;
    Button Resta;
    Button Resta2;
    Button Resta3;
    Button Pagar;
    ImageButton Atras;
    TextView Cantidad;
    TextView Cantidad2;
    TextView Cantidad3;
    TextView pago;
    double Fanta = 12.0;
    double Coca = 15.0;
    double Sprite = 10.0;
    double total = 0.0;

    int cantidadActual = 0;
    int cantidadActual2 = 0;
    int cantidadActual3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Piza = findViewById(R.id.piza);
        suma = findViewById(R.id.suma);
        Resta = findViewById(R.id.resta);
        Cantidad = findViewById(R.id.cantidad1);
        Suma2 = findViewById(R.id.suma2);
        Resta2 = findViewById(R.id.resta2);
        Cantidad2 = findViewById(R.id.cantidad2);
        Suma3 = findViewById(R.id.suma3);
        Resta3 = findViewById(R.id.resta3);
        Cantidad3 = findViewById(R.id.cantidad3);
        Atras = findViewById(R.id.atras);
        Pagar = findViewById(R.id.pagar);
        pago = findViewById(R.id.pago);


        Piza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity4.this, MainActivity3.class);
                startActivity(intentPizza);
            }
        });
        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(intentPizza);
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual++;
                actualizarCantidad();
            }
        });

        Resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual > 0) {
                    cantidadActual--;
                    actualizarCantidad();
                }
            }
        });

        Suma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual2++;
                actualizarCantidad2();
            }
        });

        Resta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual2 > 0) {
                    cantidadActual2--;
                    actualizarCantidad2();
                }
            }
        });

        Suma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual3++;
                actualizarCantidad3();
            }
        });

        Resta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual3 > 0) {
                    cantidadActual3--;
                    actualizarCantidad3();
                }
            }
        });
        Pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity4.this, MainActivity5.class);
                startActivity(intentPizza);
            }
        });


    }


    // Actualiza el TextView de cantidad y calcula el total
    private void actualizarCantidad() {
        Cantidad.setText(String.valueOf(cantidadActual));
        total = cantidadActual * Fanta;
        mostrarTotal();
        // Guardamos el total en SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("Cantidad", (int) cantidadActual);
        editor.apply();
    }

    private void actualizarCantidad2() {
        Cantidad2.setText(String.valueOf(cantidadActual2));
        total += cantidadActual2 * Coca;
        mostrarTotal();

        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("Cantidad2", (int) cantidadActual2);
        editor.apply();
    }

    private void actualizarCantidad3() {
        Cantidad3.setText(String.valueOf(cantidadActual3));
        total += cantidadActual3 * Sprite; // Suma al total existente
        mostrarTotal();


        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("Cantidad3", (int) cantidadActual3);
        editor.apply();
    }


    private void mostrarTotal() {
        total = cantidadActual * Fanta + cantidadActual2 * Coca + cantidadActual3 * Sprite;
        pago.setText("Total: $" + total);

        // Guardamos el total en SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("totalGuardado", (float) total);
        editor.apply();
    }

}
