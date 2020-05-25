package com.example.wednesdayapp.utils.roomdatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {WednsedayTable.class}, version = 1)
public abstract class WednesdayDatabse extends RoomDatabase {

    static WednesdayDatabse databse;

    public static WednesdayDatabse getDatabaseIntance(Context context) {

        if (databse == null) {
            databse = Room.databaseBuilder(context, WednesdayDatabse.class, "WEDNESDAY_DATABASE").build();
        }
        return databse;
    }

    public abstract WednedayDao wednedayDao();
}
