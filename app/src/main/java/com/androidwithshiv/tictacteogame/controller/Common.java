package com.androidwithshiv.tictacteogame.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.androidwithshiv.tictacteogame.R;

public class Common {
    public static void showToast(String msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public static void alertBox(String singleOrDuo, String chooseMark, String winningPlayer, Context context){

        if(singleOrDuo.equals("tie")){
            return;
        }

        AlertDialog alertBox;
        View alertBoxView = LayoutInflater.from(context).inflate(R.layout.dialog_box_ui, null);
        AlertDialog.Builder alertDialogue = new AlertDialog.Builder(context);
        alertDialogue.setView(alertBoxView);

        TextView winningTv = alertBoxView.findViewById(R.id.win_or_lose_tv);
        ImageView icon = alertBoxView.findViewById(R.id.cup);
        ImageView star = alertBoxView.findViewById(R.id.star);

        alertBox = alertDialogue.create();
        alertBox.setCanceledOnTouchOutside(true);

        if(singleOrDuo.equals("single")){
            if(chooseMark.equals(winningPlayer)){
                //you win
                winningTv.setText(R.string.you_win);
                icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.award));
                star.setVisibility(View.VISIBLE);
            }
            else{
                //you lose
                winningTv.setText(R.string.you_lose);
                winningTv.setTextColor(context.getColor(R.color.lose));
                icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.trophy));
                star.setVisibility(View.GONE);
            }
        }
        else{
            if(winningPlayer.equals("x")){
                //x win
                winningTv.setText(R.string.x_win);
            }
            else{
                //y win
                winningTv.setText(R.string.o_win);
            }
            icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.award));
            star.setVisibility(View.VISIBLE);
        }

        alertBox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertBox.show();
    }

}
