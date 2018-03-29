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
public class SquareFragment extends Fragment implements View.OnClickListener {

    EditText mEdtSide;
    RadioButton mRbAreaSquare, mRbPerimeterSquare;
    TextView mTvResultSquare;
    private float result;

    public SquareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_square, container, false);
        mapping(v);
        mEdtSide.addTextChangedListener(tw);
        mRbPerimeterSquare.setOnClickListener(this);
        mRbAreaSquare.setOnClickListener(this);
        return v;
    }

    private void mapping(View v){
        mEdtSide = v.findViewById(R.id.edtSide);
        mRbAreaSquare = v.findViewById(R.id.rbAreaSquare);
        mRbPerimeterSquare = v.findViewById(R.id.rbPerimeterSquare);
        mTvResultSquare = v.findViewById(R.id.tvResultSquare);
    }

    TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(mRbAreaSquare.isChecked()){
                result = convertFloatNumber(charSequence.toString()) *  convertFloatNumber(charSequence.toString());
                displayResult(result);
            }else{
                result = convertFloatNumber(charSequence.toString()) * 4;
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
        mTvResultSquare.setText(String.format("%.3f", result));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbAreaSquare:
                result = convertFloatNumber(mEdtSide.getText().toString()) * convertFloatNumber(mEdtSide.getText().toString());
                displayResult(result);
                break;
            case R.id.rbPerimeterSquare:
                result = convertFloatNumber(mEdtSide.getText().toString()) * 4;
                displayResult(result);
        }
    }

}
