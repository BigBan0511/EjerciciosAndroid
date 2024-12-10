package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button boton;
    TextView texto;
    public String actual = "";
    public boolean seHaUsadoOperando = false;
    public String resultadoTotal;
    String num1 = "";
    String num2 = "";
    String signo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.salirNum);
        int botones[] = {R.id.boton0, R.id.boton1, R.id.boton2, R.id.boton3, R.id.boton4,
                        R.id.boton5, R.id.boton6, R.id.boton7, R.id.boton8, R.id.boton9,
                        R.id.botonMas, R.id.botonMenos, R.id.botonIgual, R.id.botonAc,
                        R.id.botonMulti, R.id.botonComa, R.id.botonDiv};
        for(int id: botones){
            findViewById(id).setOnClickListener(this);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick(View view) {
        if(view.getId() == R.id.botonAc) {
            texto.setText("");
            actual = "";
            signo = "";
            seHaUsadoOperando = false;
        } else if (view.getId() == R.id.botonDiv) {
            if(!texto.equals("") && !seHaUsadoOperando) {
                seHaUsadoOperando = true;
                num1 = actual;
                actual = "";
                signo = "/";
            }
        } else if (view.getId() == R.id.botonMulti) {
            if(!texto.equals("") && !seHaUsadoOperando) {
                seHaUsadoOperando = true;
                num1 = actual;
                actual = "";
                signo = "X";
            }
        } else if (view.getId() == R.id.botonMenos) {
            if(!texto.equals("") && !seHaUsadoOperando) {
                seHaUsadoOperando = true;
                num1 = actual;
                actual = "";
                signo = "-";
            }
        } else if (view.getId() == R.id.botonMas) {
            if(!texto.equals("") && !seHaUsadoOperando) {
                seHaUsadoOperando = true;
                num1 = actual;
                actual = "";
                signo = "+";
            }
        } else if (view.getId() == R.id.botonIgual) {
            num2 = actual;
            resultadoTotal = operaciones(num1, num2, signo);
            texto.setText(resultadoTotal);
            actual = "";
        } else if (view.getId() == R.id.botonComa) {
            if(!actual.contains(".")){
                actual = actual + ".";
            }
        }else {
            if(seHaUsadoOperando) {
                actual = actual + ((Button) view).getText();
                texto.setText(actual);
            }else {
                actual = actual + ((Button) view).getText();
                texto.setText(actual);
            }
        }
    }

    public String operaciones(String num1, String num2, String signo){
        int resultado = 0;
        double resultadoDec = 0;
        if(num1.contains(".") || num2.contains(".")) {
            if (signo.equals("+")) {
                resultadoDec = Double.parseDouble(num1) + Double.parseDouble(num2);
            } else if (signo.equals("-")) {
                resultadoDec = Double.parseDouble(num1) - Double.parseDouble(num2);
            } else if (signo.equals("X")) {
                resultadoDec = Double.parseDouble(num1) * Double.parseDouble(num2);
            } else if (signo.equals("/")) {
                resultadoDec = Double.parseDouble(num1) / Double.parseDouble(num2);
            }
            return Double.toString(resultadoDec);
        }else {
            if (signo.equals("+")) {
                resultado = Integer.parseInt(num1) + Integer.parseInt(num2);
            } else if (signo.equals("-")) {
                resultado = Integer.parseInt(num1) - Integer.parseInt(num2);
            } else if (signo.equals("X")) {
                resultado = Integer.parseInt(num1) * Integer.parseInt(num2);
            } else if (signo.equals("/")) {
                resultadoDec = Double.parseDouble(num1) / Double.parseDouble(num2);
                return Double.toString(resultadoDec);
            }
            return Integer.toString(resultado);
        }
    }
}