package com.example.meusegundoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView resultado;
    private Button btnSomar;

    @BindView(R.id.btnSubtrair)
    protected Button btnSubtrair;

    @OnClick(R.id.btnSubtrair)
    void subtrair(){
        double n1, n2;
        try {
            n1 = Double.parseDouble(etNum1.getText().toString());
            n2 = Double.parseDouble(etNum2.getText().toString());
            resultado.setText("Resultado: " + (n1 - n2));
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Inserir os operandos!", Toast.LENGTH_SHORT).show();
        }
    }

    @BindView(R.id.btnMultiplicar)
    protected Button btnMultiplicar;

    @OnClick(R.id.btnMultiplicar)
    void multiplicar(){
        double n1, n2;
        try {
            n1 = Double.parseDouble(etNum1.getText().toString());
            n2 = Double.parseDouble(etNum2.getText().toString());
            resultado.setText("Resultado: " + (n1 * n2));
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Inserir os operandos!", Toast.LENGTH_SHORT).show();
        }
    }

    @BindView(R.id.btnDividir)
    protected Button btnDividir;

    @OnClick(R.id.btnDividir)
    void dividir(){
        double n1, n2;
        try{
            n1 = Double.parseDouble(etNum1.getText().toString());
            n2 = Double.parseDouble(etNum2.getText().toString());
            resultado.setText("Resultado: "+ (n1/n2));
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Inserir os operandos!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        etNum1 = (EditText) findViewById(R.id.etPrimeiroNumero);
        etNum2 = (EditText) findViewById(R.id.etSegundoNumero);
        resultado = (TextView) findViewById(R.id.tvResultado);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1, n2;
                try{
                    n1 = Double.parseDouble(etNum1.getText().toString());
                    n2 = Double.parseDouble(etNum2.getText().toString());
                    resultado.setText("Resultado: "+ (n1+n2));
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Inserir os operandos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
