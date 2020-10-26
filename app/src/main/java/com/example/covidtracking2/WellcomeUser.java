package com.example.covidtracking2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class WellcomeUser extends AppCompatActivity implements View.OnClickListener {


    public static final String user = "names";

    TextView txtUser;

    fragmentoAlimentacion fragmentoAlimentacion1;
    fragmentoPrevencion fragmentoPrevencion1;
    //Necesitamos 1 objeto de la clase FragmentManager y 1 objeto de la clase FragmentTransaction


    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayoutt;
    private homemenu option1Fragment;
    private perfilmenu option2Fragment;
    private settingsmenu option3Fragment;



    //Necesitamos 1 objeto de la clase FragmentManager y 1 objeto de la clase FragmentTransaction
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_user);
        option1Fragment = new homemenu();
        option2Fragment = new perfilmenu();
        option3Fragment = new settingsmenu();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayoutt = findViewById(R.id.frameLayoutt);

        setFragment(option1Fragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option1Fragment);
                        return true;
                    case R.id.menu_profile:
                        //bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option2Fragment);
                        return true;
                    case R.id.menu_settings:
                        // bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(option3Fragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTrasaction = getSupportFragmentManager().beginTransaction();
        fragmentTrasaction.replace(R.id.frameLayoutt, fragment);
        fragmentTrasaction.commit();
    }




    @Override
    public void onClick(View view1) {
        switch (view1.getId()) {
            /*
            case R.id.btnAlimentacion:
                //  getSupportFragmentManager().beginTransaction().remove(fragmentoPrevencion1).commit();
                fragmentoAlimentacion1 = new fragmentoAlimentacion();
                fragmentoAlimentacion1.setArguments(getIntent().getExtras());
                //Manager:
                fragmentManager = getSupportFragmentManager();
                //Transaccion:
                fragmentTransaction = fragmentManager.beginTransaction();
                //Hay que especificar el layout donde se va a cargar el Fragmento
                fragmentTransaction.add(R.id.linear_layout_principal, fragmentoAlimentacion1);
                fragmentTransaction.commit();

                break;
            case R.id.btnPrevencion123:
                getSupportFragmentManager().beginTransaction().remove(fragmentoAlimentacion1).commit();
                fragmentoPrevencion1 = new fragmentoPrevencion();
                fragmentoPrevencion1.setArguments(getIntent().getExtras());
                //Manager:
                fragmentManager = getSupportFragmentManager();
                //Transaccion:
                fragmentTransaction = fragmentManager.beginTransaction();
                //Hay que especificar el layout donde se va a cargar el Fragmento
                fragmentTransaction.add(R.id.linear_layout_principal, fragmentoPrevencion1);
                fragmentTransaction.commit();
                break;
        }*/


        }
    }
}

