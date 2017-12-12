package com.example.calculator;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BinaryActivity extends BaseActivity {

    public void onClick(View view) {
        EditText DecEditText = (EditText) findViewById(R.id.DEC);
        EditText HexEditText = (EditText) findViewById(R.id.HEX);
        EditText BinEditText = (EditText) findViewById(R.id.BIN);
        switch (view.getId()){
            case R.id.zero:
                AddNumber(0);
                break;
            case R.id.one:
                AddNumber(1);
                break;
            case R.id.two:
                AddNumber(2);
                break;
            case R.id.three:
                AddNumber(3);
                break;
            case R.id.four:
                AddNumber(4);
                break;
            case R.id.five:
                AddNumber(5);
                break;
            case R.id.six:
                AddNumber(6);
                break;
            case R.id.seven:
                AddNumber(7);
                break;
            case R.id.eight:
                AddNumber(8);
                break;
            case R.id.nine:
                AddNumber(9);
                break;
            case R.id.A:
                AddLetter('A');
                break;
            case R.id.B:
                AddLetter('B');
                break;
            case R.id.C:
                AddLetter('C');
                break;
            case R.id.D:
                AddLetter('D');
                break;
            case R.id.E:
                AddLetter('E');
                break;
            case R.id.F:
                AddLetter('F');
                break;
            case R.id.and:
                AddOperator('&');
                break;
            case R.id.or:
                AddOperator('|');
                break;
            case R.id.xor:
                AddOperator('^');
                break;
            case R.id.not:
                AddOperator('!');
                break;
            case R.id.plus:
                AddOperator('+');
                break;
            case R.id.minus:
                AddOperator('-');
                break;
            case R.id.multiply:
                AddOperator('*');
                break;
            case R.id.divide:
                AddOperator('/');
                break;
            case R.id.clear:
                str.setText("");
                DecEditText.setText("");
                HexEditText.setText("");
                BinEditText.setText("");
            case R.id.equal:
                int dec = Calculate(number, operation);
                switch (mActiveMode){
                    case HEX:
                        str.setText(DecToHex(Integer.toString(dec)));
                        HexEditText.setText(DecToHex(Integer.toString(dec)));
                        BinEditText.setText(DecToBin(Integer.toString(dec)));
                        DecEditText.setText(Integer.toString(dec));
                        break;
                    case DEC:
                        str.setText(Integer.toString(dec));
                        DecEditText.setText(Integer.toString(dec));
                        BinEditText.setText(DecToBin(Integer.toString(dec)));
                        HexEditText.setText(DecToHex(Integer.toString(dec)));
                        break;
                    case BIN:
                        str.setText(DecToBin(Integer.toString(dec)));
                        BinEditText.setText(DecToBin(Integer.toString(dec)));
                        DecEditText.setText(Integer.toString(dec));
                        HexEditText.setText(DecToHex(Integer.toString(dec)));
                        break;
                }
                break;
        }
    }

    private enum Mode{
        HEX,
        DEC,
        BIN
    }

    Mode mActiveMode;

    char operation;
    String number;

    int binaryDisabledControls[] = { R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.A, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F};

    int decDisabledControls[] = { R.id.A, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_binary);
        super.onCreate(savedInstanceState);

    }

    public void onClickMode(View view) {
        switch (view.getId()){
            case R.id.HEX:
                enableAllControls();
                if (mActiveMode != null){
                    transitionToHex(mActiveMode);
                }
                mActiveMode = Mode.HEX;
                break;
            case R.id.DEC:
                enableAllControls();
                if (mActiveMode != null) {
                    transitionToDec(mActiveMode);
                }
                mActiveMode = Mode.DEC;
                for (int element : decDisabledControls){
                    findViewById(element).setEnabled(false);
                }
                break;
            case R.id.BIN:
                if (mActiveMode != null) {
                    transitionToBin(mActiveMode);
                }
                mActiveMode = Mode.BIN;
                for (int element : binaryDisabledControls){
                    Button button = findViewById(element);
                    button.setEnabled(false);
                }
                break;
        }
    }

    private void AddNumber(int number){
        String viewNumbers = str.getText().toString();
        if (viewNumbers.matches("")) {
            str.setText(Integer.toString(number));
        } else {
            str.append(Integer.toString(number));
        }
        updateView();
    }

    private void AddLetter(char letter){
        String viewNumbers = str.getText().toString();
        if (viewNumbers.matches("")) {
            str.setText(Character.toString(letter));
        } else {
            str.append(Character.toString(letter));
        }
        updateView();
    }

    private void updateView(){
        EditText DecEditText = (EditText) findViewById(R.id.DEC);
        EditText HexEditText = (EditText) findViewById(R.id.HEX);
        EditText BinEditText = (EditText) findViewById(R.id.BIN);
        switch (mActiveMode){
            case HEX:
                HexEditText.setText(str.getText().toString());
                BinEditText.setText(HexToBin(str.getText().toString()));
                DecEditText.setText(HexToDec(str.getText().toString()));
                break;
            case DEC:
                DecEditText.setText(str.getText().toString());
                BinEditText.setText(DecToBin(str.getText().toString()));
                HexEditText.setText(DecToHex(str.getText().toString()));
                break;
            case BIN:
                BinEditText.setText(str.getText().toString());
                DecEditText.setText(BinToDec(str.getText().toString()));
                HexEditText.setText(BinToHex(str.getText().toString()));
                break;
        }
    }

    private void AddOperator(char op){
        operation = op;
        number = str.getText().toString();
        str.setText("");
    }

    private void transitionToBin(Mode oldMode){
            switch (oldMode) {
                case HEX:
                    str.setText(HexToBin(str.getText().toString()));
                    break;
                case DEC:
                    str.setText(DecToBin(str.getText().toString()));
                    break;
            }

    }

    private void transitionToHex(Mode oldMode){
        switch (oldMode){
            case BIN:
                str.setText(BinToHex(str.getText().toString()));
            case DEC:
                str.setText(DecToHex(str.getText().toString()));
        }

    }

    private void transitionToDec(Mode oldMode){
        switch (oldMode){
            case HEX:
                str.setText(HexToDec(str.getText().toString()));
            case BIN:
                str.setText(BinToDec(str.getText().toString()));
        }

    }

    private String DecToBin(String string){
        return Integer.toBinaryString(Integer.parseInt(string));
    }

    private String DecToHex(String string){
        return Integer.toHexString(Integer.parseInt(string));
    }

    private String BinToDec(String string){
        return Integer.toString(Integer.parseInt(string, 2));
    }

    private String BinToHex(String string){
        int decimal = Integer.parseInt(string,2);
        return Integer.toString(decimal,16);

    }

    private String HexToBin(String string){
        int i = Integer.parseInt(string, 16);
        return Integer.toBinaryString(i);
    }

    private String HexToDec(String string){
        return Integer.toString(Integer.parseInt(string, 16));
    }

    private int Calculate (String number, char operation){
        switch (operation){
            case '&':
                return ConvertToDec(str.getText().toString()) & ConvertToDec(number);
            case '|':
                return ConvertToDec(str.getText().toString()) | ConvertToDec(number);
            case '^':
                return ConvertToDec(str.getText().toString()) ^ ConvertToDec(number);
            case '!':
                return ~ConvertToDec(str.getText().toString());
            case '+':
                return ConvertToDec(str.getText().toString()) + ConvertToDec(number);
            case '-':
                return ConvertToDec(str.getText().toString()) - ConvertToDec(number);
            case '*':
                return ConvertToDec(str.getText().toString()) * ConvertToDec(number);
            case '/':
                return ConvertToDec(str.getText().toString()) / ConvertToDec(number);
        }
        return -1;
    }

    private int ConvertToDec(String number){
        EditText DecEditText = (EditText) findViewById(R.id.DEC);
        EditText HexEditText = (EditText) findViewById(R.id.HEX);
        EditText BinEditText = (EditText) findViewById(R.id.BIN);
        switch (mActiveMode) {
            case HEX:
                return Integer.parseInt(HexToDec(number));
            case DEC:
                return Integer.parseInt(number);
            case BIN:
                return Integer.parseInt(BinToDec(number));
        }
        return -1;
    }

    private void enableAllControls(){
        for(int element : binaryDisabledControls){
            findViewById(element).setEnabled(true);
        }
    }
}
