package com.example.quanlm.project01_mvp.prime_number;

import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberModel;
import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberPresenterForModel;
import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberPresenterForView;
import com.example.quanlm.project01_mvp.prime_number.interfaces.IPrimeNumberView;
import com.example.quanlm.project01_mvp.util.Validator;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class PresenterPrimeNumber implements IPrimeNumberPresenterForView, IPrimeNumberPresenterForModel {
    IPrimeNumberView primeNumberView;
    IPrimeNumberModel primeNumberModel;

    public PresenterPrimeNumber(IPrimeNumberView primeNumberView) {
        this.primeNumberView = primeNumberView;
        primeNumberModel = new ModelPrimeNumber(this);
    }

    @Override
    public void checkPrimeNumber(String checkValue) {
        if (Validator.isValidNumber(checkValue)) {
            Float fltPrimeValue = Float.parseFloat(checkValue);
            if (fltPrimeValue <= 1) {
                primeNumberView.onFail(Validator.ERR_VALIDATE_MIN_1);
            } else {
                primeNumberModel.checkPrimeNumber(fltPrimeValue);
            }
        } else {
            primeNumberView.onFail(Validator.ERR_VALIDATE_NUMBER);
        }
    }

    @Override
    public void checkSuccess(String result) {
        primeNumberView.onSuccess(result);
    }

    @Override
    public void checkFail() {
        primeNumberView.onFail(Validator.ERR_COMMON);
    }
}
