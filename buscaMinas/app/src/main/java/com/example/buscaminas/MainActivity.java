package com.example.buscaminas;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

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

        int hayMina = 0;
        ArrayList<Integer> colorines = new ArrayList<Integer>();
        ArrayList<Button> botones = new ArrayList<Button>();
        ArrayList<Integer> minas = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            TableRow row = new TableRow(this);
            for (int x = 1; x <=3; x++) {
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        0,
                        TableRow.LayoutParams.WRAP_CONTENT,
                        1 //layout_weight
                ));
                row.addView(button);
                int color = getRandomColor();
                button.setBackgroundColor(color);
                colorines.add(color);
                botones.add(button);
                hayMina = (int)(Math.random()*2);
                minas.add(hayMina);
                button.setOnClickListener(view -> {
                    for (int j = 0; j < botones.size(); j++) {
                        if(minas.get(j) == 0){
                            botones.get(j).setBackgroundColor(0xFFFFFF);
                        }else {
                            botones.get(j).setBackgroundColor(0xFF0000);
                        }
                    }
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