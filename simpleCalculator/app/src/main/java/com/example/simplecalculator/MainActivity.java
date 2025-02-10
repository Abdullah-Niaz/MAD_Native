package com.example.simplecalculator;// MainActivity.java
import com.example.simplecalculator.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    TextView result;
    Button abdullah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        abdullah = findViewById(R.id.abdullah);

        abdullah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        String value1 = num1.getText().toString();
        String value2 = num2.getText().toString();
        if (value1.isEmpty() || value2.isEmpty()) {
            result.setText("Please enter numbers");
            return;
        }

        double number1 = Double.parseDouble(value1);
        double number2 = Double.parseDouble(value2);
        double res = number1 + number2;

        result.setText(""+res);
    }
}