package com.example.covidtracking2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
public class RegistryUser extends AppCompatActivity {

    private EditText nombre,apellido,ci,codi,email,password,edad;
    private Button ButtonRegister;
    int age=0;
    //variables
    private boolean dbactivo =true;
    private  String dbnombre;
    private  String dbapellido;
    private String dbCategoria = "Usuario";
    private  String dbci;
   // private  String dbcodi;
    private  String dbedad;
    private  String dbemail;
    private  String dbpassword;
    DatabaseReference mDatabase;//referencia al nodo principal

    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry_user); mAuth=FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance().getReference();
        Drawable originalDrawable = getResources().getDrawable(R.drawable.logoenorme);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCircular(true);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        imageView.setImageDrawable(roundedDrawable);


        nombre=findViewById(R.id.editTextName);
        apellido=findViewById(R.id.editTextlastName);
        ci=findViewById(R.id.editTextCi);
       // codi=findViewById(R.id.editTextCode);
        edad=findViewById(R.id.editTextage);
        email=findViewById(R.id.editTextTextEmailAddress);
        password=findViewById(R.id.editTextTextPassword);
        ButtonRegister=findViewById(R.id.buttonRegitrar);

        
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbnombre=nombre.getText().toString();
                dbapellido=apellido.getText().toString();
                dbci=ci.getText().toString();
                //  dbcodi=codi.getText().toString();
                dbedad=edad.getText().toString();
                dbemail=email.getText().toString();
                dbpassword=password.getText().toString();


               age=Integer.parseInt(dbedad);

                if(!dbnombre.isEmpty()&&!dbedad.isEmpty()&&!dbapellido.isEmpty()&&!dbci.isEmpty()&&!dbemail.isEmpty()&& !dbpassword.isEmpty()){

                        if(dbpassword.length()>=6&&dbci.length()==7){
                            if(age>=5&&age<=80)
                            {
                                registerUser();
                            }else{
                                Toast.makeText(RegistryUser.this,"La edad apropiada para obtener nuestro servicio es de 5-80 por cuestiònes de salud",Toast.LENGTH_SHORT).show();

                            }

                    }else{
                        Toast.makeText(RegistryUser.this,"El password debe tener al menos 6 caracteres",Toast.LENGTH_SHORT).show();
                    }
                }



            }




        });
    }


    public  void  RegistrarMedico(View view){
        dbnombre=nombre.getText().toString();
        dbapellido=apellido.getText().toString();
        dbci=ci.getText().toString();

        dbedad=edad.getText().toString();
        dbemail=email.getText().toString();
        dbpassword=password.getText().toString();
        age=Integer.parseInt(dbedad);
        if(!dbnombre.isEmpty()&&!dbedad.isEmpty()&&!dbapellido.isEmpty()&&!dbci.isEmpty()&&!dbemail.isEmpty()&& !dbpassword.isEmpty()){

            if(dbpassword.length()>=6 &&dbci.length()>=7 && dbci.length()<=9){

                if(age>=5&&age<=80)
                {
                    Intent i = new Intent(RegistryUser.this,  RegistroMedico.class);
                    i.putExtra("dato01",dbnombre);
                    i.putExtra("dato02",dbapellido);
                    i.putExtra("dato03",dbci);
                    i.putExtra("dato04",dbedad);
                    i.putExtra("dato05",dbemail);
                    i.putExtra("dato06",dbpassword);
                    startActivity(i);
                }else{
                    Toast.makeText(RegistryUser.this,"La edad apropiada para obtener nuestro servicio es de 5-80 por cuestiònes de salud",Toast.LENGTH_SHORT).show();

                }

            }else{
                Toast.makeText(RegistryUser.this,"El password debe tener al menos 6 caracteres",Toast.LENGTH_SHORT).show();
            }
        }

    }

        private void registerUser() {
        mAuth.createUserWithEmailAndPassword(dbemail,dbpassword).addOnCompleteListener( new OnCompleteListener<AuthResult>() {


            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //tarea existosa
                if(task.isSuccessful()){

                    Map<String,Object> map=new HashMap<>();
                    map.put("dbnombre",dbnombre);
                    map.put("apellido",dbapellido);
                    map.put("ci",dbci);
                    map.put("edad",dbedad);
                    map.put("email",dbemail);
                    map.put("password",dbpassword);
                    map.put("estado", dbactivo);
                    map.put("categoria", dbCategoria);

                    String id=mAuth.getCurrentUser().getUid();
                    //se esta creando una tabla
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){

                                FirebaseUser user=mAuth.getCurrentUser();
                                user.sendEmailVerification();
                                startActivity(new Intent(RegistryUser.this,MainActivity.class));
                                finish();
                            }
                            else {
                                Toast.makeText(RegistryUser.this, "No se purieron crear los Datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(RegistryUser.this,"Usuario no Registrado",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public  void  recuperar(View view){

        Intent i=new Intent(RegistryUser.this,MainActivity.class);
        startActivity(i);
    }
}