package com.mobiletraderv.paul.daggertraining.di.main;

import androidx.lifecycle.ViewModel;

import com.mobiletraderv.paul.daggertraining.di.modules.ViewModelKey;
import com.mobiletraderv.paul.daggertraining.ui.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindAuthViewModel(MainViewModel viewModel);

}
