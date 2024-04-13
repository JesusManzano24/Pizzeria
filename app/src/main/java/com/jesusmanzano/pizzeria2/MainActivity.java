package com.jesusmanzano.pizzeria2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    EditText editTextUser;
    EditText editTextPassword;
    VideoView videoView;
    public static final String Datos = "MyPrefsFile"; // Nombre del archivo de preferencias

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.user);
        editTextPassword = findViewById(R.id.password);
        videoView = findViewById(R.id.video1);


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pizzaanimada;
        videoView.setVideoPath(videoPath);

        // Reproduce el video en bucle
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });

        Button Inicio = findViewById(R.id.Inicio);
        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();

                if (user.equals("Jesus") && password.equals("1234")) {
                    SharedPreferences.Editor editor = getSharedPreferences(Datos, MODE_PRIVATE).edit();
                    editor.putString("username", user);
                    editor.apply();

                    // Continuamos con el inicio de la siguiente actividad
                    Intent intent = new Intent(v.getContext(), MainActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}