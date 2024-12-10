package com.example.elementosseleccion;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        List<Ciudad> ciudades = new ArrayList<>();
        ciudades.add(new Ciudad("Ciudad Real", "Capital de la provincia de Ciudad Real,"
                        + "famosa por su arquitectura histórica.", R.drawable.ciudad_real));
        ciudades.add(new Ciudad("Toledo", "Antigua capital de España, conocida por su patrimonio"
                + "cultural y su casco histórico.", R.drawable.toledo));
        ciudades.add(new Ciudad("Guadalajara", "Ciudad conocida por su rica historia"
                + "y sus monumentos medievales.", R.drawable.guadalajara));
        ciudades.add(new Ciudad("Cuenca", "Famosa por sus casas colgadas y su casco antiguo,"
                + "declarado Patrimonio de la Humanidad.", R.drawable.cuenca));
        ciudades.add(new Ciudad("Albacete", "Conocida por su industria cuchillera "
                + "y su rica gastronomía.", R.drawable.albacete));
        ciudades.add(new Ciudad("Madrid", "La capital de España, famosa por su cultura,"
                + " museos y vida nocturna.", R.drawable.madrid));

        //EJEMPLO 1: ArrayAdapter<String> miAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ciudades);
        //ArrayAdapter<String> miAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, ciudades);

        CiudadAdapter ciudadAdapter = new CiudadAdapter(this, ciudades);
        ListView lista = findViewById(R.id.listView);
        lista.setAdapter(ciudadAdapter);
        lista.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        /*EJEMPLO 1: lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Seleccionaste: " + item, Toast.LENGTH_SHORT).show();
            }
        });*/
        final TextView textView = findViewById(R.id.textView);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Ciudad item = (Ciudad) parent.getItemAtPosition(position);
                boolean isItemChecked = lista.isItemChecked(position);

                if(isItemChecked){
                    Toast.makeText(MainActivity.this, "Seleccionaste: "
                            + item, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Desmarcaste: "
                            + item, Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(MainActivity.this, "Seleccionaste: " + item, Toast.LENGTH_SHORT).show();
                updateSelectedItems(lista, textView);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void updateSelectedItems(ListView listView, TextView textView){
        StringBuilder seleccionados = new StringBuilder();

        for (int i = 0; i < listView.getCount(); i++) {
            if(listView.isItemChecked(i)){
                if(seleccionados.length() > 0){
                    seleccionados.append(", ");
                }
                Ciudad ciudad = (Ciudad) listView.getItemAtPosition(i);
                seleccionados.append(ciudad.getNombre());
            }
        }

        if(seleccionados.length() > 0){
            textView.setText(seleccionados.toString());
        }else{
            textView.setText("No has seleccionado ningún item");
        }
    }
}