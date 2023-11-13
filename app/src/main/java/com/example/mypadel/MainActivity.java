package com.example.mypadel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // variables que detallan el numero de sets
    int setsJ1=0;
    int setsJ2=0;
    // variables que detallan el numero de juegos
    int juegosJ1=0;
    int juegosJ2=0;


    //variable que indica los set necesarios para ganar
    int setsParaGanar=2;
    //declaramos las variables
    Button btPuntoEquipo1,btPuntoEquipo2;

    TextView textViewMarcador1;

    TextView textViewMarcador2;
    TextView textView1_1,textView1_2,textView2_1,textView2_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //inicia las referencias de las vistas. metodo privado abajo
        initReferences();

        // generamos los listeners de los botones

        btPuntoEquipo1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String punto = textViewMarcador1.getText().toString();

                switch (punto) {
                    case "00":
                        textViewMarcador1.setText("15");
                        break;
                    case "15":
                        textViewMarcador1.setText("30");
                        break;
                    case "30":
                        textViewMarcador1.setText("40");
                        break;
                    case "40":
                        // Check if the game is won
                        if (juegosJ1 < 5) {
                            juegosJ1++;
                            textView1_2.setText(String.valueOf(juegosJ1));
                            textViewMarcador1.setText("00");
                            textViewMarcador2.setText("00");
                        } else {
                            // Check if the set is won
                            if (setsJ1 < 2) {
                                setsJ1++;
                                textView1_1.setText(String.valueOf(setsJ1));
                                // reseteamos marcadores del set jugado
                                juegosJ1 = 0;
                                juegosJ2 = 0;
                                textView2_2.setText(String.valueOf(juegosJ2));
                                textView1_2.setText(String.valueOf(juegosJ1));
                                textViewMarcador1.setText("00");
                                textViewMarcador2.setText("00");
                            } if(setsJ1==2){
                                // jugadores 1 ganan el partido y reseteamos todo.
                                Toast.makeText(MainActivity.this, "GANADORES JUGADORES 1 !!", Toast.LENGTH_SHORT).show();
                                juegosJ1 = 0;
                                juegosJ2 = 0;
                                textView2_2.setText(String.valueOf(juegosJ2));
                                textView1_2.setText(String.valueOf(juegosJ1));
                                textViewMarcador1.setText("00");
                                textViewMarcador2.setText("00");
                                setsJ1=0;
                                textView1_1.setText(String.valueOf(setsJ1));
                                setsJ2=0;
                                textView2_1.setText(String.valueOf(setsJ1));

                            }
                        }
                        break;
                }
            }
        });

        btPuntoEquipo2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String punto = textViewMarcador2.getText().toString();

                switch (punto) {
                    case "00":
                        textViewMarcador2.setText("15");
                        break;
                    case "15":
                        textViewMarcador2.setText("30");
                        break;
                    case "30":
                        textViewMarcador2.setText("40");
                        break;
                    case "40":
                        // Check if the game is won
                        if (juegosJ2 < 5) {
                            juegosJ2++;
                            textView2_2.setText(String.valueOf(juegosJ2));
                            textViewMarcador2.setText("00");
                            textViewMarcador1.setText("00");
                        } else {
                            // Check if the set is won
                            if (setsJ2 < 2) {
                                setsJ2++;
                                textView2_1.setText(String.valueOf(setsJ2)); // Corrected the typo here
                                // Reset game score
                                juegosJ1 = 0;
                                juegosJ2 = 0;
                                textView2_2.setText(String.valueOf(juegosJ2));
                                textView1_2.setText(String.valueOf(juegosJ1));
                                textViewMarcador1.setText("00");
                                textViewMarcador2.setText("00");
                            } if (setsJ2==2){
                                // jugadores 2 ganan el partido y reseteamos todo.
                                Toast.makeText(MainActivity.this, "GANADORES JUGADORES 2 !!", Toast.LENGTH_SHORT).show();
                                juegosJ1 = 0;
                                juegosJ2 = 0;
                                textView2_2.setText(String.valueOf(juegosJ2));
                                textView1_2.setText(String.valueOf(juegosJ1));
                                textViewMarcador1.setText("00");
                                textViewMarcador2.setText("00");
                                setsJ1=0;
                                textView1_1.setText(String.valueOf(setsJ1));
                                setsJ2=0;
                                textView2_1.setText(String.valueOf(setsJ1));
                                // Handle match-winning logic here
                            }
                        }
                        break;
                }
            }
        });
    }


    private void initReferences(){
        btPuntoEquipo1=findViewById(R.id.puntoJ1);
        btPuntoEquipo2=findViewById(R.id.puntoJ2);
        textViewMarcador1=findViewById(R.id.marcadorJ1);
        textViewMarcador2=findViewById(R.id.marcadorJ2);
        textView1_1=findViewById(R.id.setsJ1);
        textView1_2=findViewById(R.id.juegoJ1);
        textView2_1=findViewById(R.id.setsJ2);
        textView2_2=findViewById(R.id.juegoJ2);



    }
}