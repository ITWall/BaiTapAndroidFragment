package com.example.nguyen.baitapfragmentandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment{

    EditText edtFirstNumber, edtSecondNumber;
    private static TextView tvResultNumber;
    View v;
    private static float addResult, subResult, mulResult, divResult;
    public CalculatorFragment() {
        // Required empty public constructor
        addResult = 0;
        subResult = 0;
        mulResult = 0;
        divResult = 0;
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
                addResult = add(convertFloatNumber(charSequence.toString()), convertFloatNumber(edtSecondNumber.getText().toString()));
                subResult = sub(convertFloatNumber(charSequence.toString()), convertFloatNumber(edtSecondNumber.getText().toString()));
                mulResult = mul(convertFloatNumber(charSequence.toString()), convertFloatNumber(edtSecondNumber.getText().toString()));
                divResult = div(convertFloatNumber(charSequence.toString()), convertFloatNumber(edtSecondNumber.getText().toString()));
//                Toast.makeText(getContext(), ""+add, Toast.LENGTH_SHORT).show();
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
                addResult = add(convertFloatNumber(charSequence.toString()), convertFloatNumber(edtFirstNumber.getText().toString()));
                subResult = sub(convertFloatNumber(edtFirstNumber.getText().toString()), convertFloatNumber(charSequence.toString()));
                mulResult = mul(convertFloatNumber(charSequence.toString()), convertFloatNumber(edtFirstNumber.getText().toString()));
                divResult = div(convertFloatNumber(edtFirstNumber.getText().toString()), convertFloatNumber(charSequence.toString()));
//                tvResultNumber.setText(String.format("%.3f", add));
//                Toast.makeText(getContext(), ""+add, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public float add(float firstNumber ,float secondNumber){
        return firstNumber + secondNumber;
    }

    public float sub(float firstNumber ,float secondNumber){
        return firstNumber - secondNumber;
    }

    public float mul(float firstNumber ,float secondNumber){
        return firstNumber * secondNumber;
    }

    public float div(float firstNumber ,float secondNumber){
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

    public void displayResult(int cal){
        switch (cal){
            case 0:
                tvResultNumber.setText(String.format("%.3f", addResult));
                break;
            case 1:
                tvResultNumber.setText(String.format("%.3f", subResult));
                break;
            case 2:
                tvResultNumber.setText(String.format("%.3f", mulResult));
                break;
            case 3:
                tvResultNumber.setText(String.format("%.3f", divResult));
                break;
        }
    }

}
