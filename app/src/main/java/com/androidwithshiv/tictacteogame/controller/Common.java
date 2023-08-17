package com.androidwithshiv.tictacteogame.controller;

import android.content.Context;
import android.widget.Toast;

public class Common {
    public static void showToast(String msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
