package com.example.calculator;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BinaryActivity extends BaseActivity {

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.two:
                break;
        }
    }

    private enum Mode{
        HEX,
        DEC,
        BIN
    }

    Mode mActiveMode;


    int binaryDisabledControls[] = { R.id.two, R.id.three, R.id.four, R.id.five, R.id.six,  R.id.A, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F};

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

                mActiveMode = Mode.HEX;
                break;
            case R.id.DEC:
                enableAllControls();

                mActiveMode = Mode.DEC;
                for (int element : decDisabledControls){
                    findViewById(element).setEnabled(false);
                }
                break;
            case R.id.BIN:
                transitionToBin(mActiveMode);
                mActiveMode = Mode.BIN;
                for (int element : binaryDisabledControls){
                    Button button = findViewById(element);
                    button.setEnabled(false);
                }
                break;
        }
    }

    private void transitionToBin(Mode oldMode){
        switch (oldMode){
            case HEX:
                from hex t bin function()
                break;
            case DEC:
                from dec to bin function()
                break;
        }

    }

    private void enableAllControls(){
        for(int element : binaryDisabledControls){
            findViewById(element).setEnabled(true);
        }
    }
}
