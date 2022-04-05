package com.awiatori;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrivAc extends AppCompatActivity {

    ImageView imageView, imageView1, imageView2, imageView3;
    int aaa = 0;
    int bbb = 0;
    int ccc = 0;
    int ddd = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(1024);
        setContentView(R.layout.privac);
        imageView = findViewById(R.id.imageView4);
        imageView1 = findViewById(R.id.imageView5);
        imageView2 = findViewById(R.id.imageView6);
        imageView3 = findViewById(R.id.imageView7);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setRotation(imageView.getRotation() + 40);

                        aaa++;
                        if (aaa != 40){
                            handler.postDelayed(this::run,10);
                        }else {
                            aaa = 0;
                        }

                    }
                });


            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        imageView2.setRotation(imageView2.getRotation() + 40);
                        bbb++;
                        if (bbb != 40){
                            handler.postDelayed(this::run,10);
                        }else {
                            bbb = 0;
                        }

                    }
                });


            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        imageView3.setRotation(imageView3.getRotation() + 40);
                        ccc++;
                        if (ccc != 40){
                            handler.postDelayed(this::run,10);
                        }else {
                            ccc = 0;
                        }

                    }
                });


            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView1.setRotation(imageView1.getRotation() + 40);

                        ddd++;
                        if (ddd != 40){
                            handler.postDelayed(this::run,10);
                        }else {
                            ddd = 0;
                        }

                    }
                });

            }
        });

    }
}
