package com.example.quanlm.project01_mvp.util;

import android.text.TextUtils;

/**
 * Created by QuanLM on 6/6/2017.
 */

public class Validator {
    public static final int ERR_COMMON = 0;
    public static final int ERR_VALIDATE_NUMBER = 1;
    public static final int ERR_VALIDATE_NUMBER_ZERO = 2;
    public static final int ERR_VALIDATE_MIN_1 = 3;

    public static boolean isValidNumber(String value){
        if(TextUtils.isDigitsOnly(value)&& !value.isEmpty()){
            return true;
        }
        return false;
    }
}
