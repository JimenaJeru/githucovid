package com.example.covidtracking2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;

public class homemenu extends Fragment {

    private Button botonInformacion,botonSintomas,botonCentros,botonZona,botonMedico,buttonEval1;

    public homemenu() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //imagen de ingreso
        View v=inflater.inflate(R.layout.fragment_homemenu,container,false);
        Drawable originalDrawable = getResources().getDrawable(R.drawable.logoenorme);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCircular(true);

        ImageView imageView = (ImageView) v.findViewById(R.id.imglogomenu);
        botonInformacion = (Button) v.findViewById(R.id.buttoninfo);
        botonSintomas = (Button) v.findViewById(R.id.buttonSinto);
        botonCentros = (Button) v.findViewById(R.id.buttonCentro);
        botonMedico = (Button) v.findViewById(R.id.buttondoctor);
        buttonEval1=(Button)v.findViewById(R.id.buttonEval);
        botonZona= (Button) v.findViewById(R.id.buttongps);
        imageView.setImageDrawable(roundedDrawable);
        botonInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),informacionPrevencion.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });

        botonSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),informacionSintoma.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });
        botonZona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent=new Intent(v.getContext(),Informaciongps.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });

        buttonEval1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),MainActivityEval.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });

        return v;
    }


}