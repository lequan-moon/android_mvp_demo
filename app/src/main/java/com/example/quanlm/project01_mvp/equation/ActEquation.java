package com.example.quanlm.project01_mvp.equation;

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
import com.example.quanlm.project01_mvp.equation.interfaces.IEquationPresenterForView;
import com.example.quanlm.project01_mvp.equation.interfaces.IEquationView;

public class ActEquation extends BaseView implements IEquationView, View.OnClickListener, DialogInterface.OnClickListener{
    IEquationPresenterForView equationPresenterForView;
    TextView txtNumberA;
    TextView txtNumberB;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_equation);

        initControls();
    }

    private void initControls() {
        equationPresenterForView = new PresenterEquation(this);
        txtNumberA = (TextView) findViewById(R.id.txtNumberA);
        txtNumberB = (TextView) findViewById(R.id.txtNumberB);
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
                equationPresenterForView.calculate(this.txtNumberA.getText().toString(), this.txtNumberB.getText().toString());
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
