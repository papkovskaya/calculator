package com.example.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculator.polish_processing.PolishProcessor;

import java.util.LinkedList;


public class MainActivity extends Activity implements OnClickListener {
    EditText str;

    int operand, ost, flagAction, len, pow;
    double result;
    float floatOst, floatOperand;
    String string;
    LinkedList<Float> st = new LinkedList<>();
    LinkedList<Character> op = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str = findViewById(R.id.viewNumbers);
        operand = 0;
        result = 0;
        flagAction = 0;
        floatOperand = 0;
        pow = 1;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.one:
                ClickNumber(1);
                break;

            case R.id.two:
                ClickNumber(2);
                break;

            case R.id.three:
                ClickNumber(3);
                break;

            case R.id.four:
                ClickNumber(4);
                break;

            case R.id.five:
                ClickNumber(5);
                break;

            case R.id.six:
                ClickNumber(6);
                break;

            case R.id.seven:
                ClickNumber(7);
                break;

            case R.id.eight:
                ClickNumber(8);
                break;

            case R.id.nine:
                ClickNumber(9);
                break;

            case R.id.zero:
                ClickNumber(0);
                break;

            case R.id.plus:
                ClickOperator(R.string.plus);
                break;

            case R.id.minus:
                ClickOperator(R.string.minus);
                break;

            case R.id.multiply:
                ClickOperator(R.string.multiply);
                break;

            case R.id.divide:
                ClickOperator(R.string.divide);
                break;

            case R.id.dot:
                ClickDoubleNumber();
                break;

            case R.id.equal:
                string = str.getText().toString();
                result = PolishProcessor.eval(string);
                str.setText(Double.toString(result));
                operand = 0;
                floatOperand = 0;
                result = 0;
                flagAction = 0;
                break;

            case R.id.clear:
                operand = 0;
                floatOperand = 0;
                result = 0;
                flagAction = 0;
                str.setText(Integer.toString(operand));
                break;
        }

    }

    private void ClickDoubleNumber() {
        str.append(".");
    }


    private void ClickNumber(int num){
        if(flagAction == 0){
            operand = operand*10 + num;
            str.setText(Integer.toString(num));
            flagAction = 1;
        }else if (flagAction == 1){
            operand = operand*10 + num;
            str.append(Integer.toString(num));
        }
    }

    private void ClickOperator(int stringResourceId){
        str.append(this.getResources().getString(stringResourceId));
        operand = 0;
        floatOperand = 0;
        ost = 0;
        floatOst = 0;
    }
}