package com.example.quanlm.project01_mvp.fibonacci;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quanlm.project01_mvp.MainActivity;
import com.example.quanlm.project01_mvp.R;
import com.example.quanlm.project01_mvp.base.BaseView;
import com.example.quanlm.project01_mvp.base.ConfirmDialogFragment;
import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciPresenterForView;
import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciView;

public class ActFibonacci extends BaseView implements IFibonacciView, View.OnClickListener, DialogInterface.OnClickListener {
    IFibonacciPresenterForView fibonacciPresenterForView;
    TextView txtLimit;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_fibonacci);

        fibonacciPresenterForView = new PresenterFibonacci(this);
        initControls();
    }

    private void initControls() {
        txtLimit = (TextView) findViewById(R.id.txtLimit);
        txtResult = (TextView) findViewById(R.id.txtResult);
        findViewById(R.id.btnCalculate).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
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

    @Override
    public void onSuccess(String result) {
        txtResult.setText(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculate:
                fibonacciPresenterForView.searchFibonacciList(txtLimit.getText().toString());
                break;
            case R.id.btnExit:
                ConfirmDialogFragment exitDialog = new ConfirmDialogFragment();
                exitDialog.show(getFragmentManager(), "exit");
                break;
        }
    }
}
