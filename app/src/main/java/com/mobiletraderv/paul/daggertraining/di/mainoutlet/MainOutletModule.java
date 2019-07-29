package com.mobiletraderv.paul.daggertraining.di.mainoutlet;

import com.mobiletraderv.paul.daggertraining.network.mainoutlet.MainOutletApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainOutletModule {

    @MainOutletScope
    @Provides
    static MainOutletApi provideMainOutletApi(Retrofit retrofit) {
        return retrofit.create(MainOutletApi.class);
    }

}
