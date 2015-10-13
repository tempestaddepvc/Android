package com.example.juanpablo.pr008_cardviewpropina;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    protected EditText txtCuenta;
    protected EditText txtPorcentajeProp;
    protected EditText txtPropina;
    protected Button btnRedondear1;
    protected EditText txtPorComensal;
    protected Button btnRedondear2;
    protected EditText txtTotal;
    protected Button btnLimpiar2;
    protected Button btnLimpiar1;
    protected EditText txtComensales;
    protected Button btnCalcular;
    protected Button btnCalcular2;
    public OnClickListener calculador=new OnClickListener(){

        @Override
        public void onClick(View v) {
            calcular();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    protected void initViews(){
        txtCuenta=(EditText) findViewById(R.id.txtCuenta);
        txtPorcentajeProp=(EditText) findViewById(R.id.txtPorcentajeProp);
        txtPropina=(EditText) findViewById(R.id.txtPropina);
        txtPorComensal=(EditText) findViewById(R.id.txtPorComensal);
        txtTotal=(EditText) findViewById(R.id.txtTotal);
        txtComensales=(EditText) findViewById(R.id.txtComensales);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(calculador);
        btnCalcular2=(Button) findViewById(R.id.btnCalcular2);
        btnCalcular2.setOnClickListener(calculador);
        btnLimpiar1=(Button) findViewById(R.id.btnLimpiar1);
        btnLimpiar1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTotal.setText("");
                txtPropina.setText("");
                txtPorcentajeProp.setText("");
                txtCuenta.setText("");
            }
        });
        btnLimpiar2=(Button) findViewById(R.id.btnLimpiar2);
       btnLimpiar2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtComensales.setText("");
                txtPorComensal.setText("");
            }
        });
        btnRedondear1=(Button) findViewById(R.id.btnRedondear1);
        btnRedondear1.setOnClickListener(new OnClickListener() {
            float auxiliar;
            public void onClick(View v) {
                if(!TextUtils.isEmpty(txtTotal.getText().toString())){
                    auxiliar=Float.parseFloat(txtTotal.getText().toString());
                    auxiliar=Math.round(auxiliar);
                    txtTotal.setText(auxiliar + "");
                }
            }
        });
        btnRedondear2=(Button) findViewById(R.id.btnRedondear2);
        btnRedondear2.setOnClickListener(new OnClickListener() {
            float auxiliar;
            public void onClick(View v) {
                if(!TextUtils.isEmpty(txtPorComensal.getText().toString())){
                    auxiliar=Float.parseFloat(txtPorComensal.getText().toString());
                    auxiliar=Math.round(auxiliar);
                    txtPorComensal.setText(auxiliar + "");
                }
            }
        });


    }


    protected void calcular(){
        float cuenta=0;
        float porcentaje=0;
        float propina=0;
        float total=0;
        float numeroComensales=1;
        float porComensal=0;
        if(!TextUtils.isEmpty(txtCuenta.getText().toString())){
            cuenta = Float.parseFloat(txtCuenta.getText().toString());
        }

        if(!TextUtils.isEmpty(txtPorcentajeProp.getText().toString())) {
            porcentaje = Float.parseFloat(txtPorcentajeProp.getText().toString()) /100;
        }
        if(!TextUtils.isEmpty(txtComensales.getText().toString())) {
            numeroComensales = Float.parseFloat(txtComensales.getText().toString());
        }
        propina=cuenta*porcentaje;
        total=cuenta+propina;
        porComensal=total/numeroComensales;
        txtPropina.setText(String.format( "%.2f",propina));
        txtTotal.setText(String.format( "%.2f",total));
        txtPorComensal.setText(String.format( "%.2f",porComensal));
    }
}
