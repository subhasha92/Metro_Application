package com.example.metroapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    private final Context context;

    public ConnectionDetector(Context context){
        this.context = context;
    }

// --Commented out by Inspection START (22-07-2020 18:46):
//    public boolean isConnectingToInternet(){
//            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        assert cm != null;
//        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
//
//            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//        }
// --Commented out by Inspection STOP (22-07-2020 18:46)

    
/*
    public boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }*/
}
