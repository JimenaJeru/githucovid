package com.example.covidtracking2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Perfil extends AppCompatActivity {
    TextView nombre,apellido,edad;
    Button edid;
    String dbnombre,dbapellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


       /* mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        nombre = (EditText) ve.findViewById(R.id.tvNombre);
        apellido = (EditText) ve.findViewById(R.id.tvApellido);
        //edad = (TextView) ve.findViewById(R.id.tvEdad);
        edid = (Button) ve.findViewById(R.id.btnEditar);
        TextEmail = (EditText) ve.findViewById(R.id.editemail);
        TextPassword = (EditText) ve.findViewById(R.id.editTextPassword);





        edid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dbnombre = nombre.getText().toString();
                dbapellido = apellido.getText().toString();
                String password = TextPassword.getText().toString().trim();
                final String email = TextEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {//(precio.equals(""))

                    System.out.println("Error no se pudo editar tados");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    System.out.println("Falta ingresar la contrase");

                    return;
                } else {


                    //loguear usuario
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //checking if success
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (task.isSuccessful()) {

                                        Map<String, Object> map = new HashMap<>();
                                        map.put("dbnombre", dbnombre);
                                        map.put("apellido", dbapellido);
                                        ;


                                        String id = mAuth.getCurrentUser().getUid();
                                        //se esta creando una tabla
                                        mDatabase.child("Users").updateChildren(map);
                                    }
                                }
                     }
                }
            }
        });
                   */


    }
}