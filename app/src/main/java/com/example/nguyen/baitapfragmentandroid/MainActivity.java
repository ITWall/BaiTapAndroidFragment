package com.example.nguyen.baitapfragmentandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private MenuFragment menuFragment;
    private CalculatorFragment calculatorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragment = MenuFragment.getInstance();
        calculatorFragment = CalculatorFragment.getInstance();
        callFragment(R.id.flMenu, menuFragment);
        callFragment(R.id.flDetail, calculatorFragment);
    }

    public static MainActivity getInstance(){
        return new MainActivity();
    }

    public void callFragment(int layoutContainerId, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(layoutContainerId, fragment);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnAdd:
                calculatorFragment.displayResult(0);
                break;
            case R.id.mnSub:
                calculatorFragment.displayResult(1);
                break;
            case R.id.mnMul:
                calculatorFragment.displayResult(2);
                break;
            case R.id.mnDivide:
                calculatorFragment.displayResult(3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(getSupportFragmentManager().findFragmentById(R.id.flDetail)).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
    }
}
