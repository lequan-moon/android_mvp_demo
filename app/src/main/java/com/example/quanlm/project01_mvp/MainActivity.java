package com.example.quanlm.project01_mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.quanlm.project01_mvp.R;
import com.example.quanlm.project01_mvp.equation.ActEquation;
import com.example.quanlm.project01_mvp.equation2.ActEquation2;
import com.example.quanlm.project01_mvp.fibonacci.ActFibonacci;
import com.example.quanlm.project01_mvp.perfect_number.ActPerfectNumber;
import com.example.quanlm.project01_mvp.prime_number.ActPrimeNumber;
import com.example.quanlm.project01_mvp.taxi_fare.ActTaxiFare;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEvents();
    }

    private void initEvents() {
        findViewById(R.id.btnTaxiFare).setOnClickListener(this);
        findViewById(R.id.btnEquation).setOnClickListener(this);
        findViewById(R.id.btnEquation2).setOnClickListener(this);
        findViewById(R.id.btnPrimeNumber).setOnClickListener(this);
        findViewById(R.id.btnPerfectNumber).setOnClickListener(this);
        findViewById(R.id.btnFibonacci).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()){
            case R.id.btnTaxiFare:
                it.setClass(this, ActTaxiFare.class);
                break;
            case R.id.btnEquation:
                it.setClass(this, ActEquation.class);
                break;
            case R.id.btnEquation2:
                it.setClass(this, ActEquation2.class);
                break;
            case R.id.btnPrimeNumber:
                it.setClass(this, ActPrimeNumber.class);
                break;
            case R.id.btnPerfectNumber:
                it.setClass(this, ActPerfectNumber.class);
                break;
            case R.id.btnFibonacci:
                it.setClass(this, ActFibonacci.class);
                break;
        }
        startActivity(it);
    }
}
