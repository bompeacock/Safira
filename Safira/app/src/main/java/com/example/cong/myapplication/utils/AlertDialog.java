package com.example.cong.myapplication.utils;

import android.content.Context;
import android.content.DialogInterface;

public class AlertDialog {

    private AlertDialog() {

    }

    /**
     * Show alert dialog
     */
    public static void showAlertDialog(Context context, String title, String message) {
        final android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(context)
                .create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }
}
