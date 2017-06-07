package com.example.quanlm.project01_mvp.taxi_fare;

import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFareModel;
import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFarePresenterForModel;
import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFarePresenterForView;
import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFareView;
import com.example.quanlm.project01_mvp.util.Validator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by QuanLM on 6/6/2017.
 */

public class PresenterTaxiFare implements ITaxiFarePresenterForView, ITaxiFarePresenterForModel {
    public static String CURRENCY_UNIT = "VND";

    ITaxiFareView taxiFareView;
    ITaxiFareModel modelTaxiFare;

    public PresenterTaxiFare(ITaxiFareView taxiFareView) {
        this.taxiFareView = taxiFareView;
        this.modelTaxiFare = new ModelTaxiFare(this);
    }

    @Override
    public void calculate(String kmValue) {
        if(Validator.isValidNumber(kmValue)){
            Float km = Float.parseFloat(kmValue);
            this.modelTaxiFare.calculate(km);
        }else {
            this.taxiFareView.onFail(Validator.ERR_VALIDATE_NUMBER);
        }
    }

    @Override
    public void calculateDataSuccess(float result) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        this.taxiFareView.onSuccess(formatter.format(result) + " " + CURRENCY_UNIT);
    }

    @Override
    public void calculateDataFail() {
        taxiFareView.onFail(Validator.ERR_COMMON);
    }
}
