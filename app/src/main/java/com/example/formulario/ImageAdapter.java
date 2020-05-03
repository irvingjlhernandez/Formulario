package com.example.formulario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.formulario.R.id.ivLogo;

public class ImageAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    int ancho;
    String[][] datos;

    private int[] thumbs ={
            R.drawable.honda,
            R.drawable.che,
            R.drawable.vw,
            R.drawable.ford
    };

    public ImageAdapter(Context contexto, int ancho, String[][] datos) {
        this.contexto = contexto;
        this.ancho = ancho;
        this.datos = datos;
        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.length;
    }

    @Override
    public Object getItem(int position) {
        return datos[position];
    }

    @Override
    public long getItemId(int position) {
        return Long.valueOf(datos[position][0]);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);
        TextView tvMarca = vista.findViewById(R.id.tvNomModelo);
        TextView tvModelo = vista.findViewById(R.id.tvMarca);
        TextView tvPrecio = vista.findViewById(R.id.tvPrecio);
        ImageView ivLogo = vista.findViewById(R.id.ivLogo);
        tvMarca.setText(contexto.getResources().getString(R.string.ma)+" "+datos[position][1]);
        tvModelo.setText(contexto.getResources().getString(R.string.mo)+" "+datos[position][2]);
        tvPrecio.setText(contexto.getResources().getString(R.string.pr)+" "+contexto.getResources().getString(R.string.moneda)+" "+datos[position][3]);
        ivLogo.setImageResource(thumbs[val(datos[position][1])]);
        return vista;
    }

    public int val(String cadena){
        int posi = 0;
        switch(cadena){
            case "Honda":
                posi = 0;
                break;
            case "Chevrolet":
                posi = 1;
                break;
            case "Volkswagen":
                posi = 2;
                break;
            case "Ford":
                posi = 3;
                break;
        }
        return posi;
    }

}
