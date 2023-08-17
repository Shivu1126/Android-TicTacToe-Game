package com.androidwithshiv.tictacteogame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidwithshiv.tictacteogame.controller.Common;
import com.google.android.material.card.MaterialCardView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private Context context;
    private MaterialCardView box1Card, box2Card, box3Card, box4Card, box5Card, box6Card, box7Card, box8Card, box9Card, resetCard;
    private ImageView turnImage;
    private ImageView box1Image, box2Image, box3Image, box4Image, box5Image, box6Image, box7Image, box8Image, box9Image;
    private TextView xScoreTv, oScoreTv, tiesTv;

    private boolean box1bl, box2bl, box3bl, box4bl, box5bl, box6bl, box7bl, box8bl, box9bl;
    private boolean isX_turn;
    private String singleOrDuo;
    private String choosedMark;
    private String box1Value, box2Value, box3Value, box4Value, box5Value, box6Value, box7Value, box8Value, box9Value;
    private int markedCount, winningCountX, winningCountO, tiedCount;
    private boolean xIsYou;
    private void init(){

        context = GameActivity.this;
        box1Card = findViewById(R.id.box1);
        box2Card = findViewById(R.id.box2);
        box3Card = findViewById(R.id.box3);
        box4Card = findViewById(R.id.box4);
        box5Card = findViewById(R.id.box5);
        box6Card = findViewById(R.id.box6);
        box7Card = findViewById(R.id.box7);
        box8Card = findViewById(R.id.box8);
        box9Card = findViewById(R.id.box9);

        box1Image = findViewById(R.id.box1_img);
        box2Image = findViewById(R.id.box2_img);
        box3Image = findViewById(R.id.box3_img);
        box4Image = findViewById(R.id.box4_img);
        box5Image = findViewById(R.id.box5_img);
        box6Image = findViewById(R.id.box6_img);
        box7Image = findViewById(R.id.box7_img);
        box8Image = findViewById(R.id.box8_img);
        box9Image = findViewById(R.id.box9_img);

        xScoreTv = findViewById(R.id.x_score);
        oScoreTv = findViewById(R.id.o_score);
        tiesTv = findViewById(R.id.tie_score);

        turnImage = findViewById(R.id.turn_img);

        resetCard = findViewById(R.id.reset_game);
        box1bl = box2bl = box3bl = box4bl = box5bl = box6bl = box7bl = box8bl = box9bl = false;
        isX_turn = true;

        Intent intent = getIntent();
        singleOrDuo = intent.getStringExtra("SingleOrDuo");
        choosedMark = intent.getStringExtra("playerChoose");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        init();

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(context, R.color.home_bg));

        resetCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(singleOrDuo.equals("single") && choosedMark.equals("o")){
                    resetGame(true);
                }
                else{
                    resetGame(false);
                }
            }
        });

        startGame();

    }

    private void startGame(){
        box1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box1bl){
                    box1Image.setVisibility(View.VISIBLE);
                    box1bl = true;
                    markedOption(box1Image, 1);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box2bl){
                    box2Image.setVisibility(View.VISIBLE);
                    box2bl = true;
                    markedOption(box2Image, 2);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box3Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box3bl){
                    box3Image.setVisibility(View.VISIBLE);
                    box3bl = true;
                    markedOption(box3Image, 3);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box4Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box4bl){
                    box4Image.setVisibility(View.VISIBLE);
                    box4bl = true;
                    markedOption(box4Image, 4);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box5Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box5bl){
                    box5Image.setVisibility(View.VISIBLE);
                    box5bl = true;
                    markedOption(box5Image, 5);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });
        box6Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box6bl){
                    box6Image.setVisibility(View.VISIBLE);
                    box6bl = true;
                    markedOption(box6Image, 6);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box7Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box7bl){
                    box7Image.setVisibility(View.VISIBLE);
                    box7bl = true;
                    markedOption(box7Image, 7);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box8Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box8bl){
                    box8Image.setVisibility(View.VISIBLE);
                    box8bl = true;
                    markedOption(box8Image, 8);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        box9Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean alreadyMark = false;
                if(!box9bl){
                    box9Image.setVisibility(View.VISIBLE);
                    box9bl = true;
                    markedOption(box9Image, 9);
                    markedCount++;
                }
                else{
                    Common.showToast("Already Marked", context);
                    alreadyMark = true;
                }
                if(markedCount>=5){
                    gameEnd(checkWhoIsWin(), false);
                }
                if(singleOrDuo.equals("single") && !alreadyMark){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            randomCpu();
                        }
                    }, 2000);
                }
            }
        });

        if(singleOrDuo.equals("single")){
            if(choosedMark.equals("o")){
                xIsYou = false;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomCpu();
                    }
                }, 2000);
            }
            else{
                xIsYou = true;
            }
        }
    }

    private void markedOption(ImageView boxImage, int id){
        String value = "";
        if(isX_turn){
            boxImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cross));
            value = "x";
            isX_turn = false;
            turnImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.o_letter));
        }
        else{
            boxImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.o_letter));
            value = "o";
            isX_turn = true;
            turnImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cross));
        }
        if(id==1){
            box1Value = value;
        } else if (id==2) {
            box2Value = value;
        }else if (id==3) {
            box3Value = value;
        }else if (id==4) {
            box4Value = value;
        }else if (id==5) {
            box5Value = value;
        }else if (id==6) {
            box6Value = value;
        }else if (id==7) {
            box7Value = value;
        }else if (id==8) {
            box8Value = value;
        }else if (id==9) {
            box9Value = value;
        }
    }
    private void randomCpu(){
        if(choosedMark.equals("x") && markedCount==0)
        {
            Log.d("first-move-x", "yes..");
        }
        else {
            int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int randomValue = arr[new Random().nextInt(arr.length)];
            Log.d("randomNum", randomValue + "");
            if (randomValue == 1 && !box1bl) {
                box1Image.setVisibility(View.VISIBLE);
                box1bl = true;
                markedOption(box1Image, 1);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 2 && !box2bl) {
                box2Image.setVisibility(View.VISIBLE);
                box2bl = true;
                markedOption(box2Image, 2);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 3 && !box3bl) {
                box3Image.setVisibility(View.VISIBLE);
                box3bl = true;
                markedOption(box3Image, 3);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 4 && !box4bl) {
                box4Image.setVisibility(View.VISIBLE);
                box4bl = true;
                markedOption(box4Image, 4);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 5 && !box5bl) {
                box5Image.setVisibility(View.VISIBLE);
                box5bl = true;
                markedOption(box5Image, 5);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 6 && !box6bl) {
                box6Image.setVisibility(View.VISIBLE);
                box6bl = true;
                markedOption(box6Image, 6);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 7 && !box7bl) {
                box7Image.setVisibility(View.VISIBLE);
                box7bl = true;
                markedOption(box7Image, 7);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 8 && !box8bl) {
                box8Image.setVisibility(View.VISIBLE);
                box8bl = true;
                markedOption(box8Image, 8);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else if (randomValue == 9 && !box9bl) {
                box9Image.setVisibility(View.VISIBLE);
                box9bl = true;
                markedOption(box9Image, 9);
                markedCount++;
                if (markedCount >= 5) {
                    gameEnd(checkWhoIsWin(), true);
                }
            } else {
                randomCpu();
            }
        }
    }

    private String checkWhoIsWin(){
        Log.d("checkWhoIsWin", "called");
        String whoIsWin = "";
//        Log.d("values--", box1Value+"-"+box2Value+"-"+box3Value+"\n"+
//                                box4Value+"-"+box5Value+"-"+box6Value+"\n"+
//                                box7Value+"-"+box8Value+"-"+box9Value);

        if(box1bl){
            String mark = box1Value;
            Log.d("box1mark", mark);
            if(mark!=null){
                if((box2Value!=null && box3Value!=null) && (box2Value.equals(mark) && box3Value.equals(mark))){
                    return mark;
                } else if ((box5Value!=null && box9Value!=null) && (box5Value.equals(mark) && box9Value.equals(mark))) {
                    return mark;
                } else if ((box4Value!=null && box7Value!=null) && (box4Value.equals(mark) && box7Value.equals(mark))) {
                    return mark;
                }
            }
        }
        if(box2bl){
            String mark = box2Value;
            if(mark!=null){
                if((box5Value!=null && box8Value!=null) && (box5Value.equals(mark) && box8Value.equals(mark))){
                    return mark;
                }
            }
        }
        if(box3bl){
            String mark = box3Value;
            if(mark!=null){
                if((box6Value!=null && box9Value!=null) && (box6Value.equals(mark) && box9Value.equals(mark))){
                    return mark;
                } else if ((box5Value!=null && box7Value!=null) && (box5Value.equals(mark) && box7Value.equals(mark))) {
                    return mark;
                }
            }
        }
        if(box4bl){
            String mark = box4Value;
            if(mark!=null){
                if ((box5Value!=null && box6Value!=null) && (box5Value.equals(mark) && box6Value.equals(mark))){
                    return mark;
                }
            }
        }
        if(box7bl){
            String mark = box7Value;
            if(mark!=null){
                if ((box8Value!=null && box9Value!=null) && (box8Value.equals(mark) && box9Value.equals(mark))){
                    return mark;
                }
            }
        }
        if(markedCount==9){
            return "tie";
        }

        return whoIsWin;
    }

    private void gameEnd(String winningMark, boolean isFromRandom){
        Log.d("WinningMark", winningMark);
        if(winningMark.equals("x")){
            Common.showToast("'X' is won", context);
            winningCountX++;
            Log.d("x", "won"+winningCountX);
            xScoreTv.setText(Integer.toString(winningCountX));
            resetGame(isFromRandom);
        } else if (winningMark.equals("o")) {
            Common.showToast("'O' is won", context);
            winningCountO++;
            Log.d("o", "won"+winningCountO);
            oScoreTv.setText(Integer.toString(winningCountO));
            resetGame(isFromRandom);
        } else if (winningMark.equals("tie")) {
            Common.showToast("Game Tied", context);
            tiedCount++;
            Log.d("game", "tie");
            tiesTv.setText(Integer.toString(tiedCount));
            resetGame(isFromRandom);
        } else {
            Log.d("else", "called");
        }
    }

    private void resetGame(boolean isFromRandom){
        Log.d("resetGame", "called");
        box1Image.setVisibility(View.GONE);
        box2Image.setVisibility(View.GONE);
        box3Image.setVisibility(View.GONE);
        box4Image.setVisibility(View.GONE);
        box5Image.setVisibility(View.GONE);
        box6Image.setVisibility(View.GONE);
        box7Image.setVisibility(View.GONE);
        box8Image.setVisibility(View.GONE);
        box9Image.setVisibility(View.GONE);

        turnImage.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.cross));

        box1bl = box2bl = box3bl = box4bl = box5bl = box6bl = box7bl = box8bl = box9bl = false;
        box1Value = box2Value = box3Value = box4Value = box5Value = box6Value = box7Value = box8Value = box9Value = "";
        isX_turn = true;

        markedCount = 0;
        if(singleOrDuo.equals("single") && isFromRandom){
            Log.d("choosed-mark", choosedMark);
            if(choosedMark.equals("o")){
                xIsYou = false;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomCpu();
                    }
                }, 2000);
            }
            else{
                xIsYou = true;
            }
            return;
        }
    }
}