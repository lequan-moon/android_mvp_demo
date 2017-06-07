package com.example.quanlm.project01_mvp.taxi_fare;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlm.project01_mvp.MainActivity;
import com.example.quanlm.project01_mvp.R;
import com.example.quanlm.project01_mvp.base.BaseView;
import com.example.quanlm.project01_mvp.base.ConfirmDialogFragment;
import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFarePresenterForView;
import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFareView;
import com.example.quanlm.project01_mvp.util.Validator;

public class ActTaxiFare extends BaseView implements ITaxiFareView, View.OnClickListener, DialogInterface.OnClickListener{
    TextView txtKm;
    TextView txtResult;
    ITaxiFarePresenterForView taxiFarePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_taxi_fare);

        this.taxiFarePresenter = new PresenterTaxiFare(this);

        initControls();
        initEvents();

    }

    private void initControls() {
        txtKm = (TextView) findViewById(R.id.txtKm);
        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    private void initEvents() {
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
                this.taxiFarePresenter.calculate(this.txtKm.getText().toString());
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
