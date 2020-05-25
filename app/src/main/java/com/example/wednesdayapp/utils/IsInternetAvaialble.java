package com.example.wednesdayapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class IsInternetAvaialble {

    public static boolean isIntenetAvaialble(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {
            //not avaialable
            return false;
        } else {

            //avialalble
            return true;
        }
    }
}
