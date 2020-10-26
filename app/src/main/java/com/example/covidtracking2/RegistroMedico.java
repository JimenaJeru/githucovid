package com.example.covidtracking2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroMedico extends AppCompatActivity {
    int age = 0;
    int anio = 0;
    //variables
    private String dbnombre;
    private String dbapellido;
    private String dbci;
    // private  String dbcodi;
    private String dbedad;
    private String dbCategoria = "Medico";
    private String dbemail;
    private boolean dbactivo = false;
    private boolean dbestado = true;
    private String dbpassword, dbcodigoDr, dbnombreUniversidad, dbanioTitulacion;
    private EditText codigoDr, nombreUniversiadad, anioTitulacion;

    DatabaseReference mDatabase;//referencia al nodo principal
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medico);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        OptenerDatos();
        codigoDr = findViewById(R.id.editCodigoMedico);
        nombreUniversiadad = findViewById(R.id.editLugarGraduado);
        anioTitulacion = findViewById(R.id.editanioGraduado);


    }

    private void OptenerDatos() {
        Bundle extras = getIntent().getExtras();
        dbnombre = extras.getString("dato01");
        dbapellido = extras.getString("dato02");
        dbci = extras.getString("dato03");
        dbedad = extras.getString("dato04");
        dbemail = extras.getString("dato05");
        dbpassword = extras.getString("dato06");

       // Toast.makeText(RegistroMedico.this, dbapellido, Toast.LENGTH_SHORT).show();
    }


    public void RegistrarMedico(View view) {

        dbanioTitulacion = anioTitulacion.getText().toString();
        dbcodigoDr = codigoDr.getText().toString();
        dbnombreUniversidad = nombreUniversiadad.getText().toString();
        age = Integer.parseInt(dbedad);
        anio = Integer.parseInt(dbanioTitulacion);

        if (  !dbnombreUniversidad.isEmpty() && !dbcodigoDr.isEmpty() && !dbanioTitulacion.isEmpty()) {


                if (age >= 5 && age <= 80 && anio >= 1960 && anio <= 2020) {
                    registerUser();
                } else {
                    Toast.makeText(RegistroMedico.this, "La edad apropiada para obtener nuestro servicio es de 5-80 por cuestiònes de salud", Toast.LENGTH_SHORT).show();



            } 
        }
        registerUser();
    }

    private void registerUser() {
        mAuth.createUserWithEmailAndPassword(dbemail, dbpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //tarea existosa
                if (task.isSuccessful()) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("dbnombre", dbnombre);
                    map.put("apellido", dbapellido);
                    map.put("ci", dbci);
                    map.put("edad", dbedad);
                    map.put("email", dbemail);
                    map.put("password", dbpassword);
                    map.put("codigoDr", dbcodigoDr);
                    map.put("anioTitulacion", dbanioTitulacion);
                    map.put("nombreUniversidad", dbnombreUniversidad);
                    map.put("categoria", dbCategoria);
                    map.put("habilitado", dbactivo);
                    map.put("estado", dbestado);//se verificara si  llega a ser true el medico esta habilitado caso contrario el medico no esta habilitado pero puede iniciar secion como un usuario corriente

                    String id = mAuth.getCurrentUser().getUid();
                    //se esta creando una tabla
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()) {

                                FirebaseUser user = mAuth.getCurrentUser();
                                user.sendEmailVerification();
                                startActivity(new Intent(RegistroMedico.this, MainActivity.class));
                                finish();
                            } else {
                                //  Toast.makeText(RegistroMedico.this, "No se purieron crear los Datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else {
                    //Toast.makeText(RegistroMedico.this,"Usuario no Registrado",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    public void volver(View view) {
        Intent i = new Intent(RegistroMedico.this, RegistryUser.class);
        startActivity(i);
    }


    /*public void volver(View view) {
        mAuth.createUserWithEmailAndPassword(dbemail, dbpassword){
            mAuth.rem();
        };
    }*/
}