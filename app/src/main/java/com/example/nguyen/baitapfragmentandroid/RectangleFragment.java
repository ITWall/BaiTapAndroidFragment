package com.example.nguyen.baitapfragmentandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RectangleFragment extends Fragment implements View.OnClickListener{

    EditText mEdtFirstSide, mEdtSecondSide;
    RadioButton mRbArea, mRbPerimeter;
    TextView mTvResultRectanlge;
    private float result;
    public RectangleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rectangle, container, false);
        mapping(v);
        mEdtFirstSide.addTextChangedListener(twFirstNumber);
        mEdtSecondSide.addTextChangedListener(twSecondNumber);
        mRbPerimeter.setOnClickListener(this);
        mRbArea.setOnClickListener(this);
        return v;
    }

    private void mapping(View v){
        mEdtFirstSide = v.findViewById(R.id.edtFirstSide);
        mEdtSecondSide = v.findViewById(R.id.edtSecondSide);
        mRbArea = v.findViewById(R.id.rbArea);
        mRbPerimeter = v.findViewById(R.id.rbPerimeter);
        mTvResultRectanlge = v.findViewById(R.id.tvResultRectangle);
    }

    TextWatcher twFirstNumber = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(mRbArea.isChecked()){
                result = convertFloatNumber(charSequence.toString()) * convertFloatNumber(mEdtSecondSide.getText().toString());
                displayResult(result);
            }else{
                result = (convertFloatNumber(charSequence.toString()) + convertFloatNumber(mEdtSecondSide.getText().toString())) * 2;
                displayResult(result);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    TextWatcher twSecondNumber = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(mRbArea.isChecked()){
                result = convertFloatNumber(charSequence.toString()) * convertFloatNumber(mEdtFirstSide.getText().toString());
                displayResult(result);
            }else{
                result = (convertFloatNumber(charSequence.toString()) + convertFloatNumber(mEdtFirstSide.getText().toString())) * 2;
                displayResult(result);
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

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

    private void displayResult(float result){
        mTvResultRectanlge.setText(String.format("%.3f", result));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbArea:
                result = convertFloatNumber(mEdtFirstSide.getText().toString()) * convertFloatNumber(mEdtSecondSide.getText().toString());
                displayResult(result);
                break;
            case R.id.rbPerimeter:
                result = (convertFloatNumber(mEdtFirstSide.getText().toString()) + convertFloatNumber(mEdtSecondSide.getText().toString())) * 2;
                displayResult(result);
        }
    }
}
