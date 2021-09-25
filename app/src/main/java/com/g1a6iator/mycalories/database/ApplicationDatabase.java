package com.g1a6iator.mycalories.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.g1a6iator.mycalories.dao.ProductDao;
import com.g1a6iator.mycalories.model.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ApplicationDatabase extends RoomDatabase {

    public abstract ProductDao productDao();

    private static volatile ApplicationDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ApplicationDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ApplicationDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ApplicationDatabase.class, "my_calories_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
