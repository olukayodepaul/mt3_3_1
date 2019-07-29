package com.mobiletraderv.paul.daggertraining.di.modules;


import com.mobiletraderv.paul.daggertraining.viewmodels.ViewModelProviderFactory;

import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);
}
