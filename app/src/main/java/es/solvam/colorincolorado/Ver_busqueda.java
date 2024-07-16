package es.solvam.colorincolorado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Ver_busqueda extends AppCompatActivity {
    TextView verNom, verBusqueda, verBusqueda2, verBusqueda3;
    SQLiteDatabase sqLiteDatabase;
    mySQL mysql;
    ImageView btnAtras;


    ArrayList<Alumnos> datosAlumno = new ArrayList<Alumnos>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_busqueda);

        verBusqueda = findViewById(R.id.Busqueda);
        verBusqueda2 = findViewById(R.id.Busqueda2);
        verBusqueda3 = findViewById(R.id.Busqueda3);
        verNom = findViewById(R.id.VerBusqueda);
        btnAtras = findViewById(R.id.btnAtras);


        mysql = new mySQL(Ver_busqueda.this, "Alumnos", null, 1);

        mostrarNom();
        mostrarApellido();
        mostrarPadre();
        mostrarTelf();
        mostrarClase();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ver_busqueda.this, Buscar_alumno.class);
                startActivity(intent);
            }
        });
    }

    public void mostrarNom() {
        Intent intent = getIntent();
        String nomIntent = getIntent().getStringExtra("nom");

        sqLiteDatabase = mysql.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE nombre LIKE '%" + nomIntent + "%'", null);

            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    String clase = c.getString(5);

                    verBusqueda.setText("Los datos de ");
                    verBusqueda2.setText(nombre);
                    verBusqueda3.setText(" son: " + "\n" + "\n");
                    verBusqueda2.setTextColor(Color.parseColor("#E07A5F"));

                    verNom.append("Apellidos: "  + apellido + "\n" + "Email padre/tutor: " + "\n"  + nomPadre
                            + "\n" + "Teléfono de contacto: " + telefono + "\n" + "Clase: "  + clase + "\n" + "\n");
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
    }

    public void mostrarApellido() {
        Intent intent = getIntent();
        String apellidoIntent = getIntent().getStringExtra("apellido");

        sqLiteDatabase = mysql.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE apellido LIKE '%" + apellidoIntent + "%'", null);


            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    String clase = c.getString(5);

                    verBusqueda.setText("Los datos de ");
                    verBusqueda2.setText(apellido);
                    verBusqueda3.setText(" son: " + "\n" + "\n");
                    verBusqueda2.setTextColor(Color.parseColor("#E07A5F"));

                    verNom.append("Nombre: "  + nombre + "\n" + "Email padre/tutor: " + "\n" + nomPadre
                            + "\n" + "Teléfono de contacto: " + telefono + "\n" + "Clase: "  + clase + "\n" + "\n");
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
    }

    public void mostrarPadre() {
        Intent intent = getIntent();
        String padreIntent = getIntent().getStringExtra("padre");

        sqLiteDatabase = mysql.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE nomPadre LIKE '%" + padreIntent + "%'", null);


            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    String clase = c.getString(5);

                    verBusqueda.setText("Los datos de ");
                    verBusqueda2.setText(nomPadre);
                    verBusqueda3.setText(" son: " + "\n" + "\n");
                    verBusqueda2.setTextColor(Color.parseColor("#E07A5F"));

                    verNom.append("Nombre y apellido del alumno/a: " + "\n"  + nombre + " " + apellido
                            + "\n" + "Teléfono de contacto: " + telefono + "\n" + "Clase: "  + clase + "\n" + "\n");
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
    }

    public void mostrarTelf() {
        Intent intent = getIntent();

        String telfIntent = getIntent().getStringExtra("telf");

        sqLiteDatabase = mysql.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE telefono LIKE '%" + telfIntent + "%'", null);


            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    String clase = c.getString(5);

                    verBusqueda.setText("Los datos de ");
                    verBusqueda2.setText(telefono);
                    verBusqueda3.setText(" son: " + "\n" + "\n");
                    verBusqueda2.setTextColor(Color.parseColor("#E07A5F"));


                    verNom.append("Nombre y apellido del alumno/a: " + "\n"  + nombre + " " + apellido
                            + "\n" + "Email padre/tutor: " + "\n" + nomPadre + "\n" + "Clase: "  + clase + "\n" + "\n");
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
    }

    public void mostrarClase() {
        Intent intent = getIntent();

        String claseIntent = getIntent().getStringExtra("clase");
      //  verNom.append(claseIntent + "\n");

        sqLiteDatabase = mysql.getWritableDatabase();
        if (sqLiteDatabase != null) {

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE clase LIKE '%" + claseIntent + "%'", null);


            if (c.moveToFirst()) {
                do {
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    String clase = c.getString(5);


                    verBusqueda.setText("Los alumnos de la clase ");
                    verBusqueda2.setText(clase);
                    verBusqueda3.setText(" son: " + "\n" + "\n");
                    verBusqueda2.setTextColor(Color.parseColor("#E07A5F"));

                    verNom.append("Nombre y apellido hijo/a: " + "\n" + nombre + " " + apellido
                            + "\n" + "Email padre/tutor: " + "\n" + nomPadre + "\n" + "Teléfono de contacto: " + telefono + "\n" + "\n");


                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
    }
}