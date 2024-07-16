package es.solvam.colorincolorado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.Builder;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    TextView tvAdd, tvListar, tvBuscar, tvSalir, tvSpinner;
    ImageView img1, img2, img3, img4;

    mySQL mysql;

    Intent intent;
    Spinner spinner;
    MediaPlayer mp;

    private ArrayList<Alumnos> datosAlumnos = new ArrayList<Alumnos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        tvAdd = findViewById(R.id.textAdd);
        tvListar = findViewById(R.id.textListar);
        tvBuscar = findViewById(R.id.textBuscar);
        tvSalir = findViewById(R.id.textSalir);

        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);

        mysql = new mySQL(Home.this, "Alumnos", null, 1);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogAdd();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this, Listar_alumno.class);
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this, Buscar_alumno.class);
                startActivity(intent);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);


                // Notificacion
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                String CHANNEL_ID = "MYCHANNEL";
                NotificationChannel notificationChannel = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notificationChannel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_LOW);
                }
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_MUTABLE);

                Notification notification = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    notification = new Notification.Builder(getApplicationContext(), CHANNEL_ID)
                            .setContentIntent(pendingIntent)
                            .setContentTitle("Atención")
                            .setContentText("Cerraste sesion")
                            .setContentIntent(pendingIntent)
                            .addAction(android.R.drawable.sym_def_app_icon, "Aceptar", pendingIntent)
                            .setChannelId(CHANNEL_ID)
                            .setSmallIcon(android.R.drawable.sym_def_app_icon)
                            .build();
                }

                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                ;
                notificationManager.notify(1,notification);
                /////

                // Vibracion
                Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(300);
                //////

            }
        });
    }

    void showDialogAdd() {
        final Dialog dialog = new Dialog(Home.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.add_alumno);

        // Spinner
        tvSpinner = dialog.findViewById(R.id.textSpinner);

        spinner = dialog.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.clases, android.R.layout.simple_spinner_item);

        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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

        final EditText nombreAdd   = dialog.findViewById(R.id.nombreAdd);
        final EditText apellidoAdd = dialog.findViewById(R.id.apellidoAdd);
        final EditText nomPadreAdd = dialog.findViewById(R.id.nomPadreAdd);
        final EditText telefono    = dialog.findViewById(R.id.telefonoAdd);
        final TextView claseAdd    = dialog.findViewById(R.id.textSpinner);

        // Boton sonido
        mp = MediaPlayer.create(this, R.raw.sonido_btn);
        /////

        Button btnEnviar = dialog.findViewById(R.id.buttonEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Sonido boton
                mp.start();
                //////

                String strNombre   = nombreAdd.getText().toString();
                String strApellido = apellidoAdd.getText().toString();
                String strNomPadre = nomPadreAdd.getText().toString();
                String strTelef    = telefono.getText().toString();
                String strClase    = claseAdd.getText().toString();
                Log.w("TAG", "onClick: " + strClase);


                if (strNombre.isEmpty() || strApellido.isEmpty() || strNomPadre.isEmpty() || strTelef.isEmpty() || strClase.isEmpty()) {
                    if (strNombre.isEmpty()) {
                        Toast.makeText(view.getContext(), "Ingrese nombre", Toast.LENGTH_LONG).show();
                    }
                    if (strApellido.isEmpty()) {
                        Toast.makeText(view.getContext(), "Ingrese apellidos", Toast.LENGTH_LONG).show();
                    }
                    if (strNomPadre.isEmpty()) {
                        Toast.makeText(view.getContext(), "Ingrese email padre/tutor", Toast.LENGTH_LONG).show();
                    }
                    if (strTelef.isEmpty()) {
                        Toast.makeText(view.getContext(), "Ingrese telefono", Toast.LENGTH_LONG).show();
                    }
                    if (strClase.isEmpty()) {
                        Toast.makeText(view.getContext(), "Seleccione clase", Toast.LENGTH_LONG).show();
                    }

                } else {
                    mysql.addAlumno(strNombre, strApellido, strNomPadre, strTelef, strClase);
                }

                //datosAlumnos = mysql.mostrarAlumnos();

                dialog.dismiss();
            }
        });
        dialog.show();
        //datosAlumnos = mysql.mostrarAlumnos();
    }

    public void About(){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.about);
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.about) {
            About();
        }
        return super.onOptionsItemSelected(item);
    }

}