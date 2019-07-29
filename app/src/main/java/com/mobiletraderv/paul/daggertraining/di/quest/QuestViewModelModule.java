package com.mobiletraderv.paul.daggertraining.di.quest;

import androidx.lifecycle.ViewModel;

import com.mobiletraderv.paul.daggertraining.di.modules.ViewModelKey;
import com.mobiletraderv.paul.daggertraining.ui.quest.QuestViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class QuestViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuestViewModel.class)
    public abstract ViewModel bindAuthViewModel(QuestViewModel viewModel);

}
