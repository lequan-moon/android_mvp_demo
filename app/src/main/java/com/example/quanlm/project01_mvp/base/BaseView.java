package com.example.quanlm.project01_mvp.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.quanlm.project01_mvp.R;
import com.example.quanlm.project01_mvp.base.interfaces.IBaseView;
import com.example.quanlm.project01_mvp.util.Validator;

/**
 * Created by QuanLM on 6/7/2017.
 */

public class BaseView extends AppCompatActivity implements IBaseView{
    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onFail(int errorType) {
        switch (errorType){
            case Validator.ERR_COMMON:
                Toast.makeText(this, this.getResources().getText(R.string.error_common), Toast.LENGTH_SHORT).show();
                break;
            case Validator.ERR_VALIDATE_NUMBER:
                Toast.makeText(this, this.getResources().getText(R.string.error_number_type), Toast.LENGTH_SHORT).show();
                break;
            case Validator.ERR_VALIDATE_NUMBER_ZERO:
                Toast.makeText(this, this.getResources().getText(R.string.error_number_zero), Toast.LENGTH_SHORT).show();
                break;
            case Validator.ERR_VALIDATE_MIN_1:
                Toast.makeText(this, this.getResources().getText(R.string.error_min_number_1), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, this.getResources().getText(R.string.error_common), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
