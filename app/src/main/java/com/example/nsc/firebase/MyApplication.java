package com.example.nsc.firebase;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by NSC on 9/1/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
