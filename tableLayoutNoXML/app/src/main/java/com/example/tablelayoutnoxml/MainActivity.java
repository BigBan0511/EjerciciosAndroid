package com.example.tablelayoutnoxml;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TableLayout tableLayout; //Declaración de la variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Inicializa el TableLayout
        tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        ));
        setContentView(tableLayout);

        ViewCompat.setOnApplyWindowInsetsListener(tableLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Crear el primer TableRow con un EditText
        TableRow row1 = new TableRow(this);
        EditText editTextName = new EditText(this);
        editTextName.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        editTextName.setText("Hola");
        row1.addView(editTextName);
        tableLayout.addView(row1);

        //Crear el segundo TableRow con 3 botones
        TableRow row2 = new TableRow(this);
        for (int i = 1; i <=3; i++) {
            final int buttonIndex = i; //Variable final para usar en la lambda
            Button button = new Button(this);
            button.setLayoutParams(new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1 //layout_weight
            ));
            button.setText("Botón " + i);
            row2.addView(button);
            button.setOnClickListener(view -> {
                Toast.makeText(this, "Button " + buttonIndex + " clicked", Toast.LENGTH_SHORT).show();
            });
        }
        tableLayout.addView(row2);

        //Crear el tercer TableRow con 3 botones
        TableRow row3 = new TableRow(this);
        for (int i = 1; i <=3; i++) {
            final int buttonIndex = i; //Variable final para usar en la lambda
            Button button = new Button(this);
            button.setLayoutParams(new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1 //layout_weight
            ));
            button.setText("Botón " + i);
            row3.addView(button);
            button.setOnClickListener(view -> {
                Toast.makeText(this, "Button " + buttonIndex + " clicked", Toast.LENGTH_SHORT).show();
            });
        }
        tableLayout.addView(row3);

        //Crear el cuarto TableRow con 3 botones
        TableRow row4 = new TableRow(this);
        for (int i = 1; i <=3; i++) {
            final int buttonIndex = i; //Variable final para usar en la lambda
            Button button = new Button(this);
            button.setLayoutParams(new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1 //layout_weight
            ));
            button.setText("Botón " + i);
            row4.addView(button);
            button.setOnClickListener(view -> {
                Toast.makeText(this, "Button " + buttonIndex + " clicked", Toast.LENGTH_SHORT).show();
            });
        }
        tableLayout.addView(row4);
    }
}