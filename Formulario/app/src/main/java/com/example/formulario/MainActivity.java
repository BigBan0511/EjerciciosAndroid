package com.example.formulario;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button enviarDatos;
    EditText etNombre, etEmail, etTelefono, etDireccion;
    RadioGroup generos;
    CheckBox condiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        enviarDatos = findViewById(R.id.sendDatos);
        etNombre = findViewById(R.id.editTextNombre);
        etEmail = findViewById(R.id.editTextTextEmailAddress);
        etTelefono = findViewById(R.id.editTextPhone);
        etDireccion = findViewById(R.id.editTextTextPostalAddress);
        generos = findViewById(R.id.radioGroup);
        condiciones = findViewById(R.id.checkBox);
        enviarDatos.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        String nombre = etNombre.getText().toString();
        String email = etEmail.getText().toString();
        String telefono = etTelefono.getText().toString();
        String direccion = etDireccion.getText().toString();

        int seleccion;
        boolean acepto = condiciones.isSelected();

        if(generos.getCheckedRadioButtonId() == R.id.generoHombre){
            seleccion = 1;
        } else if (generos.getCheckedRadioButtonId() == R.id.generoMujer) {
            seleccion = 2;
        }else{
            seleccion = -1;
        }

        if(!email.contains("@")){
            Toast.makeText(MainActivity.this, "El email introducido es invalido",
                    Toast.LENGTH_SHORT).show();
            return;
        }


        if(nombre.isEmpty() || email.isEmpty() || seleccion == -1){
            Toast.makeText(MainActivity.this, "Por favor completa todos los campos",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(!acepto){
            Toast.makeText(MainActivity.this, "Debes aceptar las condiciones",
                    Toast.LENGTH_SHORT).show();
            return;
        }
    }
}