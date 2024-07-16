package es.solvam.colorincolorado;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    private ArrayList<Alumnos> misAlumnos = new ArrayList<Alumnos>();

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private final TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.alumno);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnCreateContextMenuListener(this);
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Selecciona");

            menu.add(this.getAdapterPosition(), R.id.informe, 0, "Crear informe");
            menu.add(this.getAdapterPosition(), R.id.editar, 0, "Editar");
            menu.add(this.getAdapterPosition(), R.id.borrar, 0, "Borrar");

        }
    }

    public RecyAdapter(ArrayList<Alumnos> datosAlumno) {
        misAlumnos = datosAlumno;
    }

    @NonNull
    @Override
    public RecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listar_alumno, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(misAlumnos.get(position).getNombre()
                + " " + misAlumnos.get(position).getApellido() + "\n" + "Email padre/tutor: " + "\n" + misAlumnos.get(position).getNomPadre()
                + "\n" + "Teléfono: " + misAlumnos.get(position).getTelefono() + "\n" + "Clase: " + misAlumnos.get(position).getClase());
    }

    @Override
    public int getItemCount() {
        return misAlumnos.size();
    }
}
