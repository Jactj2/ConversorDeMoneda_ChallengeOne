package com.challenge_one.conversordemonedas.utils;

public class References {

    public static  String separatorTitle    = "******************************************************";
    public  static String separatorTicket   = "===                                                ===";

    public static String[] listTitles = {
            "   1) Dólar           =>> Peso Argentino",
            "   2) Peso Argentino  =>> Dólar",
            "   3) Dólar           =>> Real brasileño",
            "   4) Real brasileño  =>> Dólar",
            "   5) Dólar           =>> Peso colombiano",
            "   6) Peso colombiano =>> Dólar",
            "   7) Salir\n"
    };

    public static final String[] listFinals = {
            "           %.2f Dólar      =>> %f Peso Argentino      "  ,
            "       %.2f Peso Argentino     =>>     %.2f Dólar     ",
            "           %.2f Dólar  =>> %.2f Real brasileño        ",
            "           %.2f Real brasileño =>> %.2f Dólar         ",
            "         %.2f Dólar  =>> %.2f Peso colombiano         ",
            "         %.2f Peso colombiano =>>  %.2f Dólar         ",
    };


}
