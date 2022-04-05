package com.awiatori;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private TextView textViewCount, textViewWin, textViewGameOver;
    private ImageView imageView,imageViewSetting;
    private Button button;
    private Display display;
    private int width;
    private int height;
    private int size;
    private int sizeText;
    private int count = 60;
    private int sizeButtonX;
    private final int DIALOG = 1;
    int item = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(1024);

        constraintLayout = findViewById(R.id.constraintLayout);
        textViewCount = findViewById(R.id.textView);
        imageViewSetting = findViewById(R.id.imageViewSetting);
        count = getSharedPreferences(getPackageName(), MODE_PRIVATE).getInt("count", 60);
        display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        size = width/4;
        sizeText = width;
        sizeButtonX = width/2;

        startGame();

        button = new Button(MainActivity.this);
        ConstraintLayout.LayoutParams buttonViewLayoutParams =
                new ConstraintLayout.LayoutParams(sizeButtonX,height/7);
        button.setLayoutParams(buttonViewLayoutParams);
        button.setText("Restart");
        button.setTextSize(30);
        button.setBackgroundResource(R.drawable.groupbut);
        button.setTextColor(getApplication().getResources().getColor(R.color.white));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 60;
                constraintLayout.removeView(button);
                constraintLayout.removeView(textViewWin);
                constraintLayout.removeView(textViewGameOver);
                startGame();
            }
        });



        imageViewSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG);
            }
        });


    }


    private void startGame(){

        imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.drawable.ic_slot_1);

        ConstraintLayout.LayoutParams imageViewLayoutParams =
                new ConstraintLayout.LayoutParams(size,size);
        imageView.setLayoutParams(imageViewLayoutParams);
        constraintLayout.addView(imageView);
        imageView.setY(0);
        imageView.setX(width/2 - size/2);




        new CountDownTimer(60000,10){

            @Override
            public void onTick(long l) {
                imageView.setY(imageView.getY()+3);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView.setY(imageView.getY()-205);

                        Random random = new Random();
                        int r = random.nextInt(4);
                        switch (r){
                            case 0: imageView.setImageResource(R.drawable.ic_slot_1);
                                break;
                            case 1: imageView.setImageResource(R.drawable.ic_slot_2);
                                break;
                            case 2: imageView.setImageResource(R.drawable.ic_slot_3);
                                break;
                            case 3: imageView.setImageResource(R.drawable.ic_slot_4);
                                break;
                        }

                    }
                });

                if (imageView.getY()> height-size){
                    Log.d("ccc", "ccc");
                    textViewGameOver = new TextView(MainActivity.this);
                    ConstraintLayout.LayoutParams textViewLayoutParams1 =
                            new ConstraintLayout.LayoutParams(sizeText, sizeText);
                    textViewGameOver.setLayoutParams(textViewLayoutParams1);
                    textViewGameOver.setText("Game over!!!");
                    textViewGameOver.setTextSize(40);
                    textViewGameOver.setTextColor(getApplication().getResources().getColor(R.color.myG));
                    constraintLayout.addView(textViewGameOver);

                    textViewGameOver.post(new Runnable() {
                        @Override
                        public void run() {
                            textViewGameOver.setX((width-width/2)/2);
                            textViewGameOver.setY(height/2-sizeText/2);
                            constraintLayout.removeView(imageView);
                        }
                    });
                    constraintLayout.addView(button);
                    button.post(new Runnable() {
                        @Override
                        public void run() {
                            button.setY(height -height/2);
                            button.setX(width/2 - sizeButtonX/2);
                        }
                    });

                    cancel();

                }
            }

            @Override
            public void onFinish() {



            }
        }.start();


        new CountDownTimer(60000,1000){

            @Override
            public void onTick(long l) {


                count--;
                textViewCount.setText(""+count);
                if (imageView.getY()> height-size){
                    cancel();
                }

            }

            @Override
            public void onFinish() {

                textViewWin = new TextView(MainActivity.this);
                ConstraintLayout.LayoutParams textViewLayoutParams =
                        new ConstraintLayout.LayoutParams(sizeText, sizeText);
                textViewWin.setLayoutParams(textViewLayoutParams);
                textViewWin.setText("You win!!!");
                textViewWin.setTextColor(getApplication().getResources().getColor(R.color.white));
                textViewWin.setTextSize(40);
                constraintLayout.addView(textViewWin);

                textViewWin.post(new Runnable() {
                    @Override
                    public void run() {
                        textViewWin.setX((width-width/2)/2);
                        textViewWin.setY(height/2-sizeText/2);
                    }
                });
                constraintLayout.addView(button);
                button.post(new Runnable() {
                    @Override
                    public void run() {
                        button.setY(height -height/2);
                        button.setX(width/2 - sizeButtonX/2);
                    }
                });


                constraintLayout.removeView(imageView);

            }
        }.start();
    }


    protected Dialog onCreateDialog(int id) {


        if (id == DIALOG) {
            String [] catNamesArray = {"30", "60", "100"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Settings time");
            switch (count) {
                case 30:
                    item = 0;
                    break;
                case 60:
                    item = 1;
                    break;
                case 100:
                    item = 2;
                    break;
            }


            builder.setSingleChoiceItems(catNamesArray, item,
                   new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int item) {
                            switch (item) {
                                case 0:
                                    count = 30 ;
                                    break;
                                case 1:
                                    count = 60;
                                    break;
                                case 2:
                                    count = 100;
                                    break;

                            }
                        }
                   });
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putInt("count", count).apply();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
            });
            builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {

                }
            });

            return builder.create();
        }
        return super.onCreateDialog(id);
    }

}