package com.example.quanlm.project01_mvp.equation;

import com.example.quanlm.project01_mvp.equation.interfaces.IEquationModel;
import com.example.quanlm.project01_mvp.equation.interfaces.IEquationPresenterForModel;

/**
 * Created by QuanLM on 6/6/2017.
 */

public class ModelEquation implements IEquationModel {
    IEquationPresenterForModel equationPresenterForModel;

    public ModelEquation(IEquationPresenterForModel equationPresenterForModel) {
        this.equationPresenterForModel = equationPresenterForModel;
    }

    @Override
    public void calculate(Float a, Float b) {
        try{
            equationPresenterForModel.calculateDataSuccess(-b/a);
        } catch (Exception ex){
            equationPresenterForModel.calculateDataFail();
        }

    }
}
