package es.solvam.colorincolorado;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Buscar_alumno extends AppCompatActivity {
    TextView tvNom, tvApellido, tvPadre, tvTelf, tvClase, tvSpinner;
    ImageView btnAtras;
    Intent intent;

    mySQL mysql = new mySQL(Buscar_alumno.this, "Alumnos", null, 1);
    RecyAdapter adaptador;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar_alumno);

        tvNom = findViewById(R.id.buscarNom);
        tvApellido = findViewById(R.id.buscarApellido);
        tvPadre = findViewById(R.id.buscarPadre);
        tvTelf = findViewById(R.id.buscarTelf);
        tvClase = findViewById(R.id.buscarClase);

        btnAtras = findViewById(R.id.btnAtras);

        tvNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusquedaNom();
            }
        });

        tvApellido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusquedaApellido();
            }
        });

        tvPadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusquedaPadre();
            }
        });

        tvTelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusquedaTelf();
            }
        });

        tvClase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BusquedaClase();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Buscar_alumno.this, Home.class);
                startActivity(intent);
            }
        });
    }

    void BusquedaNom() {
        final Dialog dialog = new Dialog(Buscar_alumno.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.busqueda_nom);

        final EditText busquedaNom = dialog.findViewById(R.id.editBusquedaNom);

        Button BAceptar = dialog.findViewById(R.id.btnAceptar);
        Button BCancelar = dialog.findViewById(R.id.btnCancelar);

        BAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miNom = "" + busquedaNom.getText().toString();
                intent = new Intent(getApplicationContext(), Ver_busqueda.class);
                intent.putExtra("nom", miNom);
                startActivityForResult(intent, 1234);

                mysql.mostrarNomSQL(miNom);

                //adaptador.notifyDataSetChanged();//recargar pagina

                dialog.dismiss();
            }
        });
        BCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    void BusquedaApellido() {
        final Dialog dialog = new Dialog(Buscar_alumno.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.busqueda_apellido);

        final EditText busquedaApellido = dialog.findViewById(R.id.buscarApellido);

        Button BAceptar = dialog.findViewById(R.id.btnAceptar);
        Button BCancelar = dialog.findViewById(R.id.btnCancelar);

        BAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miApellido = "" + busquedaApellido.getText().toString();
                intent = new Intent(getApplicationContext(), Ver_busqueda.class);
                intent.putExtra("apellido", miApellido);
                startActivityForResult(intent, 1234);
                Log.d("TAG", "onClick: " + miApellido);

                mysql.mostrarApellidoSQL(miApellido);

                adaptador.notifyDataSetChanged();//recargar pagina

                dialog.dismiss();
            }
        });
        BCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    void BusquedaPadre() {
        final Dialog dialog = new Dialog(Buscar_alumno.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.busqueda_padre);

        final EditText busquedaPadre = dialog.findViewById(R.id.buscarPadre);

        Button BAceptar = dialog.findViewById(R.id.btnAceptar);
        Button BCancelar = dialog.findViewById(R.id.btnCancelar);

        BAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miPadre = "" + busquedaPadre.getText().toString();
                intent = new Intent(getApplicationContext(), Ver_busqueda.class);
                intent.putExtra("padre", miPadre);
                startActivityForResult(intent, 1234);

                mysql.mostrarPadreSQL(miPadre);

                adaptador.notifyDataSetChanged();//recargar pagina

                dialog.dismiss();
            }
        });
        BCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    // Revisar telefono
    void BusquedaTelf() {
        final Dialog dialog = new Dialog(Buscar_alumno.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.busqueda_telf);

        final EditText busquedaTelf = dialog.findViewById(R.id.buscarTelf);

        Button BAceptar = dialog.findViewById(R.id.btnAceptar);
        Button BCancelar = dialog.findViewById(R.id.btnCancelar);

        BAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miTelf = "" + busquedaTelf.getText().toString();
                intent = new Intent(getApplicationContext(), Ver_busqueda.class);
                intent.putExtra("telf", miTelf);
                startActivityForResult(intent, 1234);

                mysql.mostrarTelfSQL(miTelf);

                adaptador.notifyDataSetChanged();//recargar pagina

                dialog.dismiss();
            }
        });
        BCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    void BusquedaClase() {
        final Dialog dialog = new Dialog(Buscar_alumno.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.busqueda_clase);

        tvSpinner = dialog.findViewById(R.id.textSpinner);

        spinner = dialog.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.clases, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapterSpinner);

        final TextView claseAdd = dialog.findViewById(R.id.textSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvSpinner.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button BAceptar = dialog.findViewById(R.id.btnAceptar);
        Button BCancelar = dialog.findViewById(R.id.btnCancelar);

        BAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String miClase = "" + claseAdd.getText().toString();
                 intent = new Intent(getApplicationContext(), Ver_busqueda.class);
                 intent.putExtra("clase", miClase);
                 startActivityForResult(intent, 1234);

                //adaptador.notifyDataSetChanged();//recargar pagina
                mysql.mostrarClaseSQL(miClase);

                dialog.dismiss();
            }
        });
        BCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}