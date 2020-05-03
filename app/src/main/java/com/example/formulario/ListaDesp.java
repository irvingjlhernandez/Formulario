package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaDesp extends AppCompatActivity{

    int ancho,alto,i=0,elementos;
    ListView lv;
    ArrayList<Auto> autos = new ArrayList<Auto>();
    String id,modelo,marca,precio,elide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_desp);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();

        display.getSize(size);
        ListView lv;

        ancho = size.x;
        alto = size.y;

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        autos = (ArrayList<Auto>) bundle.getSerializable("autos");
        elementos = autos.size();
        String[][] datos = new String[elementos][4];

        elide = getResources().getString(R.string.elide);

        for(i=0;i<elementos;i++){
            datos[i][0] = autos.get(i).getId();
            datos[i][1] = autos.get(i).getMarca();
            datos[i][2] = autos.get(i).getModelo();
            datos[i][3] = autos.get(i).getPrecio();
        }

        final ImageAdapter imageAdapter = new ImageAdapter(this,ancho,datos);
        lv = findViewById(R.id.lv);
        lv.setAdapter(imageAdapter);
        lv.setOnItemClickListener(onClickListView);

    }
    private ListView.OnItemClickListener onClickListView = new  ListView.OnItemClickListener(){
        @Override
        public void onItemClick(final AdapterView<?> adapter, View v, int position, long arg){
            String ide = autos.get(position).getId();
            Toast.makeText(ListaDesp.this, elide+" "+ide+".",Toast.LENGTH_LONG).show();
        }
    };

}
