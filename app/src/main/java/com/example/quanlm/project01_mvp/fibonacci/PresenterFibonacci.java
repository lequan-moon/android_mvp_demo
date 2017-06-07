package com.example.quanlm.project01_mvp.fibonacci;

import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciModel;
import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciPresenterForModel;
import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciPresenterForView;
import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciView;
import com.example.quanlm.project01_mvp.util.Validator;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class PresenterFibonacci implements IFibonacciPresenterForModel, IFibonacciPresenterForView {
    IFibonacciView fibonacciView;
    IFibonacciModel fibonacciModel;

    public PresenterFibonacci(IFibonacciView fibonacciView) {
        this.fibonacciView = fibonacciView;
        fibonacciModel = new ModelFibonacci(this);
    }

    @Override
    public void searchFibonacciList(String limit) {
        if(Validator.isValidNumber(limit)){
            int intLimit = Integer.parseInt(limit);
            fibonacciModel.searchFibonacciList(intLimit);
        }else{
            fibonacciView.onFail(Validator.ERR_VALIDATE_NUMBER);
        }
    }

    @Override
    public void onSearchSuccess(String result) {
        fibonacciView.onSuccess(result);
    }

    @Override
    public void onSearchFail() {
        fibonacciView.onFail(Validator.ERR_COMMON);
    }
}
