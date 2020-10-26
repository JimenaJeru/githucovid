package com.example.covidtracking2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link perfilmenu#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class perfilmenu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment perfilmenu.
     */
    // TODO: Rename and change types and number of parameters
    public static perfilmenu newInstance(String param1, String param2) {
        perfilmenu fragment = new perfilmenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public perfilmenu() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    DatabaseReference bbdd;

    private Button cambiarcontrasenia,sugerencia,eliminar,btnEditar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    bbdd= FirebaseDatabase.getInstance().getReference();
    bbdd.child("Sugerencias").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot datasnapshot) {
            for (DataSnapshot snapshot:datasnapshot.getChildren())
            {
                Log.e("datos: ",""+snapshot.getValue());
                Toast.makeText(getActivity(), ""+snapshot.getValue(), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_perfilmenu,container,false);
        cambiarcontrasenia= (Button) v.findViewById(R.id.btnCambiarContrasenia);
        sugerencia= (Button) v.findViewById(R.id.btnSugerencias);
        eliminar= (Button) v.findViewById(R.id.btnEliminarCuenta);
        btnEditar=(Button) v.findViewById(R.id.btnEditar);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),EliminarCuenta.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),Perfil.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });
        cambiarcontrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),RestablecerContrasenia.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });
        sugerencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),Sugerencias.class);
                startActivityForResult(intent, 0);
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));
                // startActivity(new Intent(homemenu.this,InformacionPrevencion.class));

            }
        });


        return v;
    }

}