package com.demo.simplecalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText input_a, input_b;
    Button btn_calculate_add;
    TextView text_result;
    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_a = (EditText) findViewById(R.id.input_text_a);
        input_b = (EditText) findViewById(R.id.input_text_b);
        btn_calculate_add = (Button) findViewById(R.id.btn_calculate_add);
        text_result = (TextView) findViewById(R.id.text_result);


        btn_calculate_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(input_a.getText().toString());
                int b = Integer.parseInt(input_b.getText().toString());
                int result = calculateAdd(a, b);
                text_result.setText("" + result);
            }
        });
    }

    private int calculateAdd(int a, int b) {
        return a + b;
    }

    @Override
    protected void onSaveInstanceState(Bundle guardaEstado) {
        super.onSaveInstanceState(guardaEstado);
        //guardamos en la variable t el texto del campo EditText
        resultado = text_result.getText().toString();
        //lo "guardamos" en el Bundle
        guardaEstado.putString("text", resultado);
    }

    @Override
    protected void onRestoreInstanceState(Bundle recuperaEstado) {
        super.onRestoreInstanceState(recuperaEstado);
        //recuperamos el String del Bundle
        resultado = recuperaEstado.getString("text");
        //Seteamos el valor del EditText con el valor de nuestra cadena
        text_result.setText(resultado);
    }

}
