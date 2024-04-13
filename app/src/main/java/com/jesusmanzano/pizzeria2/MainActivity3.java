package com.jesusmanzano.pizzeria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button Refrescos;
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
    double Pizzapastor = 10.0;
    double Pizzapierna= 15.0;
    double Pizzasalchicha = 20.0;
    double totalp = 0.0;

    int cantidadActualp = 0;
    int cantidadActual2p = 0;
    int cantidadActual3p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Refrescos = findViewById(R.id.refresco);
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
        pago = findViewById(R.id.pago);


        Refrescos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intentPizza);
            }
        });

        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intentPizza);
            }
        });

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActualp++;
                actualizarCantidad();
            }
        });

        Resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActualp > 0) {
                    cantidadActualp--;
                    actualizarCantidad();
                }
            }
        });

        Suma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual2p++;
                actualizarCantidad2();
            }
        });

        Resta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual2p > 0) {
                    cantidadActual2p--;
                    actualizarCantidad2();
                }
            }
        });

        Suma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidadActual3p++;
                actualizarCantidad3();
            }
        });

        Resta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidadActual3p > 0) {
                    cantidadActual3p--;
                    actualizarCantidad3();
                }
            }
        });

    }

    /// Actualiza el TextView de cantidad y calcula el total
    private void actualizarCantidad() {
        Cantidad.setText(String.valueOf(cantidadActualp));
        totalp = cantidadActualp * Pizzapastor;
        mostrarTotal();
        // Guardamos el total en SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("Cantidad", (int) cantidadActualp);
        editor.apply();
    }
    private void actualizarCantidad2() {
        Cantidad2.setText(String.valueOf(cantidadActual2p));
        totalp += cantidadActual2p * Pizzapierna;
        mostrarTotal();

        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("Cantidad2", (int) cantidadActual2p);
        editor.apply();
    }
    private void actualizarCantidad3() {
        Cantidad3.setText(String.valueOf(cantidadActual3p));
        totalp += cantidadActual3p * Pizzasalchicha; // Suma al total existente
        mostrarTotal();
        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("Cantidad3", (int) cantidadActual3p);
        editor.apply();
    }
    private void mostrarTotal() {
        totalp = cantidadActualp * Pizzapastor + cantidadActual2p * Pizzapierna + cantidadActual3p * Pizzasalchicha;
        pago.setText("Total: $" + totalp);

        // Guardamos el total en SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MisPreferencias", MODE_PRIVATE).edit();
        editor.putFloat("totalGuardadop", (float) totalp);
        editor.apply();
    }

}
