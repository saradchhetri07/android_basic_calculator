package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText result;
    Button equals, one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, star, div,clear;
    String operator ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        equals = findViewById(R.id.equal);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        star = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);

        result = findViewById(R.id.result);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        star.setOnClickListener(this);
        div.setOnClickListener(this);
        equals.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        double finalResult=0.0;
        switch(view.getId()){
            case R.id.one: result.append("1"); break;
            case R.id.two: result.append("2"); break;
            case R.id.three: result.append("3"); break;
            case R.id.four: result.append("4"); break;
            case R.id.five: result.append("5"); break;
            case R.id.six: result.append("6"); break;
            case R.id.seven: result.append("7"); break;
            case R.id.eight: result.append("8"); break;
            case R.id.nine: result.append("9"); break;
            case R.id.zero: result.append("0"); break;

            case R.id.plus: result.append("+"); operator = "+"; break;
            case R.id.minus: result.append("-"); operator = "-"; break;
            case R.id.multiply: result.append("*"); operator = "*"; break;
            case R.id.divide: result.append("/"); operator = "/"; break;

            case R.id.equal: finalResult = evalExpression(result.getText().toString(), operator);
                result.setText(String.valueOf(finalResult)); break ;

            case R.id.clear: result.setText(" "); break;

        }
        System.out.println(finalResult);
    }

    private double evalExpression(String toString, String operator) {
        String[] tokens = toString.split("\\+|-|\\*|\\/");
        double valone = Double.parseDouble(tokens[0]);
        double valtwo = Double.parseDouble(tokens[1]);
        switch(operator){
            case "+": return valone + valtwo;
            case "-": return valone - valtwo;
            case "*": return valone * valtwo;
            case "/": return valone / valtwo;
            default: return 0;
        }
    }
}