package com.example.quanlm.project01_mvp.equation2;

import com.example.quanlm.project01_mvp.equation2.interfaces.IEquation2Model;
import com.example.quanlm.project01_mvp.equation2.interfaces.IEquation2PresenterForModel;
import com.example.quanlm.project01_mvp.equation2.interfaces.IEquation2PresenterForView;
import com.example.quanlm.project01_mvp.equation2.interfaces.IEquation2View;
import com.example.quanlm.project01_mvp.util.Validator;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class PresenterEquation2 implements IEquation2PresenterForModel, IEquation2PresenterForView{
    IEquation2View equation2View;
    IEquation2Model equation2Model;

    public PresenterEquation2(IEquation2View equation2View) {
        this.equation2View = equation2View;
        equation2Model = new ModelEquation2(this);
    }

    @Override
    public void calculate(String a, String b, String c) {
        if (Validator.isValidNumber(a)
                && Validator.isValidNumber(b)
                && Validator.isValidNumber(c)){
            Float fltA = Float.parseFloat(a);
            Float fltB = Float.parseFloat(b);
            Float fltC = Float.parseFloat(c);

            equation2Model.calculate(fltA, fltB, fltC);

        } else{
            equation2View.onFail(Validator.ERR_VALIDATE_NUMBER);
        }
    }

    @Override
    public void calculateSuccess(String result) {
        equation2View.onSuccess(result);
    }

    @Override
    public void calculateFail() {
        equation2View.onFail(Validator.ERR_COMMON);
    }
}
