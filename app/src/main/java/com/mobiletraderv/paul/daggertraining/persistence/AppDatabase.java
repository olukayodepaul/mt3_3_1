package com.mobiletraderv.paul.daggertraining.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mobiletraderv.paul.daggertraining.model.persistUsers;

@Database(entities = {persistUsers.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_db";
    public abstract PostDao getPostsDao();

}
