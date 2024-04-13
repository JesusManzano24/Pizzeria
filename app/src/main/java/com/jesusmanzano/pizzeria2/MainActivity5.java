package com.jesusmanzano.pizzeria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    TextView textViewUser;
    TextView textViewCantidadActual;
    TextView textViewCantidadActual2;
    TextView textViewCantidadActual3;
    TextView textViewTotal;
    TextView textViewCantidadActualP;
    TextView textViewCantidadActual2P;
    TextView textViewCantidadActual3P;
    Button pago2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Inicialización de los TextViews
        textViewUser = findViewById(R.id.usuario); // Asegúrate de tener un TextView con el id 'usuario' en tu layout
        textViewCantidadActual = findViewById(R.id.cantidad);
        textViewCantidadActual2 = findViewById(R.id.cantidad2);
        textViewCantidadActual3 = findViewById(R.id.cantidad3);
        textViewTotal = findViewById(R.id.total);
        textViewCantidadActualP = findViewById(R.id.cantidad4);
        textViewCantidadActual2P = findViewById(R.id.cantidad5);
        textViewCantidadActual3P = findViewById(R.id.cantidad6);
        pago2 = findViewById(R.id.Pagar2);
        pago2 = findViewById(R.id.Pagar2);


        SharedPreferences prefs = getSharedPreferences(MainActivity.Datos, MODE_PRIVATE);
        String user = prefs.getString("username", "Usuario no definido");


        String personalizedMessage = "Hola estimado " + user + ",Los productos que has seleccionado son";
        textViewUser.setText(personalizedMessage);


        pago2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar un mensaje de agradecimiento
                Toast.makeText(MainActivity5.this, "Gracias por usar la aplicación de El chuchito, su pedido va en camino", Toast.LENGTH_LONG).show();

            }
        });
        recuperarValores();
    }

    private void recuperarValores() {
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        int cantidadActual = prefs.getInt("cantidadActual", 0); // El segundo parámetro es el valor por defecto
        int cantidadActual2 = prefs.getInt("cantidadActual2", 0);
        int cantidadActual3 = prefs.getInt("cantidadActual3", 0);
        float total = prefs.getFloat("totalGuardado", 0f);

        // Actualizar los TextViews con los valores recuperados
        textViewCantidadActual.setText(String.valueOf(cantidadActual));
        textViewCantidadActual2.setText(String.valueOf(cantidadActual2));
        textViewCantidadActual3.setText(String.valueOf(cantidadActual3));
        textViewTotal.setText("Total: $" + total);
    }
}