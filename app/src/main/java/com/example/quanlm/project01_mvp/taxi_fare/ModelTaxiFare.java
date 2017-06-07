package com.example.quanlm.project01_mvp.taxi_fare;

import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFareModel;
import com.example.quanlm.project01_mvp.taxi_fare.interfaces.ITaxiFarePresenterForModel;

/**
 * Created by QuanLM on 6/6/2017.
 */

public class ModelTaxiFare implements ITaxiFareModel {
    public static float FIRST_KM_FARE = 5000;
    public static float THIRTY_KM_FARE = 4000;
    public static float MORE_THAN_THIRTY_KM_FARE = 4000;

    ITaxiFarePresenterForModel taxiFarePresenterForModel;

    public ModelTaxiFare(ITaxiFarePresenterForModel taxiFarePresenterForModel) {
        this.taxiFarePresenterForModel = taxiFarePresenterForModel;
    }

    @Override
    public void calculate(float km) {
        try{
            float result;
            if (km > 0 && km <= 30) {
                result = FIRST_KM_FARE + (km - 1) * THIRTY_KM_FARE;
            } else if (km > 30){
                result = FIRST_KM_FARE + 30 * THIRTY_KM_FARE + (km -30) * MORE_THAN_THIRTY_KM_FARE;
            } else {
                result = Float.valueOf(0);
            }
            taxiFarePresenterForModel.calculateDataSuccess(result);
        } catch (Exception ex){
            taxiFarePresenterForModel.calculateDataFail();
        }

    }
}
