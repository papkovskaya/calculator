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

    int operand, flagAction;
    double result;
    String string;

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
        operand = 0;
        result = 0;
        flagAction = 0;
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
                result = 0;
                flagAction = 0;
                break;

            case R.id.clear:
                operand = 0;
                result = 0;
                flagAction = 0;
                str.setText(Integer.toString(operand));
                break;

            case R.id.sign:
                str.setText("-");
                flagAction = 1;
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
    }
}