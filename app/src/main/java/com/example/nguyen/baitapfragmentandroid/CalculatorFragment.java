package com.example.nguyen.baitapfragmentandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment {

    EditText edtFirstNumber, edtSecondNumber;
    TextView tvResultNumber;
    public CalculatorFragment() {
        // Required empty public constructor
    }

    public static CalculatorFragment getInstance(){
        return new CalculatorFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calculator, container, false);
        edtFirstNumber = v.findViewById(R.id.edtFirstNumber);
        edtSecondNumber = v.findViewById(R.id.edtSecondNumber);
        tvResultNumber = v.findViewById(R.id.tvResultNumber);
        return v;
    }

    public float add(){
        float firstNumber = convertFloatNumber(edtFirstNumber.getText().toString());
        float secondNumber = convertFloatNumber(edtSecondNumber.getText().toString());
        return firstNumber + secondNumber;
    }

    public float sub(){
        float firstNumber = convertFloatNumber(edtFirstNumber.getText().toString());
        float secondNumber = convertFloatNumber(edtSecondNumber.getText().toString());
        return firstNumber - secondNumber;
    }

    public float mul(){
        float firstNumber = convertFloatNumber(edtFirstNumber.getText().toString());
        float secondNumber = convertFloatNumber(edtSecondNumber.getText().toString());
        return firstNumber * secondNumber;
    }

    public float div(){
        float firstNumber = convertFloatNumber(edtFirstNumber.getText().toString());
        float secondNumber = convertFloatNumber(edtSecondNumber.getText().toString());
        return firstNumber / secondNumber;
    }

    private float convertFloatNumber(String s){
        float number = 0;
        try {
            number = Float.parseFloat(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            return number;
        }
    }

    public void displayResult(float result){
        tvResultNumber.setText(String.format("%.3f", result));
    }
}
