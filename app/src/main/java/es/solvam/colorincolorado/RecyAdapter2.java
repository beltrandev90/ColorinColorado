package es.solvam.colorincolorado;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyAdapter2 extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private ArrayList<Alumnos> misAlumnos = new ArrayList<Alumnos>();


    public RecyAdapter2(ArrayList<Alumnos> datosAlumno) {
        misAlumnos = datosAlumno;
    }

    @NonNull
    @Override
    public RecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listar_alumno, parent, false);
        return new RecyAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(misAlumnos.get(position).getNombre()
                + " " + misAlumnos.get(position).getApellido() + "\n" + "Email padre/tutor: " + "\n" + misAlumnos.get(position).getNomPadre()
                + "\n" + "Teléfono: " + misAlumnos.get(position).getTelefono() + "\n" + "Clase: " + misAlumnos.get(position).getClase());
    }

    @Override
    public int getItemCount() {
        return misAlumnos.size();
    }
}
