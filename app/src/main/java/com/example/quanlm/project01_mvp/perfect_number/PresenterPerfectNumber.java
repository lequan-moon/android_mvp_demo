package com.example.quanlm.project01_mvp.perfect_number;

import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberModel;
import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberPresenterForModel;
import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberPresenterForView;
import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberView;
import com.example.quanlm.project01_mvp.util.Validator;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class PresenterPerfectNumber implements IPerfectNumberPresenterForView, IPerfectNumberPresenterForModel {
    IPerfectNumberView perfectNumberView;
    IPerfectNumberModel perfectNumberModel;

    public PresenterPerfectNumber(IPerfectNumberView perfectNumberView) {
        this.perfectNumberView = perfectNumberView;
        perfectNumberModel = new ModelPerfectNumber(this);
    }

    @Override
    public void searchPerfectNumber() {
        perfectNumberModel.searchPerfectNumber();
    }

    @Override
    public void searchSuccess(String result) {
        perfectNumberView.onSuccess(result);
    }

    @Override
    public void searchFail() {
        perfectNumberView.onFail(Validator.ERR_COMMON);
    }
}
