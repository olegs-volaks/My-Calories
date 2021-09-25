package com.g1a6iator.mycalories;

import android.app.Application;

import com.g1a6iator.mycalories.database.ApplicationDatabase;

public class MainApplication extends Application {

    private static MainApplication instance;
    private ApplicationDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = ApplicationDatabase.getDatabase(this);
    }

    public static MainApplication getInstance() {
        return instance;
    }

    public ApplicationDatabase getDatabase() {
        return database;
    }
}
