package com.example.fechahora;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button miBotonFecha;
    private TextView miTextoFecha;
    private TextView miTextoHora;
    private Button miBotonHora;
    private TextView miTextoFechaHora;
    private Button miBotonFechaHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        miBotonFecha = findViewById(R.id.button);
        miTextoFecha = findViewById(R.id.textView);

        miBotonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendario = Calendar.getInstance();
                int ano = calendario.get(Calendar.YEAR);
                int mes = calendario.get(Calendar.MONTH);
                int dia = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog miDatePicker = new DatePickerDialog(MainActivity.this,(view,selectedYear,selectedMonth,selectedDay) ->{
                    miTextoFecha.setText("Fecha seleccionada: " + selectedDay + "/" + (selectedMonth+1) + "/" + selectedYear);
                }, ano, mes, dia);
                miDatePicker.show();
            }
        });

        miBotonHora = findViewById(R.id.button2);
        miTextoHora = findViewById(R.id.textView2);

        miBotonHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendario2 = Calendar.getInstance();
                int hora = calendario2.get(Calendar.HOUR_OF_DAY);
                int minuto = calendario2.get(Calendar.MINUTE);

                TimePickerDialog miTimePicker = new TimePickerDialog(MainActivity.this, (view, selectedHour, selectedMinute) -> {
                    miTextoHora.setText("Hora seleccionada: " + selectedHour + ":" + selectedMinute);
                }, hora, minuto, true);
                miTimePicker.show();
            }
        });

        miBotonFechaHora = findViewById(R.id.button3);
        miTextoFechaHora = findViewById(R.id.textView4);

        miBotonFechaHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendario3 = Calendar.getInstance();
                int ano1 = calendario3.get(Calendar.YEAR);
                int mes1 = calendario3.get(Calendar.MONTH);
                int dia1 = calendario3.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, selectedYear, selectedMonth, selectedDay) -> {
                    int hora1 = calendario3.get(Calendar.HOUR_OF_DAY);
                    int minuto1 = calendario3.get(Calendar.MINUTE);

                    TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, (view1, selectedHour, selectedMinute) ->{
                        miTextoFechaHora.setText("Fecha y hora seleccionados: " + selectedDay + "/" + (selectedMonth+1) + "/" + selectedYear + " " + selectedHour + ":" + selectedMinute);
                    }, hora1, minuto1, true);
                    timePickerDialog.show();
                }, ano1, mes1, dia1);
                datePickerDialog.show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}