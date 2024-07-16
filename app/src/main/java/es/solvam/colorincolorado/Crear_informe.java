package es.solvam.colorincolorado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Crear_informe extends AppCompatActivity {
    mySQL mysql;
    ImageView salud, alimentacion, siesta, verInforme, btnAtras;

    Intent intent;

    RecyclerView rv;
    ArrayList<Alumnos> datosAlumnos = new ArrayList<Alumnos>();

    RecyAdapter adaptador;

    TextView tvRecibidoNom, tvRecibidoApe;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_informe);

        verInforme = findViewById(R.id.imgVerInforme);
        btnAtras = findViewById(R.id.btnAtras);

        salud = findViewById(R.id.imageCorazon);
        alimentacion = findViewById(R.id.imageAlimentacion);
        siesta = findViewById(R.id.imageCuna);

        tvRecibidoNom = findViewById(R.id.textNomRecibido);
        tvRecibidoApe = findViewById(R.id.textApeRecibido);

        String usuarioNom = getIntent().getStringExtra("nombre");
        String usuarioApe = getIntent().getStringExtra("apellido");

        tvRecibidoNom.setText(usuarioNom);
        tvRecibidoApe.setText(usuarioApe);

        salud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Crear_informe.this, Salud.class);
                startActivity(intent);
            }
        });
        alimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Crear_informe.this, Alimentacion.class);
                startActivity(intent);
            }
        });

        siesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Crear_informe.this, Siesta.class);
                startActivity(intent);
            }
        });

        verInforme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Crear_informe.this, Ver_informe.class);
                startActivity(intent);
            }
        });

        // BOTON ATRAS
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Crear_informe.this, Listar_alumno.class);
                startActivity(intent);
            }
        });

    }




}