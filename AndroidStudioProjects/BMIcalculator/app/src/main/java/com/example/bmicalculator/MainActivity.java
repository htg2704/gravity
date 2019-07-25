package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    TextView result;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        calculate = (Button) findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI(){
        String hstr = height.getText().toString();
        String wstr = weight.getText().toString();

        if(hstr != null && !"".equals(hstr) && wstr != null && !"".equals(wstr)){
            float h = Float.parseFloat(hstr)/100;
            float w = Float.parseFloat(wstr);
            float bmi = w/(h*h);

            displayBMI(bmi);
        }
    }

    public void displayBMI(float bmi){
        String bmilabel = "";
        if(bmi<15)
            bmilabel = "Severely Underweight, go and see a doctor";
        else if(bmi>15&& bmi<18)
            bmilabel = "Underweight";
        else if(bmi>18&& bmi<25)
            bmilabel = "You are normal";
        else
            bmilabel = "Overweight, hit the gym";

        bmilabel = bmi + "\n" + bmilabel;
        result.setText(bmilabel);
    }
}
