package es.solvam.colorincolorado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Salud extends AppCompatActivity {
    ImageView imgTriste, imgNeutral, imgEnfadado, imgFeliz, imgL, imgB, imgN, imgD, img0, img1, img2, img3, btnAtras;

    Button btnSalud;

    TextView tvResultado, tvResultado2, tvResultado3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salud);

        btnAtras = findViewById(R.id.btnAtras);
        btnSalud = findViewById(R.id.btnSalud);

        /////// ESTADO DE ANIMO ///////////
        imgTriste = findViewById(R.id.imageTriste);
        imgNeutral = findViewById(R.id.imageNeutral);
        imgEnfadado = findViewById(R.id.imageEnfadado);
        imgFeliz = findViewById(R.id.imageFeliz);

        tvResultado = findViewById(R.id.textResultado);

        imgTriste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Triste");
            }
        });

        imgNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Neutral");
            }
        });

        imgEnfadado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Enfadado");
            }
        });

        imgFeliz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Feliz");
            }
        });

        //////////////////////////////////////////////////

        /////// CONSISTENCIA PAÑAL ///////////
        imgL = findViewById(R.id.imageLiquida);
        imgB = findViewById(R.id.imageBlanda);
        imgN = findViewById(R.id.imageNormalC);
        imgD = findViewById(R.id.imageDura);

        tvResultado2 = findViewById(R.id.textResultado2);

        imgL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("Liquida");
            }
        });

        imgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("Blanda");
            }
        });

        imgN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("Normal");
            }
        });

        imgD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("Dura");
            }
        });

        //////////////////////////////////////////////////

        /////// NUMERO DE VECES CAMBIO PAÑAL ///////////

        img0 = findViewById(R.id.image0);
        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        img3 = findViewById(R.id.image3);

        tvResultado3 = findViewById(R.id.textResultado3);

        img0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvResultado3.setText("0");
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado3.setText("1");
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado3.setText("2");
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado3.setText("3");
            }
        });

        btnSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tvResulSalud = tvResultado.getText().toString();
                String tvResul2Salud = tvResultado2.getText().toString();
                String tvResul3Salud = tvResultado3.getText().toString();

                if(tvResulSalud.isEmpty()) {
                    Toast.makeText(Salud.this, "Ingrese Estado de Ánimo", Toast.LENGTH_SHORT).show();
                }
                if(tvResul2Salud.isEmpty()) {
                    Toast.makeText(Salud.this, "Ingrese Consistencia Pañal ", Toast.LENGTH_SHORT).show();
                }
                if(tvResul3Salud.isEmpty()) {
                    Toast.makeText(Salud.this, "Ingrese Num.Cambio Pañal ", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(Salud.this, Crear_informe.class);
                startActivity(intent);

                // Guarda el valor en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("tvResulSalud", tvResulSalud);
                editor.putString("tvResul2Salud", tvResul2Salud);
                editor.putString("tvResul3Salud", tvResul3Salud);
                editor.apply();
            }
        });

        //////////////////////////////////////////////////

        // BOTON ATRAS
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Salud.this, Crear_informe.class);
                startActivity(intent);
            }
        });
    }
}