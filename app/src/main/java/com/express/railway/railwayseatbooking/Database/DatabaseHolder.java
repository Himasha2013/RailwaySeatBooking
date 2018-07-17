package com.express.railway.railwayseatbooking.Database;

import android.support.annotation.NonNull;
import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseHolder {

    private static AppDatabase DB_INSTANCE;

    private static final String DATABASE_NAME = "railwayseatbooking-db";


    public static AppDatabase getDatabaseInstance(@NonNull Context context) {

        if (DB_INSTANCE == null) {
            DB_INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return DB_INSTANCE;
    }

}
