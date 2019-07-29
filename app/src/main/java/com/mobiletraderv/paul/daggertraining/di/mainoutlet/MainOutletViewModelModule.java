package com.mobiletraderv.paul.daggertraining.di.mainoutlet;


import androidx.lifecycle.ViewModel;

import com.mobiletraderv.paul.daggertraining.di.modules.ViewModelKey;
import com.mobiletraderv.paul.daggertraining.ui.mainoutlet.MainOutletViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class MainOutletViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainOutletViewModel.class)
    public abstract ViewModel bindAuthViewModel(MainOutletViewModel viewModel);

}
