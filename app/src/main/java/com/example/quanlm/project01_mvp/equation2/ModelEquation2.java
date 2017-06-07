package com.example.quanlm.project01_mvp.equation2;

import com.example.quanlm.project01_mvp.equation2.interfaces.IEquation2Model;
import com.example.quanlm.project01_mvp.equation2.interfaces.IEquation2PresenterForModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class ModelEquation2 implements IEquation2Model {
    IEquation2PresenterForModel equation2PresenterForModel;

    public ModelEquation2(IEquation2PresenterForModel equation2PresenterForModel) {
        this.equation2PresenterForModel = equation2PresenterForModel;
    }

    @Override
    public void calculate(float a, float b, float c) {
        try {
            if (a == 0 && b == 0) {
                equation2PresenterForModel.calculateSuccess("Phuong trinh vo so nghiem");
            } else if (a == 0 && b != 0) {
                equation2PresenterForModel.calculateSuccess(String.valueOf(-c / b));
            } else if (a != 0 && b == 0) {
                equation2PresenterForModel.calculateSuccess("Phuong trinh vo nghiem");
            } else {
                float delta = b * b - 4 * a * c;
                if (delta < 0) {
                    equation2PresenterForModel.calculateSuccess("Phuong trinh vo nghiem");
                } else if (delta == 0) {
                    equation2PresenterForModel.calculateSuccess(String.valueOf(-b * a / 2));
                } else {
                    double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
                    double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
                    NumberFormat formatter = new DecimalFormat("#0.00");

                    equation2PresenterForModel.calculateSuccess("x1:" + formatter.format(x1) + "   " + "x2:" + formatter.format(x2));
                }
            }
        } catch (Exception ex) {
            equation2PresenterForModel.calculateFail();
        }

    }
}
