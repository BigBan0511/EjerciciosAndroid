package com.example.ejemplolayoutscont;

import android.os.Bundle;
import android.view.View;
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
    private TableLayout tablelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tablelayout = findViewById(R.id.tableLayout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (int i = 0; i < tablelayout.getChildCount(); i++){
            View row = tablelayout.getChildAt(i);//Obtiene cada TableRow
            if(row instanceof TableRow){
                TableRow tableRow = (TableRow) row;
                for (int j = 0; j < tableRow.getChildCount(); j++) {
                    View child = tableRow.getChildAt(j);
                    if(child instanceof EditText){
                        String text = ((EditText) child).getText().toString();
                        Toast.makeText(this, "EditText:" + text, Toast.LENGTH_SHORT).show();
                    } else if (child instanceof Button) {
                        String text = ((Button) child).getText().toString();
                        Toast.makeText(this, "Button: " + text, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }


    
}