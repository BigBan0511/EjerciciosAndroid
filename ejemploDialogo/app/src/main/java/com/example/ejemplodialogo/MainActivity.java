package com.example.ejemplodialogo;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity implements DialogoConInput.OnInputListener {
    private EditText editTextEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnMostrarDialogo = findViewById(R.id.btnMostrarDialogo);
        btnMostrarDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miDialogoFragment dialogoFragment = new miDialogoFragment();
                dialogoFragment.show(getSupportFragmentManager(), "mi_dialogo");
            }
        });

        editTextEquipo = findViewById(R.id.editTextEquipo);
        Button btnMostrarInput = findViewById(R.id.btnInput);
        btnMostrarInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoConInput dialogoConInput = new DialogoConInput();
                dialogoConInput.show(getSupportFragmentManager(), "dialogo_con_input");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onInputRecieved(String input){
        editTextEquipo.setText(input);
        Toast.makeText(this, "Equipo recibido: " + input, Toast.LENGTH_SHORT).show();
    }
}