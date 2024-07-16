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

public class Siesta extends AppCompatActivity {
    ImageView imageManana, imageTarde, image15, image30, image45, image60, btnAtras;

    Button btnSiesta;

    TextView tvResultado, tvResultado2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siesta);

        btnAtras = findViewById(R.id.btnAtras);
        btnSiesta = findViewById(R.id.btnSiesta);

        imageManana = findViewById(R.id.imageManana);
        imageTarde = findViewById(R.id.imageTarde);

        tvResultado = findViewById(R.id.textResultado);

        imageManana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Por la mañana");
            }
        });

        imageTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("Por la tarde");
            }
        });

        /////////////////////////////////////////////////////////////////

        image15 = findViewById(R.id.image15);
        image30 = findViewById(R.id.image30);
        image45 = findViewById(R.id.image45);
        image60 = findViewById(R.id.image60);

        tvResultado2 = findViewById(R.id.textResultado2);

        image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("15 minutos");
            }
        });

        image30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("30 minutos");
            }
        });

        image45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("45 minutos");
            }
        });

        image60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado2.setText("60 minutos");
            }
        });

        btnSiesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tvResulSiesta = tvResultado.getText().toString();
                String tvResul2Siesta = tvResultado2.getText().toString();

                if(tvResulSiesta.isEmpty()) {
                    Toast.makeText(Siesta.this, "Ingrese Momento de la Siesta", Toast.LENGTH_SHORT).show();
                }
                if(tvResul2Siesta.isEmpty()) {
                    Toast.makeText(Siesta.this, "Ingrese Duración de Siesta ", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(Siesta.this, Crear_informe.class);
                startActivity(intent);

                SharedPreferences sharedPreferences3 = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences3.edit();
                editor.putString("tvResulSiesta", tvResulSiesta);
                editor.putString("tvResul2Siesta", tvResul2Siesta);
                editor.apply();
            }
        });

        //////////////////////////////////////////////////

        // BOTON ATRAS
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Siesta.this, Crear_informe.class);
                startActivity(intent);
            }
        });

    }
}