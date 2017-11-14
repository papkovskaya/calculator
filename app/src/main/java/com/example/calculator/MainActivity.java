package com.example.calculator;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.calculator.polish_processing.PolishProcessor;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    EditText str;

    int operand1, operand2, flagAction, doubleAction, ost;
    double d_operand1, d_operand2;
    double result, number, root;
    String op, string;

    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionExit();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }


    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        str = (EditText) findViewById(R.id.viewNumbers);
        operand1 = 0;
        operand2 = 0;
        result = 0;
        flagAction = 0;
        ost = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.first_item:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                return true;
            case R.id.second_item:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                return true;
            case R.id.bin_item:
                Intent binaryActivityIntent = new Intent(this, BinaryActivity.class);
                startActivity(binaryActivityIntent);
                return true;
        }
        return false;
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
                ClickOperator("+");
                break;

            case R.id.minus:
                ClickOperator("-");
                break;

            case R.id.multiply:
                ClickOperator("*");
                break;

            case R.id.divide:
                ClickOperator("/");
                break;

            case R.id.dot:
                ClickDoubleNumber();
                break;

            case R.id.brackets:


            case R.id.equal:
                if(doubleAction == 1){
                    d_operand1 = operand1 + ost / Math.pow(10, Math.floor(Math.log10(ost) + 1));
                    d_operand2 = operand2 + ost / Math.pow(10, Math.floor(Math.log10(ost) + 1));
                } else{
                    d_operand1 = operand1;
                    d_operand2 = operand2;
                }
                Start(d_operand1, d_operand2, op);
                str.setText(Double.toString(result));
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                doubleAction = 0;
                ost = 0;
                break;

            case R.id.clear:
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                doubleAction = 0;
                str.setText(Integer.toString(operand1));
                ost = 0;
                break;

            case R.id.sign:
                str.setText("-");
                flagAction = 1;

            case R.id.factorial:
                number = Float.parseFloat(str.getText().toString());
                result = 1;
                for (int i = 1; i < number; i++){
                    result += result*i;
                }
                str.setText(Double.toString(result));
                operand1 = 0;
                operand2 = 0;
                result = 0;
                flagAction = 0;
                doubleAction = 0;
                ost = 0;
                break;

            case R.id.root:
                number = Float.parseFloat(str.getText().toString());
                str.setText("");
                if (str)
                string = str.getText().toString();
                root =
                Math.pow( number, 1.0 / i);
                break;

            case R.id.persent:
                break;

            case R.id.sin:
                break;

            case R.id.cos:
                break;

            case R.id.tan:
                break;

            case R.id.ln:
                break;

            case R.id.log:
                break;

            case R.id.oneDivX:
                break;

            case R.id.ePowX:
                break;

            case R.id.xPowTwo:
                break;

            case R.id.yPowX:
                break;

            case R.id.modul:
                break;

            case R.id.pi:
                break;

            case R.id.e:
                break;
        }
    }

    private void ClickDoubleNumber() {
        str.append(".");
        doubleAction = 1;
    }

    private void Start(double op1, double op2, String op){
        switch (op){
            case "+":
                result = op1 + op2;
                break;

            case "-":
                result = op1 - op2;
                break;

            case "*":
                result = op1 * op2;
                break;

            case "/":
                result = op1 / op2;
                break;
        }
    }


    private void ClickNumber(int num){
        if(flagAction == 0){
            if(doubleAction == 1){
                ost += num;
                str.append(Integer.toString(num));
            }else {
                operand1 = operand1*10 + num;
                str.append(Integer.toString(num));
            }
        }else if (flagAction == 1){
            if(doubleAction == 1){
                ost += num;
                str.append(Integer.toString(num));
            }else {
                operand2 = operand2*10 + num;
                str.append(Integer.toString(num));
            }
        }
    }

    private void ClickOperator(String operator){
        str.append(operator);
        op = operator;
        flagAction = 1;
    }
}