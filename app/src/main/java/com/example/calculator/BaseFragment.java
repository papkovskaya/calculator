package com.example.calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.calculator.polish_processing.PolishProcessor;


/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

    String string;
    EditText str;
    int operand, flagAction;
    double result;

    public BaseFragment() {
        // Required empty public constructor
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

            case R.id.brackets:


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

            case R.id.factorial:
                break;

            case R.id.root:
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

    void ClickDoubleNumber() {
        str.append(".");
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

    void ClickOperator(int stringResourceId){
        str.append(this.getResources().getString(stringResourceId));
        operand = 0;
        flagAction = 1;
    }
}
