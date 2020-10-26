package com.example.covidtracking2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Sugerencias extends AppCompatActivity {

    EditText descripcion;
    DatabaseReference mRootReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerencias);
        mRootReference= FirebaseDatabase.getInstance().getReference();
        descripcion=findViewById(R.id.editTextlastName2);
    }
    public  void  enviarSugenrencia(View view)
    {
        String des=descripcion.getText().toString();
        Map<String,Object> datos=new HashMap<>();
        datos.put("Descripcion", des);
        mRootReference.child("Sugerencias").push().setValue(datos);
        Toast.makeText(this, "Gracias por la sugerencia ", Toast.LENGTH_LONG).show();
        descripcion.setText("");
    }
}