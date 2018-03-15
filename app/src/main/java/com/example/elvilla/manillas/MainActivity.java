package com.example.elvilla.manillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText cantidad;
    private TextView valorUnitario, valorTotal;
    private Spinner dije, tipoManilla, material, moneda;
    private String[] strdije, strTipoManilla, strMaterial, strMoneda;
    private ArrayAdapter adapter_dije, adapter_tipoManilla, adapter_material, adapter_moneda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad = (EditText)findViewById(R.id.txtCantidad);
        valorTotal = (TextView) findViewById(R.id.txtValorTotal);
        valorUnitario = (TextView)findViewById(R.id.txtValorUnitario);
        dije = (Spinner)findViewById(R.id.cmbDije);
        tipoManilla = (Spinner)findViewById(R.id.cmbManilla);
        material = (Spinner)findViewById(R.id.cmbMaterial);
        moneda = (Spinner)findViewById(R.id.cmbMoneda);

        strdije = this.getResources().getStringArray(R.array.strDije);
        strMaterial = this.getResources().getStringArray(R.array.strMaterial);
        strTipoManilla = this.getResources().getStringArray(R.array.strTipoManilla);
        strMoneda = this.getResources().getStringArray(R.array.strMoneda);
        adapter_dije = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strdije);
        adapter_material = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strMaterial);
        adapter_tipoManilla = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strTipoManilla);
        adapter_moneda = new ArrayAdapter(this,android.R.layout.simple_list_item_1, strMoneda);

        dije.setAdapter(adapter_dije);
        tipoManilla.setAdapter(adapter_tipoManilla);
        material.setAdapter(adapter_material);
        moneda.setAdapter(adapter_moneda);
    }
    public void calcular(View v){
        int op_dije, op_manilla, op_material, op_moneda;
        double cant, resultado = 0;

        if (validar()){
            cant = Double.parseDouble(cantidad.getText().toString());
            op_dije = dije.getSelectedItemPosition();
            op_manilla = tipoManilla.getSelectedItemPosition();
            op_material = material.getSelectedItemPosition();
            op_moneda = moneda.getSelectedItemPosition();
            switch (op_dije){
                case 0:
                    switch (op_material){
                        case 0:
                            switch (op_manilla){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 384000 * cant;
                                            break;
                                        case 1:
                                            resultado = 120 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 320000 * cant;
                                            break;
                                        case 1:
                                            resultado = 100 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 288000 * cant;
                                            break;
                                        case 1:
                                            resultado = 90 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 1:
                            switch (op_manilla){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 352000 * cant;
                                            break;
                                        case 1:
                                            resultado = 110 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 288000 * cant;
                                            break;
                                        case 1:
                                            resultado = 90 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 256000 * cant;
                                            break;
                                        case 1:
                                            resultado = 80 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }break;
                case 1:
                    switch (op_material){
                        case 0:
                            switch (op_manilla){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 320000 * cant;
                                            break;
                                        case 1:
                                            resultado = 100 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 256000 * cant;
                                            break;
                                        case 1:
                                            resultado = 80 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 224000 * cant;
                                            break;
                                        case 1:
                                            resultado = 70 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 1:
                            switch (op_manilla){
                                case 0:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 288000 * cant;
                                            break;
                                        case 1:
                                            resultado = 90 * cant;
                                            break;
                                    }
                                    break;
                                case 1:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 352000 * cant;
                                            break;
                                        case 1:
                                            resultado = 110 * cant;
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (op_moneda) {
                                        case 0:
                                            resultado = 160000 * cant;
                                            break;
                                        case 1:
                                            resultado = 50 * cant;
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            valorTotal.setText(""+resultado);
            valorUnitario.setText(""+resultado/cant);
        }
    }

    public boolean validar(){
        if (cantidad.getText().toString().isEmpty()){
            cantidad.requestFocus();
            cantidad.setError("Digite una cantidad minima de 1");
            return false;
        }
        if (Integer.parseInt(cantidad.getText().toString())==0){
            cantidad.requestFocus();
            cantidad.setError("Digite un valor superior a cero");
            return false;
        }
        return true;
    }

    public void borrar(View v){
        cantidad.setText("");
        valorUnitario.setText("");
        valorTotal.setText("");
        cantidad.requestFocus();
        dije.setSelection(0);
        tipoManilla.setSelection(0);
        material.setSelection(0);
        moneda.setSelection(0);


    }
}
