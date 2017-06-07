package com.example.quanlm.project01_mvp.perfect_number;

import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberModel;
import com.example.quanlm.project01_mvp.perfect_number.interfaces.IPerfectNumberPresenterForModel;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class ModelPerfectNumber implements IPerfectNumberModel {
    IPerfectNumberPresenterForModel perfectNumberPresenterForModel;

    public ModelPerfectNumber(IPerfectNumberPresenterForModel perfectNumberPresenterForModel) {
        this.perfectNumberPresenterForModel = perfectNumberPresenterForModel;
    }

    @Override
    public void searchPerfectNumber() {
        perfectNumberPresenterForModel.searchSuccess("6 - 28 - 496");
    }
}
