package es.solvam.colorincolorado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class mySQL extends SQLiteOpenHelper {
    ArrayList<Alumnos> datosAlumno = new ArrayList<Alumnos>();
    SQLiteDatabase sqLiteDatabase;
    RecyAdapter adapter = new RecyAdapter(datosAlumno);

    private static final String tabla_alumnos = "CREATE TABLE Alumnos (id integer primary " +
            "key autoincrement, nombre TEXT, apellido TEXT, nomPadre TEXT, telefono TEXT, clase TEXT)";


    public mySQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(tabla_alumnos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Alumnos> mostrarAlumnos() {
        datosAlumno.clear();
        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos", null);

            if (c.moveToFirst()) {
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    /*Integer telefono = Integer.valueOf(c.getString(4));*/
                    String clase = c.getString(5);

                    datosAlumno.add(new Alumnos(Integer.parseInt(id),nombre,apellido,nomPadre,telefono,clase));
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
        adapter.notifyDataSetChanged();
        return datosAlumno;

    }

    public ArrayList<Alumnos> addAlumno(String nombre, String apellido, String nomPadre, String telefono, String clase) {

        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", nombre);
            nuevoRegistro.put("apellido", apellido);
            nuevoRegistro.put("nomPadre", nomPadre);
            nuevoRegistro.put("telefono", telefono);
            nuevoRegistro.put("clase", clase);
            sqLiteDatabase.insert("Alumnos", null, nuevoRegistro);
        }
        sqLiteDatabase.close();
        return datosAlumno;
    }

    public ArrayList<Alumnos> editSQL(int position, int id, String nombre, String apellido, String nomPadre, String telefono, String clase) {

        sqLiteDatabase = this.getWritableDatabase();
        if(sqLiteDatabase != null) {
            ContentValues valores = new ContentValues();
            valores.put("nombre", String.valueOf(nombre));
            valores.put("apellido", String.valueOf(apellido));
            valores.put("nomPadre", String.valueOf(nomPadre));
            valores.put("telefono", String.valueOf(telefono));
            valores.put("clase", String.valueOf(clase));
            sqLiteDatabase.update("Alumnos", valores, "id=?", new String[]{String.valueOf(id)});
        }
        datosAlumno.set(position, new Alumnos(datosAlumno.get(position).getId(),nombre,apellido,nomPadre,telefono,clase));
        sqLiteDatabase.close();
        return datosAlumno;
    }



    public ArrayList<Alumnos> deleteSQL(int position) {

        sqLiteDatabase = this.getWritableDatabase();

        if(sqLiteDatabase != null) {
            String[] argumentos = {String.valueOf(datosAlumno.get(position).getId())};
            sqLiteDatabase.delete("Alumnos", "id=?", argumentos);
        }
        datosAlumno.remove(position);
        sqLiteDatabase.close();
        return datosAlumno;
    }

    public void deleteAllSQL() {

        sqLiteDatabase = this.getWritableDatabase();

        if(sqLiteDatabase != null) {
            sqLiteDatabase.delete("Alumnos", null, null);
        }

        sqLiteDatabase.close();

    }

    public ArrayList<Alumnos> mostrarNomSQL(String miNom) {

        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE nombre LIKE '%" + miNom + "%'", null);

            if (c.moveToFirst()) {
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    /* Integer telefono = Integer.valueOf(c.getString(4));*/
                    String clase = c.getString(5);
                    datosAlumno.add(new Alumnos(Integer.parseInt(id),nombre,apellido,nomPadre,telefono,clase));
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
        return datosAlumno;
    }

    public ArrayList<Alumnos> mostrarApellidoSQL(String miApellido) {

        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE apellido LIKE '%" + miApellido + "%'",null);

            if (c.moveToFirst()) {
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    /*Integer telefono = Integer.valueOf(c.getString(4));*/
                    String clase = c.getString(5);
                    datosAlumno.add(new Alumnos(Integer.parseInt(id),nombre,apellido,nomPadre,telefono,clase));
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
        return datosAlumno;
    }

    public ArrayList<Alumnos> mostrarPadreSQL(String miPadre) {

        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE nomPadre LIKE '%" + miPadre + "%'", null);

            if (c.moveToFirst()) {
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    /*Integer telefono = Integer.valueOf(c.getString(4));*/
                    String clase = c.getString(5);
                    datosAlumno.add(new Alumnos(Integer.parseInt(id),nombre,apellido,nomPadre,telefono,clase));
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
        return datosAlumno;
    }

    public ArrayList<Alumnos> mostrarTelfSQL(String miTelf) {

        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE telefono LIKE '%" + miTelf + "%'", null);

            if (c.moveToFirst()) {
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    /*Integer telefono = Integer.valueOf(c.getString(4));*/
                    String clase = c.getString(5);
                    datosAlumno.add(new Alumnos(Integer.parseInt(id),nombre,apellido,nomPadre,telefono,clase));
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
        return datosAlumno;
    }

    public ArrayList<Alumnos> mostrarClaseSQL(String miClase) {

        sqLiteDatabase = this.getWritableDatabase();
        if (sqLiteDatabase != null) {
            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM Alumnos WHERE clase LIKE '%" + miClase + "%'", null);

            if (c.moveToFirst()) {
                do {
                    String id = c.getString(0);
                    String nombre = c.getString(1);
                    String apellido = c.getString(2);
                    String nomPadre = c.getString(3);
                    String telefono = c.getString(4);
                    /*Integer telefono = Integer.valueOf(c.getString(4));*/
                    String clase = c.getString(5);

                    datosAlumno.add(new Alumnos(Integer.parseInt(id),nombre,apellido,nomPadre,telefono,clase));
                } while (c.moveToNext());
            }
        }
        sqLiteDatabase.close();
        return datosAlumno;
    }
}
