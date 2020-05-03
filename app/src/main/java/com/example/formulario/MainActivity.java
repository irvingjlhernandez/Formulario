package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etModelo, etPrecio;
    Spinner spinner;
    ImageButton ibEliminar,ibAgregar,ibGuardar;
    String strModelo, strPrecio,strSpinner,vacSpinner,modval,valprec,nah,vacia,elimino;
    String mo,ma,pr,mod,marc,prec,error;
    ArrayList<Auto> autos = new ArrayList<Auto>();
    int i = 0,ancho,alto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();

        display.getSize(size);

        ancho = size.x;
        alto = size.y;

        etModelo = findViewById(R.id.etModelo);
        etPrecio = findViewById(R.id.etPrecio);
        spinner = findViewById(R.id.spinner);
        ibAgregar = findViewById(R.id.ibAgregar);
        ibGuardar = findViewById(R.id.ibGuardar);
        ibEliminar = findViewById(R.id.ibEliminar);

        vacSpinner = getResources().getString(R.string.vacspinner);
        modval = getResources().getString(R.string.modval);
        valprec = getResources().getString(R.string.valprec);
        nah = getResources().getString(R.string.nah);
        vacia = getResources().getString(R.string.vacia);
        elimino = getResources().getString(R.string.elimino);
        mod = getResources().getString(R.string.mod);
        marc = getResources().getString(R.string.marc);
        prec = getResources().getString(R.string.prec);
        error = getResources().getString(R.string.error);

        ibEliminar.setOnClickListener(this);
        ibGuardar.setOnClickListener(this);
        ibAgregar.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ibAgregar:
                strModelo = etModelo.getText().toString();
                strPrecio = etPrecio.getText().toString();
                strSpinner = (String) spinner.getSelectedItem();
                if(strSpinner.equals(nah)){
                    Toast.makeText(MainActivity.this, vacSpinner, Toast.LENGTH_SHORT).show();
                }else{
                    if (noEstaVacio(strModelo)&&strModelo.length()<11&&comprobar(strModelo)) {
                        if (noEstaVacio(strPrecio)&&strPrecio.length()>5) {
                            etModelo.setText("");
                            etPrecio.setText("");
                            spinner.setSelection(0);
                            Auto autoTmp = new Auto(Integer.toString(i+1000),strModelo,strSpinner,strPrecio);
                            autos.add(autoTmp);
                            i++;

                        } else {
                            Toast.makeText(MainActivity.this, valprec, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, modval, Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.ibGuardar:
                try {
                    if (i == 0) {
                        Toast.makeText(MainActivity.this, vacia, Toast.LENGTH_SHORT).show();
                        break;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("autos",autos);

                    Intent intent = new Intent(MainActivity.this, ListaDesp.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, error + ".", Toast.LENGTH_SHORT).show();
                    break;
                }
                break;

            case R.id.ibEliminar:
                if(autos.isEmpty()){
                    Toast.makeText(MainActivity.this, vacia, Toast.LENGTH_SHORT).show();
                }else{
                    i--;
                    mo = autos.get(i).getModelo();
                    ma = autos.get(i).getMarca();
                    pr = autos.get(i).getPrecio();
                    autos.remove(i);
                    Toast.makeText(MainActivity.this, elimino +" "+mod+" "+mo+" "+marc+" "+ma+" "+prec+" "+pr+".", Toast.LENGTH_LONG).show();
                }
                break;
        }

    }

    protected boolean noEstaVacio(String s){
        if (s.equals("")) return false;
        return true;
    }

    protected boolean comprobar(String s){
        if (s.matches(".*[^A-Z0-9].*")) return false;
        return true;
    }

}
