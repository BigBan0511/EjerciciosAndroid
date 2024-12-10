package com.example.ejercicio8;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.MATCH_PARENT
        ));

        setContentView(tableLayout);

        ViewCompat.setOnApplyWindowInsetsListener(tableLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Integer> colorines = new ArrayList<Integer>();
        ArrayList<Button> botones = new ArrayList<Button>();
        int contador = 1;
        for (int i = 1; i <= 5; i++) {
            TableRow row = new TableRow(this);
            for (int x = 1; x <=3; x++) {
                final int buttonIndex = x; //Variable final para usar en la lambda
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1 //layout_weight
                ));
                button.setText("Botón " + contador);
                contador++;
                row.addView(button);
                int color = getRandomColor();
                button.setBackgroundColor(color);
                colorines.add(color);
                botones.add(button);
                button.setOnClickListener(view -> {
                    button.setBackgroundColor(0xFFFFFF);
                });
            }
            tableLayout.addView(row);
        }

        TableRow row2 = new TableRow(this);
        Button button = new Button(this);
        button.setLayoutParams(new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1
        ));
        button.setText("RESET");
        row2.addView(button);
        tableLayout.addView(row2);
        button.setOnClickListener(view -> {
            for (int x = 0; x < botones.size(); x++) {
                botones.get(x).setBackgroundColor(colorines.get(x));
            }
        });
    }

    private int getRandomColor(){
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}