package com.jesusmanzano.pizzeria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageButton Pizza;
    ImageButton Refrescos;
    TextView textViewUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Pizza = findViewById(R.id.Pizza);
        Refrescos = findViewById(R.id.Refrescos);
        textViewUser = findViewById(R.id.textViewUser);


        // Recuperamos el nombre del usuario de SharedPreferences
        SharedPreferences prefs = getSharedPreferences(MainActivity.Datos, MODE_PRIVATE);
        String user = prefs.getString("username", "Usuario no definido");

        // Configuramos el mensaje personalizado con el nombre del usuario
        String personalizedMessage = "Hola estimado " + user + ", ¿qué te podemos llevar hasta tu casa este día? Por favor, Selecciona";
        textViewUser.setText(personalizedMessage);
        textViewUser.setText(user);

        Pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPizza = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intentPizza);
            }
        });

        Refrescos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRefrescos = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intentRefrescos);
            }
        });
    }
}