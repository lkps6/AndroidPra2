package com.example.prac2calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText n1,n2;
    Button btnCal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.txtNumero1);
        n2 = findViewById(R.id.txtNumero2);
        btnCal =findViewById(R.id.btnCalcular);

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operaciones();
            }
        });
    }
    void operaciones(){
        //obtener datos
        String nu1,nu2;
        nu1 = n1.getText().toString();
        nu2 = n2.getText().toString();
        Toast.makeText(this, "Nu1: "+nu1+" Nu2: "+nu2, Toast.LENGTH_SHORT).show();


        //Menu
        boolean ban1 = ValidarNumeros(nu1);
        boolean ban2 = ValidarNumeros(nu2);
        if (ban1 == false) {
            if (ValidarDecimales(nu1)) {
                ban1 = true;
            }
        } else if (ban1 == true) {
            int a = Integer.parseInt(nu1);
            int b = Integer.parseInt(nu2);
            int suma = a + b;
            Toast.makeText(MainActivity.this, "Es resultado es: " + suma, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Error de numeros", Toast.LENGTH_SHORT).show();
        }
        if (ban2 == false) {
            if (ValidarDecimales(nu2)) {
                ban2 = true;
            }
        }
    };

        //fin de menu


    boolean ValidarNumeros(String a){
        int cv1=0;
        for (int x=0;x<a.length();x++){
            //Toast.makeText(this, a.charAt(x)+" "+a.codePointAt(x), Toast.LENGTH_SHORT).show();
            if (a.codePointAt(x)>=48 && a.codePointAt(x)<=57){
                cv1++;

            }
        }
        if (cv1 == a.length()){
            // Toast.makeText(this, "Todos son numeros", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            /*  Toast.makeText(this, "No todo son numeros", Toast.LENGTH_SHORT).show();*/
            return false;
        }
    }

    boolean ValidarDecimales(String a){
        int cv1=0,cp=0;
        for (int x=0;x<a.length();x++){
            //Toast.makeText(this, a.charAt(x)+" "+a.codePointAt(x), Toast.LENGTH_SHORT).show();
            if (a.codePointAt(x)>=48 && a.codePointAt(x)<=57){
                cv1++;

            }
            if (a.codePointAt(x)==46){
                cp++;
                Toast.makeText(this, "cp "+cp, Toast.LENGTH_SHORT).show();
            }
        }
        if (cv1 == a.length() && cp==1){
            // Toast.makeText(this, "Todos son numeros", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            /*  Toast.makeText(this, "No todo son numeros", Toast.LENGTH_SHORT).show();*/
            return false;
        }
    }
}