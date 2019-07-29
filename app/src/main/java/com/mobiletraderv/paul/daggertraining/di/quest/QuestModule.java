package com.mobiletraderv.paul.daggertraining.di.quest;

import com.mobiletraderv.paul.daggertraining.network.quest.QuestApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class QuestModule {

    @QuestScope
    @Provides
    static QuestApi provideQuestApi(Retrofit retrofit) {
        return retrofit.create(QuestApi.class);
    }

}