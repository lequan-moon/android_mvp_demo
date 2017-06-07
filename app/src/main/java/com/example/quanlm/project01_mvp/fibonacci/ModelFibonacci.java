package com.example.quanlm.project01_mvp.fibonacci;

import android.widget.TextView;

import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciModel;
import com.example.quanlm.project01_mvp.fibonacci.interfaces.IFibonacciPresenterForModel;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class ModelFibonacci implements IFibonacciModel{
    IFibonacciPresenterForModel fibonacciPresenterForModel;

    public ModelFibonacci(IFibonacciPresenterForModel fibonacciPresenterForModel) {
        this.fibonacciPresenterForModel = fibonacciPresenterForModel;
    }

    @Override
    public void searchFibonacciList(int limit) {
        String result = "";

        int f1 = 1, f2 = 2, f3;
        while (f1 <= limit) {
            result += "-"  + f1;
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        fibonacciPresenterForModel.onSearchSuccess(result.replaceFirst("-", ""));
    }
}
