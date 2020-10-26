package com.example.covidtracking2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.covidtracking2.R;

public class FragmentEval1 extends Fragment {
    Switch Switch1,Switch2,Switch3,Switch4,Switch5,Switch6,Switch7,Switch8,Switch9,Switch10,Switch11,Switch12,Switch13,Switch14;
    EditText editTextedad;
    TextView evalres,evalres1,evalres3;
    Button botonevalua,buttonEnviarCalendario,botonevaluaedad;
    String caso;
    int edad;
    double res;
    // int a=4,b=7,c=8,d=9;
    int a=0,b=0,c=0,d=0;
    //x10 y8
    int x=0,y=0;
    public FragmentEval1() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_eval1,container,false);

        Switch1 = (Switch) v.findViewById(R.id.switch1);
        Switch2 = (Switch) v.findViewById(R.id.switch2);
        Switch3 = (Switch) v.findViewById(R.id.switch3);
        Switch4 = (Switch) v.findViewById(R.id.switch4);
        Switch5 = (Switch) v.findViewById(R.id.switch5);
        Switch6 = (Switch) v.findViewById(R.id.switch6);
        Switch7 = (Switch) v.findViewById(R.id.switch7);
        Switch8 = (Switch) v.findViewById(R.id.switch8);
        Switch9 = (Switch) v.findViewById(R.id.switch9);
        Switch10 = (Switch) v.findViewById(R.id.switch10);
        Switch11= (Switch) v.findViewById(R.id.switch11);
        Switch12 = (Switch) v.findViewById(R.id.switch12);
        Switch13 = (Switch) v.findViewById(R.id.switch13);
        Switch14 = (Switch) v.findViewById(R.id.switch14);
        evalres=(TextView) v.findViewById(R.id.textVieweval);
        evalres1=(TextView) v.findViewById(R.id.textVieweval2);
        evalres3=(TextView) v.findViewById(R.id.textView54);
        editTextedad=(EditText)v.findViewById(R.id.editTextNumber3);
        botonevaluaedad=(Button)v.findViewById(R.id.botonedad);
        botonevalua=(Button)v.findViewById(R.id.botonevaluar);
        buttonEnviarCalendario=(Button)v.findViewById(R.id.buttonEnviarCalendario);
        buttonEnviarCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        botonevalua.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View vi) {

                // if(v.getId()==R.id.switch1){
                if (editTextedad != null) {
                    if (Switch1.isChecked()) {
                        d = d + 1;
                    }
                    if (Switch2.isChecked()) {
                        c = c + 1;
                    }
                    if (Switch3.isChecked()) {
                        b = b + 1;
                    }
                    if (Switch4.isChecked()) {
                        d = d + 1;
                        x++;
                    }
                    if (Switch5.isChecked()) {
                        d = d + 1;
                        x++;
                    }
                    if (Switch6.isChecked()) {
                        c = c + 1;
                        x++;
                    }
                    if (Switch7.isChecked()) {
                        c = c + 1;
                        y++;
                    }
                    if (Switch8.isChecked()) {
                        a = a + 1;
                        x++;
                    }
                    if (Switch9.isChecked()) {
                        c = c + 1;
                        y++;
                    }
                    if (Switch10.isChecked()) {
                        b = b + 1;
                        x++;
                    }
                    if (Switch11.isChecked()) {
                        a = a + 1;
                        y++;
                    }
                    if (Switch12.isChecked()) {
                        a = a + 1;
                        y++;
                    }
                    if (Switch13.isChecked()) {
                        b = b + 1;
                        y++;
                    }
                    if (Switch14.isChecked()) {
                        d = d + 1;
                        x++;
                    }
                }
                res=a*4+b*7+c*8+d*9;
//

                edad = Integer.parseInt(editTextedad.getText().toString());
                if (edad > 0 && edad < 6) {
                    caso = "infante";
                    if (Switch1.isChecked() || Switch2.isChecked() || Switch3.isChecked()) {

                        evalres1.setText(" introduzca la correspondiente edad para la evaluación");
                    } else {
                        res = 0;
                        res = (x * 10 + y * 8) * 1.00;
                        evalres.setText(res + "%");
                        if (res < 50) {
                            //riesgo minimo pero cuidado

                            evalres1.setText("En el caso de los infantes los síntomas son más leves y se recupera a pocos días en uno o dos semanas pero recurrir a un centro médico para una mejor atención.\n");
                        }
                        evalres1.setText("Los resultados arroja un nivel alto de probabilidad de contagio en los infantes la fiebre y la tos son muy comunes y también el vómito y la diarrea así como dolor de garganta y cansancio Aunque éstos pueden llegar a ser leves se recomienda el cuidado atencion  en mantener los lugares desinfectados para su tratamiento, Realice chequeo médico para uno mejor análisis.Debido a su corta edad tiene que estar en observación si El caso es muy grave y Consultar con su pediatra correspondiente ");

                    }

                }
                if (edad >= 6 && edad < 12) {
                    caso = "ninez";
                    res = res * 1.00;

                    if (Switch1.isChecked() || Switch2.isChecked() || Switch3.isChecked()) {

                        evalres1.setText(" introduzca la correspondiente  edad para la evaluación");
                    } else {
                        res = 0;
                        res = (x * 10 + y * 8) * 1.00;
                        evalres.setText(res + "%");
                        if (res < 50) {
                            //riesgo minimo pero cuidado


                            evalres1.setText("En el caso de los niños los síntomas son más leves y se recupera a pocos días en uno o dos semanas pero recurrir a un centro médico para una mejor atención.\n");
                        }
                        evalres1.setText("Los resultados arroja un nivel alto de probabilidad de contagio en los niños la fiebre y la tos son muy comunes y también el vómito y la diarrea así como dolor de garganta y cansancio Aunque éstos pueden llegar a ser leves se recomienda el cuidado atencion  en mantener los lugares desinfectados para su tratamiento, Realice chequeo médico para uno mejor análisis .\n");


                    }
                }
                if (edad > 12 && edad <= 25) {
                    caso = "adolescente";
                    res = res * 1.00;
                    evalres.setText(res + "%");
                    if (res < 50) {
                        //recomendaciones

                        evalres1.setText("La probabilidad de que usted tenga coronavirus es baja a lo que abajo  le mostramos las posibles causas de su molestia Teniendo en cuenta que en algunos casos los síntomas no son presentes si se tiene la sospecha de que tenga la enfermedad recurrir a un centro médico para los despectivo análisi.\n");
                    }
                    evalres1.setText("Los resultados arrojan un nivel alto de probabilidad de contagio a pesar de que los adultos jóvenes tienen menos probabilidades desarrollar una enfermedad grave Aunque dichos casos se dan.");

                }
                if (edad > 25 && edad <= 60) {
                    caso = "dultp";
                    res = res * 1.00;
                    evalres.setText(res + "%");
                    if(res<50)
                    {
                        evalres1.setText("La probabilidad de que haya contraído o tenga la enfermedad de covid-19 Aunque se sabe que algunas personas pueden presentar la enfermedad sin tener muchos síntomas o tener síntomas leves.");
                    }

                    evalres1.setText( " La probabilidad de que tenga coronavirus en un porcentaje alto se recomienda tener cuidado y aislarse por el bien de su familia y seguir con las respectivas precauciones en lavado de mano el cubrirse la boca al estornudar a un centro médico o a su para un chequeo médico.");
                } else {
                    if (edad > 60 && edad <= 100) {
                        caso = "adultomayor";
                        res = res * 1.00;
                        if(res<50)
                        {
                            evalres1.setText("La probabilidad de  que usted tenga coronavirus es baja a pesar de todo seguir con los cuidados necesarios y precauciones dadas Hacer mayor corre más riesgos de un contagio por su sistema inmunológico.");
                        }

                        evalres1.setText("El resultado de su evaluación es un alto porcentaje de contagio a lo cual se sugiere acudir a un centro médico lo más pronto posible debido a la edad y el riesgo que presenta.");
                    }
                }

                if (!Switch4.isChecked()&&Switch5.isChecked()&&!Switch7.isChecked()&&Switch8.isChecked()&&!Switch9.isChecked()) {
                    evalres3.setText("Usted presenta sintomas de un resfriado: Dura de 7 a 10 dias");

                }
                else
                {
                    evalres3.setText("No tiene un resfriado");
                }
            }
        });

        botonevaluaedad.setOnClickListener(new View.OnClickListener() {

                 @Override
                 public void onClick(View v) {

                   a=0;b=0;c=0;d=0;x=0;y=0;
                   editTextedad.setText("");
                   evalres.setText("");
                     evalres1.setText("");
                 }
             });

        return v;
    }
}