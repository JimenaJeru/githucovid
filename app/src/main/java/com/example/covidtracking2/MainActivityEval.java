package com.example.covidtracking2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivityEval extends AppCompatActivity implements View.OnClickListener {
    FragmentTransaction transaction;
    Fragment fragment1, fragment2;
    Button boton1,boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_eval);
        boton1 = (Button) findViewById(R.id.axcse0);
        boton2 = (Button) findViewById(R.id.axcse1);



        //asociamos un oyente al evento clic del boton
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        fragment1 = new FragmentEval0();
        fragment2 = new FragmentEval1();
        getSupportFragmentManager().beginTransaction().add(R.id.Fragmmenteval, fragment1).commit();
    }

    @Override
    public void onClick(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.axcse0:
                transaction.replace(R.id.Fragmmenteval, fragment2).commit();
                break;
            case R.id.axcse1:
                transaction.replace(R.id.Fragmmenteval, fragment1).commit();
                break;
        }
    }
}