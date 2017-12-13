package com.example.calculator;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.calculator.polish_processing.PolishProcessor;

/**
 * Created by olga on 04.12.2017.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener, TabLayout.OnTabSelectedListener {
    String string;
    EditText str;
    int operand, flagAction;
    double result;
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tabLayout = findViewById(R.id.tabs);
        str = (EditText) findViewById(R.id.viewNumbers);

        if(savedInstanceState != null){
            operand = savedInstanceState.getInt("operand", 0);
            result = savedInstanceState.getDouble("result", 0);
            flagAction = savedInstanceState.getInt("flagAction", 0);
            str.setText(savedInstanceState.getString("expression", ""));
        }

        if(getIntent() != null && getIntent().getExtras() != null){
            operand = getIntent().getIntExtra("operand", 0);
            result = getIntent().getDoubleExtra("result", 0);
            flagAction = getIntent().getIntExtra("flagAction", 0);
            str.setText(getIntent().getStringExtra("expression"));
            TabLayout.Tab currentTab = tabLayout.getTabAt(getIntent().getIntExtra("currentTab", 0));
            currentTab.select();
        }
        tabLayout.addOnTabSelectedListener(this);
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
                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                Intent engineeringActivityIntent = new Intent(this, EngineeringActivity.class);
                engineeringActivityIntent.putExtra("expression", str.getText().toString());
                engineeringActivityIntent.putExtra("operand", operand);
                engineeringActivityIntent.putExtra("result", result);
                engineeringActivityIntent.putExtra("flagAction", flagAction);
                engineeringActivityIntent.putExtra("currentTab", tabLayout.getSelectedTabPosition());
                startActivity(engineeringActivityIntent);
                return true;
            case R.id.second_item:
                Intent simpleActivityIntent = new Intent(this, MainActivity.class);
                simpleActivityIntent.putExtra("expression", str.getText().toString());
                simpleActivityIntent.putExtra("operand", operand);
                simpleActivityIntent.putExtra("result", result);
                simpleActivityIntent.putExtra("flagAction", flagAction);
                simpleActivityIntent.putExtra("currentTab", tabLayout.getSelectedTabPosition());
                startActivity(simpleActivityIntent);
                return true;
            case R.id.bin_item:
                Intent binaryActivityIntent = new Intent(this, BinaryActivity.class);
                binaryActivityIntent.putExtra("expression", str.getText().toString());
                binaryActivityIntent.putExtra("operand", operand);
                binaryActivityIntent.putExtra("result", result);
                binaryActivityIntent.putExtra("flagAction", flagAction);
                binaryActivityIntent.putExtra("currentTab", tabLayout.getSelectedTabPosition());
                startActivity(binaryActivityIntent);
                return true;
        }
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("expression", str.getText().toString());
        outState.putInt("operand", operand);
        outState.putDouble("result", result);
        outState.putInt("flagAction", flagAction);
        super.onSaveInstanceState(outState);
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
                if(str.getText().toString().equalsIgnoreCase("0"))
                    return;
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

            case R.id.brackets:
                break;


            case R.id.equal:
                string = str.getText().toString();
                result = PolishProcessor.eval(string);
                str.setText(Double.toString(result));
//                operand = 0;
//                result = 0;
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
                break;

            case R.id.factorial:
                result = 1;
                for (int i = 1; i <= operand; i++){
                    result = result * i;
                }
                str.setText(Double.toString(result));
                result = 0;
                operand = 0;
                flagAction = 0;
                break;

            case R.id.pow:
                result = Math.sqrt(operand);
                str.setText(Double.toString(result));
                result = 0;
                operand = 0;
                flagAction = 0;
                break;

            case R.id.sin:
                result = Math.sin(operand);
                str.setText(Double.toString(result));
                result = 0;
                operand = 0;
                flagAction = 0;
                break;

            case R.id.cos:
                result = Math.cos(operand);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.tan:
                result = Math.tan(operand);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.ln:
                result = Math.log10(operand);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.log:
                result = Math.log(operand);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.oneDivX:
                result = 1 / operand;
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.ePowX:
                result = Math.exp(operand);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.xPowTwo:
                result = Math.pow(operand, 2);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.yPowX:
                ClickOperator(R.string.pow);
                operand = 0;
                break;

            case R.id.modul:
                result = Math.abs(operand);
                str.setText(Double.toString(result));
                result = 0;
                flagAction = 0;
                operand = 0;
                break;

            case R.id.pi:
                AddDouble(Math.PI);
                break;

            case R.id.e:
                AddDouble(Math.E);
                break;
        }
    }

    void ClickDoubleNumber() {
        str.append(".");
        flagAction = 1;
    }


    void ClickNumber(int num){
        if(flagAction == 0){
            operand = operand*10 + num;
            str.setText(Integer.toString(num));
            flagAction = 1;
        }else if (flagAction == 1){
            operand = operand*10 + num;
            str.append(Integer.toString(num));
        }
    }

    void AddDouble(double num){
        if(flagAction == 0){
            str.setText(Double.toString(num));
            flagAction = 1;
        }else if (flagAction == 1){
            str.append(Double.toString(num));
        }
    }

    void ClickOperator(int stringResourceId){
        str.append(this.getResources().getString(stringResourceId));
        operand = 0;
        flagAction = 1;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                Intent simpleActivityIntent = new Intent(this, MainActivity.class);
                simpleActivityIntent.putExtra("expression", str.getText().toString());
                simpleActivityIntent.putExtra("operand", operand);
                simpleActivityIntent.putExtra("result", result);
                simpleActivityIntent.putExtra("flagAction", flagAction);
                simpleActivityIntent.putExtra("currentTab", tab.getPosition());
                startActivity(simpleActivityIntent);
                break;
            case 1:
                Intent engineeringActivityIntent = new Intent(this, EngineeringActivity.class);
                engineeringActivityIntent.putExtra("expression", str.getText().toString());
                engineeringActivityIntent.putExtra("operand", operand);
                engineeringActivityIntent.putExtra("result", result);
                engineeringActivityIntent.putExtra("flagAction", flagAction);
                engineeringActivityIntent.putExtra("currentTab", tab.getPosition());
                startActivity(engineeringActivityIntent);
                break;
            case 2:
                Intent binaryActivityIntent = new Intent(this, BinaryActivity.class);
                binaryActivityIntent.putExtra("expression", str.getText().toString());
                binaryActivityIntent.putExtra("operand", operand);
                binaryActivityIntent.putExtra("result", result);
                binaryActivityIntent.putExtra("flagAction", flagAction);
                binaryActivityIntent.putExtra("currentTab", tab.getPosition());
                startActivity(binaryActivityIntent);
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
