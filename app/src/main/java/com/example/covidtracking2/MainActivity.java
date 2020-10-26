package com.example.covidtracking2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //FINAL DE COVID----ACTUAL 2string;
    //defining view objects
    private ImageView imageView4;

    private EditText TextEmail;

    private EditText TextPassword;
    private Button btnRegistrar, btnLogin;
    private ProgressDialog progressDialog;


    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    //base

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //imagen de ingreso
        Drawable originalDrawable = getResources().getDrawable(R.drawable.logoenorme);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCircular(true);

        ImageView imageView = (ImageView) findViewById(R.id.imageView4);

        imageView.setImageDrawable(roundedDrawable);


        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //Referenciamos los views
        TextEmail = (EditText) findViewById(R.id.editTextEmail);
        TextPassword = (EditText) findViewById(R.id.editTextPassword);

        btnRegistrar = (Button) findViewById(R.id.botonRegistrar);
        btnLogin = (Button) findViewById(R.id.botonLogin);
        //Prue = (Button) findViewById(R.id.button3menu);
        progressDialog = new ProgressDialog(this);

        //asociamos un oyente al evento clic del boton
        btnRegistrar.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }


    private void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacias
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Falta ingresar la contrase鎙", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        FirebaseUser user=firebaseAuth.getCurrentUser();
                        if (task.isSuccessful()) {
                            if (!user.isEmailVerified()){
                                Toast.makeText(MainActivity.this, "Correo electronico no verificado",Toast.LENGTH_LONG).show();
                            }
                            else {
                                int pos = email.indexOf("@");
                                String user1 = email.substring(0, pos);
                                Toast.makeText(MainActivity.this, "Bienvenido: " + TextEmail.getText(), Toast.LENGTH_LONG).show();
                                Intent intencion = new Intent(getApplication(), WellcomeUser.class);
                                intencion.putExtra(WellcomeUser.user, user1);
                                startActivity(intencion);
                            }



                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colision
                                Toast.makeText(MainActivity.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "No se pudo registrar el usuario ", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.botonRegistrar:
                //Invocamos al metodo:
               // registrarUsuario();
                startActivity(new Intent(MainActivity.this,RegistryUser.class));
                finish();
                break;
            case R.id.botonLogin:
                loguearUsuario();
                //startActivity(new Intent(MainActivity.this,WellcomeUser.class));

                break;

        }


    }

    public  void  recuperar(View view){

        Intent i=new Intent(MainActivity.this,RestablecerContrasenia.class);
        startActivity(i);
    }
}




