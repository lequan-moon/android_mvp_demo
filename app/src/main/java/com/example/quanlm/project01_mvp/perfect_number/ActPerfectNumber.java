package com.example.quanlm.project01_mvp.perfect_number;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quanlm.project01_mvp.MainActivity;
import com.example.quanlm.project01_mvp.R;
import com.example.quanlm.project01_mvp.base.BaseView;
import com.example.quanlm.project01_mvp.base.ConfirmDialogFragment;
import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberPresenterForView;
import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberView;

public class ActPerfectNumber extends BaseView implements IPerfectNumberView, View.OnClickListener, DialogInterface.OnClickListener {
    IPerfectNumberPresenterForView perfectNumberPresenterForView;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_perfect_number);

        perfectNumberPresenterForView = new PresenterPerfectNumber(this);
        initControls();

    }

    @Override
    public void onSuccess(String result) {
        txtResult.setText(result);
    }

    private void initControls() {
        txtResult = (TextView) findViewById(R.id.txtResult);
        findViewById(R.id.btnCalculate).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculate:
                perfectNumberPresenterForView.searchPerfectNumber();
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
