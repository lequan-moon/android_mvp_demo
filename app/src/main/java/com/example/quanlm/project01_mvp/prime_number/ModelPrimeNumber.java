package com.example.quanlm.project01_mvp.prime_number;

import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberModel;
import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberPresenterForModel;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class ModelPrimeNumber implements IPrimeNumberModel {
    public static String NOT_PRIME = "Không phải số nguyên tố";
    public static String PRIME = "Số nguyên tố";

    IPrimeNumberPresenterForModel primeNumberPresenterForModel;

    public ModelPrimeNumber(IPrimeNumberPresenterForModel primeNumberPresenterForModel) {
        this.primeNumberPresenterForModel = primeNumberPresenterForModel;
    }

    @Override
    public void checkPrimeNumber(Float checkValue) {
        if (checkValue == 1)
            primeNumberPresenterForModel.checkSuccess(NOT_PRIME);
        else if (checkValue == 2)
            primeNumberPresenterForModel.checkSuccess(PRIME);
        else {
            int dem = 0;
            for (int i = 2; i <= checkValue / 2; i++) {
                if (checkValue % i == 0)
                    dem++;
            }
            if (dem == 0)
                primeNumberPresenterForModel.checkSuccess(PRIME);
            else
                primeNumberPresenterForModel.checkSuccess(NOT_PRIME);
        }
    }
}
