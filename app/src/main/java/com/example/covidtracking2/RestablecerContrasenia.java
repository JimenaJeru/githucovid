package com.example.covidtracking2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class RestablecerContrasenia extends AppCompatActivity {

    private EditText editTCorreo;
    private  String email="";
    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablecer_contrasenia);
        mAuth=FirebaseAuth.getInstance();
        mDialog=new ProgressDialog(this);

        editTCorreo=findViewById(R.id.editTCorreo);

    }
    public  void  Recuperar(View view){
        email=editTCorreo.getText().toString();
        if (!email.isEmpty()){
            mDialog.setMessage("Espere un momento...");
            mDialog.setCanceledOnTouchOutside(false);
            mDialog.show();
            resetPassword();
        }
        else {
            Toast.makeText(RestablecerContrasenia.this, "Debe de ingresar el Correo electronico ", Toast.LENGTH_LONG).show();

        }
    }

    private void resetPassword() {
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(RestablecerContrasenia.this, "Se envio un correo para que restablesca su cuenta ", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(RestablecerContrasenia.this, "No se pudo enviar el correo para restablecer su contraseña intentelo mas tarde", Toast.LENGTH_LONG).show();

                }
                mDialog.dismiss();
            }
        });
    }
}