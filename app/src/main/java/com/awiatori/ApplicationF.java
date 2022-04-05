package com.awiatori;

import android.app.Application;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;

import java.util.Map;

public class ApplicationF extends Application {

    public static String UCSHS;
    public static String ihhds = "-";
    public static String nnhda;
    public static String bbfkd;
    public static String jcsgaj = "cHpmVXJmNWRoTWk3SERMV3ZHMlk1QQ==";
    public static String usbda;
    public static String jjdsa;
    public static String uutahs;

    @Override
    public void onCreate() {
        super.onCreate();

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(PT.dec("YzUwZDRjZmItMjVlMy00ODIyLWJhMmYtM2VhZDM2MDA1ZjZj"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nnhda = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                ;
                }catch (Exception e){

                }
            }
        }).start();

        UCSHS = AppsFlyerLib.getInstance().getAppsFlyerUID(this);


        AppsFlyerLib.getInstance().init(PT.dec(jcsgaj), new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {

                ihhds = map.get(PT.dec("YWZfc3RhdHVz")).toString();

                if (ihhds.equals(PT.dec("Tm9uLW9yZ2FuaWM="))){

                    try {
                        usbda = map.get(PT.dec("Y2FtcGFpZ24=")).toString();
                    }catch (Exception e){

                    }

                    try {

                        jjdsa = map.get(PT.dec("bWVkaWFfc291cmNl")).toString();
                    }catch (Exception e){

                    }

                    try {

                        uutahs = map.get(PT.dec("YWZfY2hhbm5lbA==")).toString();
                    }catch (Exception e){

                    }



                    bbfkd = Parser.parse(usbda);

                }

            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        },this);
        AppsFlyerLib.getInstance().start(this);
    }
}
