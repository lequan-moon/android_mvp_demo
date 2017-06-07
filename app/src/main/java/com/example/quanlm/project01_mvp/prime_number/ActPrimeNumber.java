package com.example.quanlm.project01_mvp.prime_number;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quanlm.project01_mvp.MainActivity;
import com.example.quanlm.project01_mvp.R;
import com.example.quanlm.project01_mvp.base.BaseView;
import com.example.quanlm.project01_mvp.base.ConfirmDialogFragment;
import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberPresenterForView;
import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberView;

public class ActPrimeNumber extends BaseView implements IPrimeNumberView, View.OnClickListener, DialogInterface.OnClickListener {
    IPrimeNumberPresenterForView primeNumberPresenterForView;
    TextView txtPrimeNumber;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_prime_number);

        primeNumberPresenterForView = new PresenterPrimeNumber(this);
        initControls();
    }

    private void initControls() {
        txtPrimeNumber = (TextView) findViewById(R.id.txtPrimeNumber);
        txtResult = (TextView) findViewById(R.id.txtResult);
        findViewById(R.id.btnCalculate).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
    }

    @Override
    public void onSuccess(String result) {
        txtResult.setText(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalculate:
                primeNumberPresenterForView.checkPrimeNumber(txtPrimeNumber.getText().toString());
                break;
            case R.id.btnExit:
                ConfirmDialogFragment exitDialog = new ConfirmDialogFragment();
                exitDialog.show(getFragmentManager(), "exit");
                break;
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            Intent itExit = new Intent(this, MainActivity.class);
            startActivity(itExit);
        } else {
            dialog.dismiss();
        }
    }
}
