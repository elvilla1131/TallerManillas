package com.example.elvilla.manillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView res;
    private Spinner material;
    private Spinner dije;
    private Spinner tipo;
    private Button aceptar;
    private Resources recursos;
    private String op[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        material =(Spinner) findViewById(R.id.cmbmaterial);
        ArrayAdapter<String> adapter = new ArrayAdapter( this,android.R.layout.simple_spinner_item,op);
        material.setAdapter(adapter);


        dije =(Spinner) findViewById(R.id.cmbdije);
        ArrayAdapter<String> adapterdos = new ArrayAdapter( this,android.R.layout.simple_spinner_item,op);
        dije.setAdapter(adapterdos);

        tipo =(Spinner) findViewById(R.id.cmbtipo);
        ArrayAdapter<String> adaptertres = new ArrayAdapter( this,android.R.layout.simple_spinner_item,op);
        tipo.setAdapter(adaptertres);
        aceptar = findViewById(R.id.btnaceptar);

        material.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        aceptar.setText(recursos.getString(R.string.cuero));
                        break;
                    case 1:
                        aceptar.setText(recursos.getString(R.string.cuerda));
                        break;
            }


        }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }

    public void aceptar(View view) {


    }
}
