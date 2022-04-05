package com.awiatori;

import static com.awiatori.ApplicationF.uutahs;
import static com.awiatori.ApplicationF.usbda;
import static com.awiatori.ApplicationF.jcsgaj;
import static com.awiatori.ApplicationF.jjdsa;


public class Parser {

    private static String dsdada;
    private static String adsad;
    private static String bfdfd;
    private static String vdaa;
    private static String njjka;
    private static String kiuhass;
    public static PT pt;

    public static String parse(String s) {

        String[] campLucky = s.split("_");

        try {
            dsdada = campLucky[0];
        } catch (Exception e) {

            dsdada = "";
        }
        try {
            adsad = campLucky[1];
        } catch (Exception e) {

            adsad = "";
        }
        try {
            bfdfd = campLucky[2];
        } catch (Exception e) {
            bfdfd = "";

        }
        try {
            vdaa = campLucky[3];
        } catch (Exception e) {
            vdaa = "";

        }
        try {
            njjka = campLucky[4];
        } catch (Exception e) {
            njjka = "";
            ;
        }
        try {
            kiuhass = campLucky[5];
        } catch (Exception e) {
            kiuhass = "";

        }

        return PT.dec("P21lZGlhX3NvdXJjZT0=") + jjdsa +
                PT.dec("JnN1YjE9") + dsdada +
                PT.dec("JnN1YjI9") + adsad +
                PT.dec("JnN1YjM9") + bfdfd +
                PT.dec("JnN1YjQ9") + vdaa +
                PT.dec("JnN1YjU9") + njjka +
                PT.dec("JnN1YjY9") + kiuhass +
                PT.dec("JmNhbXBhaWduPQ==") + usbda +
                PT.dec("Jmdvb2dsZV9hZGlkPQ==") + ApplicationF.nnhda +
                PT.dec("JmFmX3VzZXJpZD0=") + ApplicationF.UCSHS +
                PT.dec("JmFmX2NoYW5uZWw9") + uutahs +
                PT.dec("JmRldl9rZXk9") + PT.dec(jcsgaj) +
                PT.dec("JmJ1bmRsZT0=") + pt.getPackageName() +
                PT.dec("JmZiX2FwcF9pZD0=") + PT.fbId +
                PT.dec("JmZiX2F0PQ==") + PT.fbToken;
    }

}
