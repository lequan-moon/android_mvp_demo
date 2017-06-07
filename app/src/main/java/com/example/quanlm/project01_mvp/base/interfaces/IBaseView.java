package com.example.quanlm.project01_mvp.base.interfaces;

/**
 * Created by QuanLM on 6/7/2017.
 */

public interface IBaseView {
    void onSuccess(String result);

    void onFail(int errorType);
}
