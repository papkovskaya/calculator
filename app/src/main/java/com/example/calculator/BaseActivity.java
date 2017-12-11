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

public class BaseActivity extends AppCompatActivity {
    String string;
    EditText str;
    int operand, flagAction;
    double result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            operand = savedInstanceState.getInt("operand", 0);
            result = savedInstanceState.getDouble("result", 0);
            flagAction = savedInstanceState.getInt("flagAction", 0);
        }

        if(getIntent() != null && getIntent().getExtras() != null){
            operand = getIntent().getIntExtra("operand", 0);
            result = getIntent().getDoubleExtra("result", 0);
            flagAction = getIntent().getIntExtra("flagAction", 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.first_item:
//                //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//                Intent engineeringActivityIntent = new Intent(this, EngineeringActivity.class);
//                engineeringActivityIntent.putExtra("expression", str.getText().toString());
//                engineeringActivityIntent.putExtra("operand", operand);
//                engineeringActivityIntent.putExtra("result", result);
//                engineeringActivityIntent.putExtra("flagAction", flagAction);
//                startActivity(engineeringActivityIntent);
//                return true;
//            case R.id.second_item:
//                Intent simpleActivityIntent = new Intent(this, MainActivity.class);
//                simpleActivityIntent.putExtra("expression", str.getText().toString());
//                simpleActivityIntent.putExtra("operand", operand);
//                simpleActivityIntent.putExtra("result", result);
//                simpleActivityIntent.putExtra("flagAction", flagAction);
//                startActivity(simpleActivityIntent);
//                return true;
//            case R.id.bin_item:
//                Intent binaryActivityIntent = new Intent(this, BinaryActivity.class);
//                binaryActivityIntent.putExtra("expression", str.getText().toString());
//                binaryActivityIntent.putExtra("operand", operand);
//                binaryActivityIntent.putExtra("result", result);
//                binaryActivityIntent.putExtra("flagAction", flagAction);
//                startActivity(binaryActivityIntent);
//                return true;
//        }
//        return false;
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putString("expression", str.getText().toString());
//        outState.putInt("operand", operand);
//        outState.putDouble("result", result);
//        outState.putInt("flagAction", flagAction);
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        switch (tab.getPosition()){
//            case 0:
//                Intent simpleActivityIntent = new Intent(this, MainActivity.class);
//                simpleActivityIntent.putExtra("expression", str.getText().toString());
//                simpleActivityIntent.putExtra("operand", operand);
//                simpleActivityIntent.putExtra("result", result);
//                simpleActivityIntent.putExtra("flagAction", flagAction);
//                startActivity(simpleActivityIntent);
//                break;
//            case 1:
//                Intent engineeringActivityIntent = new Intent(this, EngineeringActivity.class);
//                engineeringActivityIntent.putExtra("expression", str.getText().toString());
//                engineeringActivityIntent.putExtra("operand", operand);
//                engineeringActivityIntent.putExtra("result", result);
//                engineeringActivityIntent.putExtra("flagAction", flagAction);
//                startActivity(engineeringActivityIntent);
//                break;
//            case 2:
//                Intent binaryActivityIntent = new Intent(this, BinaryActivity.class);
//                binaryActivityIntent.putExtra("expression", str.getText().toString());
//                binaryActivityIntent.putExtra("operand", operand);
//                binaryActivityIntent.putExtra("result", result);
//                binaryActivityIntent.putExtra("flagAction", flagAction);
//                startActivity(binaryActivityIntent);
//                break;
//        }
//    }

//    @Override
//    public void onTabUnselected(TabLayout.Tab tab) {
//
//    }
//
//    @Override
//    public void onTabReselected(TabLayout.Tab tab) {
//
//    }
}
