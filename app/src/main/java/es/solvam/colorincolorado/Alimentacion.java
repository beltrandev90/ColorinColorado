package es.solvam.colorincolorado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Alimentacion extends AppCompatActivity {
    ImageView imgPoco, imgNormal, imgBien, imgPoco2, imgNormal2, imgBien2, imgPoco3, imgNormal3, imgBien3, btnAtras;

    Button btnAlimentacion;

    TextView tvResultado, tvResultado2, tvResultado3;

    ArrayList<String> toastResul = new ArrayList<String>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alimentacion);

        btnAtras = findViewById(R.id.btnAtras);
        btnAlimentacion = findViewById(R.id.btnAlimentacion);

        imgPoco = findViewById(R.id.imagePoco);
        imgNormal = findViewById(R.id.imageNormal);
        imgBien = findViewById(R.id.imageBien);

        tvResultado = findViewById(R.id.textResultado);


        imgPoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Poco");
            }
        });

        imgNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Normal");
            }
        });

        imgBien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Bien");
            }
        });


        //////////////////////////////////////////////////////////

        imgPoco2 = findViewById(R.id.imagePoco2);
        imgNormal2 = findViewById(R.id.imageNormal2);
        imgBien2 = findViewById(R.id.imageBien2);

        tvResultado2 = findViewById(R.id.textResultado2);

        imgPoco2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvResultado2.setText("Poco");
            }
        });

        imgNormal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("Normal");
            }
        });

        imgBien2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("Bien");
            }
        });

        /////////////////////////////////////////////////////////

        imgPoco3 = findViewById(R.id.imagePoco3);
        imgNormal3 = findViewById(R.id.imageNormal3);
        imgBien3 = findViewById(R.id.imageBien3);

        tvResultado3 = findViewById(R.id.textResultado3);

        imgPoco3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvResultado3.setText("Poco");
            }
        });

        imgNormal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado3.setText("Normal");
            }
        });

        imgBien3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado3.setText("Bien");

            }
        });

        btnAlimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tvResultadoS = tvResultado.getText().toString();
                String tvResultado2S = tvResultado2.getText().toString();
                String tvResultado3S = tvResultado3.getText().toString();


                if(tvResultadoS.isEmpty()) {
                    Toast.makeText(Alimentacion.this, "Ingrese Desayuno", Toast.LENGTH_SHORT).show();
                }
                if(tvResultado2S.isEmpty()) {
                    Toast.makeText(Alimentacion.this, "Ingrese Comida ", Toast.LENGTH_SHORT).show();
                }
                if(tvResultado3S.isEmpty()) {
                    Toast.makeText(Alimentacion.this, "Ingrese Merienda ", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(Alimentacion.this, Crear_informe.class);
                startActivity(intent);

                // Guarda el valor en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tvResultadoS", tvResultadoS);
                editor.putString("tvResultado2S", tvResultado2S);
                editor.putString("tvResultado3S", tvResultado3S);
                editor.apply();
            }
        });

        //////////////////////////////////////////////////

        // BOTON ATRAS
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Alimentacion.this, Crear_informe.class);
                startActivity(intent);
            }
        });

    }

}