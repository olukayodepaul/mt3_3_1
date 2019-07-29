package com.mobiletraderv.paul.daggertraining.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.mobiletraderv.paul.daggertraining.persistence.AppDatabase;
import com.mobiletraderv.paul.daggertraining.persistence.PostDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.mobiletraderv.paul.daggertraining.persistence.AppDatabase.DATABASE_NAME;

@Module
public class PersistencyModule {

    @Singleton
    @Provides
    static AppDatabase provideAppDatabase(Application application){
        return Room.databaseBuilder(
                application,
                AppDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static PostDao provideRecipeDao(AppDatabase db){
        return db.getPostsDao();
    }
}
