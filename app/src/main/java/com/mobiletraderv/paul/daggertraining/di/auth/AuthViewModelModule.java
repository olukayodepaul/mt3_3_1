package com.mobiletraderv.paul.daggertraining.di.auth;

import androidx.lifecycle.ViewModel;

import com.mobiletraderv.paul.daggertraining.di.modules.ViewModelKey;
import com.mobiletraderv.paul.daggertraining.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

}
