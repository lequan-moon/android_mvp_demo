package com.example.quanlm.project01_mvp.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.quanlm.project01_mvp.R;

/**
 * Created by QuanLM on 5/30/2017.
 */

public class ConfirmDialogFragment extends DialogFragment {
    DialogInterface.OnClickListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity hostActivity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        try {
            listener = (DialogInterface.OnClickListener) hostActivity;
        } catch (ClassCastException ex) {
            System.out.print(ex.getMessage());
        }
        builder.setMessage(hostActivity.getResources().getString(R.string.exit_confirm));
        builder.setPositiveButton("Yes", listener);
        builder.setNegativeButton("No", listener);
        return builder.create();
    }
}
