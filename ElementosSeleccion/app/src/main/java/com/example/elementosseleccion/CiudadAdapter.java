package com.example.elementosseleccion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CiudadAdapter extends ArrayAdapter<Ciudad> {
    private Context context;
    private List<Ciudad> ciudades;

    public CiudadAdapter(Context context, List<Ciudad> ciudades){
        super(context,0,ciudades);
        this.context = context;
        this.ciudades = ciudades;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_ciudad, parent, false);
        }

        Ciudad ciudad = getItem(position);

        ImageView imageViewCiudad = convertView.findViewById(R.id.imageViewCiudad);
        TextView textViewCiudad = convertView.findViewById(R.id.textViewCiudad);
        TextView textViewDescripcion = convertView.findViewById(R.id.textViewDescripcion);

        if (ciudad != null) {
            imageViewCiudad.setImageResource(ciudad.getImagenID());
            textViewCiudad.setText(ciudad.getNombre());
            textViewDescripcion.setText(ciudad.getDescripcion());
        }
        return convertView;
    }
}
