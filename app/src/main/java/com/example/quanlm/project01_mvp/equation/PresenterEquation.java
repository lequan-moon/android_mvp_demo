package com.example.quanlm.project01_mvp.equation;

import com.example.quanlm.project01_mvp.equation.interfaces.IEquationModel;
import com.example.quanlm.project01_mvp.equation.interfaces.IEquationPresenterForModel;
import com.example.quanlm.project01_mvp.equation.interfaces.IEquationPresenterForView;
import com.example.quanlm.project01_mvp.equation.interfaces.IEquationView;
import com.example.quanlm.project01_mvp.util.Validator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by QuanLM on 6/6/2017.
 */

public class PresenterEquation implements IEquationPresenterForModel, IEquationPresenterForView {
    IEquationView equationView;
    IEquationModel equationModel;

    public PresenterEquation(IEquationView equationView) {
        this.equationView = equationView;
    }

    @Override
    public void calculate(String a, String b) {
        if (Validator.isValidNumber(a)
                && Validator.isValidNumber(b)){
            Float fltA = Float.parseFloat(a);
            Float fltB = Float.parseFloat(b);

            if (fltA == 0){
                equationView.onFail(Validator.ERR_VALIDATE_NUMBER_ZERO);
            }

            equationModel.calculate(fltA, fltB);

        } else{
            equationView.onFail(Validator.ERR_VALIDATE_NUMBER);
        }
    }

    @Override
    public void calculateDataSuccess(float result) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        equationView.onSuccess(formatter.format(result));
    }

    @Override
    public void calculateDataFail() {
        equationView.onFail(Validator.ERR_COMMON);
    }
}
