package com.example.ejemplodialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DialogoConInput extends DialogFragment {
    private EditText editText;
    private OnInputListener miListener;

    public interface OnInputListener{
        void onInputRecieved(String input);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        LayoutInflater inflater = getActivity().getLayoutInflater();
        editText = new EditText(getActivity());
        editText.setHint("Ingresa el nombre de tu equipo");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Introduce el nombre de tu equipo").setView(editText)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String input = editText.getText().toString();
                if(miListener != null){
                    miListener.onInputRecieved(input);
                }
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    public void onAttach(android.content.Context context){
        super.onAttach(context);

        if (context instanceof OnInputListener) {
           miListener = (OnInputListener) context;
        }else {
            throw new RuntimeException(context.toString() + " must implement OnInputListener");
        }
    }





    /*public Dialog onCreateDialog(Bundle savedInstanceState){
        editText = new EditText(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Introduce tu nombre").setView(editText).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String input = editText.getText().toString();
                Toast.makeText(getActivity(),"Hola, " + input, Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Operacion cancelada", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }*/


}
