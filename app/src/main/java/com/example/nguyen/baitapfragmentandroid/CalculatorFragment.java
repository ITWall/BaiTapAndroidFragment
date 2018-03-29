package com.example.nguyen.baitapfragmentandroid;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
public class CalculatorFragment extends Fragment{

    EditText edtFirstNumber, edtSecondNumber;
    public static TextView tvResultNumber;
    View v;
    private static float add=0, sub=0, mul=0, div=0;
    public CalculatorFragment() {
        // Required empty public constructor
    }

    public static CalculatorFragment getInstance(){
        return new CalculatorFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_calculator, container, false);
        mapping(v);
        return v;
    }


    private void mapping(View v){
        edtFirstNumber = v.findViewById(R.id.edtFirstNumber);
        edtSecondNumber = v.findViewById(R.id.edtSecondNumber);
        tvResultNumber = v.findViewById(R.id.tvResultNumber);
        edtFirstNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Toast.makeText(getContext(), ""+charSequence, Toast.LENGTH_SHORT).show();
                add = convertFloatNumber(charSequence.toString()) + convertFloatNumber(edtSecondNumber.getText().toString());
                sub = convertFloatNumber(charSequence.toString()) - convertFloatNumber(edtSecondNumber.getText().toString());
                mul = convertFloatNumber(charSequence.toString()) * convertFloatNumber(edtSecondNumber.getText().toString());
                div = convertFloatNumber(charSequence.toString()) / convertFloatNumber(edtSecondNumber.getText().toString());
                tvResultNumber.setText(String.format("%.3f", add));
                Toast.makeText(getContext(), ""+add, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtSecondNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                Toast.makeText(getContext(), ""+charSequence, Toast.LENGTH_SHORT).show();
                add = convertFloatNumber(charSequence.toString()) + convertFloatNumber(edtFirstNumber.getText().toString());
                sub = convertFloatNumber(charSequence.toString()) - convertFloatNumber(edtFirstNumber.getText().toString());
                mul = convertFloatNumber(charSequence.toString()) * convertFloatNumber(edtFirstNumber.getText().toString());
                div = convertFloatNumber(charSequence.toString()) / convertFloatNumber(edtFirstNumber.getText().toString());
                tvResultNumber.setText(String.format("%.3f", add));
                Toast.makeText(getContext(), ""+add, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public float add(){
        Toast.makeText(getContext(), ""+edtFirstNumber.getText().toString(), Toast.LENGTH_SHORT).show();
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

    public static void displayResult(int cal){
        switch (cal){
            case 0:
                tvResultNumber.setText(String.format("%.3f", add));
                break;
            case 1:
                tvResultNumber.setText(String.format("%.3f", sub));
                break;
            case 2:
                tvResultNumber.setText(String.format("%.3f", mul));
                break;
            case 3:
                tvResultNumber.setText(String.format("%.3f", div));
                break;
        }
    }

}
