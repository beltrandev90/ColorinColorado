package es.solvam.colorincolorado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Listar_alumno extends AppCompatActivity {
    mySQL mysql;
    Spinner spinner;
    TextView tvSpinner;
    ImageButton btnAtras;

    RecyclerView rv;
    ArrayList<Alumnos> datosAlumnos = new ArrayList<Alumnos>();

    RecyAdapter adaptador;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle);

        rv = findViewById(R.id.rv);
        textView = findViewById(R.id.textView);
        btnAtras = findViewById(R.id.btnAtras);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(layoutManager);

        registerForContextMenu(rv);

        mysql = new mySQL(Listar_alumno.this, "Alumnos", null, 1);
        datosAlumnos = mysql.mostrarAlumnos();

        adaptador = new RecyAdapter(datosAlumnos);
        rv.setAdapter(adaptador);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Listar_alumno.this, Home.class);
                startActivity(intent);
            }
        });

    }

    public void borrarTodo() {
        Dialog dialog = new Dialog(Listar_alumno.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.confirmar);

        Button button = dialog.findViewById(R.id.button);
        Button button1 = dialog.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datosAlumnos.clear();
                mysql.deleteAllSQL();
                adaptador.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showDialogEdit(int position) {
        final Dialog dialog = new Dialog(Listar_alumno.this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.editar_alumno);

        // Spinner
        tvSpinner = dialog.findViewById(R.id.textSpinner);

        spinner = dialog.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.clases, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvSpinner.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ///////

        final EditText editNom      = dialog.findViewById(R.id.editNombre);
        final EditText editApellido = dialog.findViewById(R.id.editApellido);
        final EditText editNomPadre = dialog.findViewById(R.id.editNomPadre);
        final EditText editTelefono = dialog.findViewById(R.id.editTelefono);
        final TextView editClase    = dialog.findViewById(R.id.textSpinner);


        Button btnAceptar = dialog.findViewById(R.id.buttonAceptar);
        Button btnCancelar = dialog.findViewById(R.id.buttonCancelar);

        editNom.setText(datosAlumnos.get(position).getNombre());
        editApellido.setText(datosAlumnos.get(position).getApellido());
        editNomPadre.setText(datosAlumnos.get(position).getNomPadre());
        editTelefono.setText(datosAlumnos.get(position).getTelefono());
        editClase.setText(datosAlumnos.get(position).getClase());

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomEditar      = editNom.getText().toString();
                String apellidoEditar = editApellido.getText().toString();
                String nomPadreEditar = editNomPadre.getText().toString();
                String telefonoEditar = editTelefono.getText().toString();
                String claseEditar    = editClase.getText().toString();

                mysql.editSQL(position,datosAlumnos.get(position).getId(),nomEditar,apellidoEditar,nomPadreEditar,telefonoEditar,claseEditar);

                adaptador.notifyDataSetChanged();//recargar pagina

                dialog.dismiss();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        datosAlumnos = mysql.mostrarAlumnos();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.borrarLista) {
            borrarTodo();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.editar:
                showDialogEdit(item.getGroupId());
                return true;

            case R.id.informe:
                Intent intent = new Intent(Listar_alumno.this, Crear_informe.class);
                intent.putExtra("nombre2", datosAlumnos.get(item.getGroupId()).getNombre());
                intent.putExtra("apellido2", datosAlumnos.get(item.getGroupId()).getApellido());
                startActivity(intent);

                return true;

            case R.id.borrar:
                mysql.deleteSQL(item.getGroupId());
                datosAlumnos = mysql.mostrarAlumnos();
                adaptador.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}