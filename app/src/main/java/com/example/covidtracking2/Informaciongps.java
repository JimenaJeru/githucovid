package com.example.covidtracking2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Informaciongps extends AppCompatActivity {
    Button btnMostrar;
    FusedLocationProviderClient fusedLocationProviderClient;
    double latitud = 0, longitud = 0;
    static final int codigoPermiso = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informaciongps);
        btnMostrar = findViewById(R.id.button1);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerUbicacion();
                if (latitud != 0 && longitud != 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + latitud + ">,<" + longitud + ">?q=<" + latitud + ">,<" + longitud + ">(" + "Ubicacion Actual" + ")"));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "no se tiene coordenadas", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void obtenerUbicacion() {
        try {
            if (obtenerPermisos()) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            latitud = location.getLatitude();
                            longitud = location.getLongitude();
                        } else {
                            Toast.makeText(getApplicationContext(), "no se tiene ultima ubicacion", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else{
                Toast.makeText(getApplicationContext(), "No se tienen los permisos", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Error al intentar obtener la ubicacion", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean obtenerPermisos() {
        boolean respuesta = false;
        if (Build.VERSION.SDK_INT >=23){
            if(!todosPermisos()){
                pedirPermisos();
            }else{
                //Toast.makeText(getApplicationContext(),"Tienes todos los permisos", Toast.LENGTH_SHORT).show();
                respuesta = true;
            }
        }
        return respuesta;
    }
    private void pedirPermisos() {
        ActivityCompat.requestPermissions(Informaciongps.this, new String[]{ACCESS_FINE_LOCATION},codigoPermiso);
    }
    private boolean todosPermisos() {
        int permisoUbicacionUno = ContextCompat.checkSelfPermission(getApplicationContext(),ACCESS_FINE_LOCATION);
        return permisoUbicacionUno == PackageManager.PERMISSION_GRANTED;
    }
}