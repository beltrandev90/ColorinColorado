package es.solvam.colorincolorado;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Ver_informe extends AppCompatActivity {

    TextView tvRecibidoNom, tvRecibidoApe;
    ImageView imgCompartir, btnAtras;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_informe);

        imgCompartir = findViewById(R.id.imageCompartir);
        btnAtras = findViewById(R.id.btnAtras);

        tvRecibidoNom = findViewById(R.id.textNomRecibido);
        tvRecibidoApe = findViewById(R.id.textApeRecibido);

        String usuarioNom = getIntent().getStringExtra("nombre2");
        String usuarioApe = getIntent().getStringExtra("apellido2");

        tvRecibidoNom.setText(usuarioNom);
        tvRecibidoApe.setText(usuarioApe);

        // SALUD
        // Recupera el valor de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        String tvResulSalud = sharedPreferences.getString("tvResulSalud", "");
        String tvResul2Salud = sharedPreferences.getString("tvResul2Salud", "");
        String tvResul3Salud = sharedPreferences.getString("tvResul3Salud", "");

        // Usa el valor recuperado
        TextView textView1 = findViewById(R.id.textResulEstadoAnimo);
        textView1.setText(tvResulSalud);
        TextView textView2 = findViewById(R.id.textConsistenciaPanal);
        textView2.setText(tvResul2Salud);
        TextView textView3 = findViewById(R.id.textResulVecesPanal);
        textView3.setText(tvResul3Salud);

        //////////////////////////////////////////////////////////////////////////////////////////

        // ALIMENTACION

        SharedPreferences sharedPreferences2 = getSharedPreferences("prefs", MODE_PRIVATE);
        String tvResultadoS = sharedPreferences2.getString("tvResultadoS", "");
        String tvResultado2S = sharedPreferences2.getString("tvResultado2S", "");
        String tvResultado3S = sharedPreferences2.getString("tvResultado3S", "");

        TextView textView1_2 = findViewById(R.id.textResulDesayuno);
        textView1_2.setText(tvResultadoS);
        TextView textView2_2 = findViewById(R.id.textResulComida);
        textView2_2.setText(tvResultado2S);
        TextView textView3_2 = findViewById(R.id.textResulMerienda);
        textView3_2.setText(tvResultado3S);

        //////////////////////////////////////////////////////////////////////////////////////////

        // SIESTA
        SharedPreferences sharedPreferences3 = getSharedPreferences("prefs", MODE_PRIVATE);
        String tvResulSiesta = sharedPreferences3.getString("tvResulSiesta", "");
        String tvResul2Siesta = sharedPreferences3.getString("tvResul2Siesta", "");

        TextView textView1_3 = findViewById(R.id.textResulMomento);
        textView1_3.setText(tvResulSiesta);
        TextView textView2_3 = findViewById(R.id.textResulDuracion);
        textView2_3.setText(tvResul2Siesta);

        //////////////////////////////////////////////////////////////////////////////////////////

        // COMPARTIR
        imgCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(Environment.getExternalStorageDirectory(), "Ver_informe.java");
                Uri uri = FileProvider.getUriForFile(getApplicationContext(), "es.solvam.colorincolorado", file);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Compartir archivo"));

            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////

        // BOTON ATRAS
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ver_informe.this, Crear_informe.class);
                startActivity(intent);
            }
        });
    }
}