package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private TextView unitView;
    private EditText editText;

    private boolean change=true;
    private double C,F;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.c);
        unitView = findViewById(R.id.d);
        editText = findViewById(R.id.print);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                                if(change==true)
                                {
                                    C = Double.parseDouble(editText.getText().toString());
                                    F= (1.8*C)+32;
                                    BigDecimal BD = new BigDecimal(F);
                                    unitView.setText("°F");
                                    textView.setText("華氏溫度");
                                    button.setText("華氏轉為攝氏");
                                    editText.setText(String.valueOf(BD.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()));
                                    change=false;
                                }
                                else {
                                    F = Double.parseDouble(editText.getText().toString());
                                    C= (F-32)/1.8;
                                    BigDecimal BD = new BigDecimal(C);
                                    unitView.setText("°C");
                                    textView.setText("攝氏溫度");
                                    button.setText("攝氏轉為華氏");
                                    editText.setText(String.valueOf(BD.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()));
                                    change=true;
                                }
                            }
                        }
                );


    }
}
