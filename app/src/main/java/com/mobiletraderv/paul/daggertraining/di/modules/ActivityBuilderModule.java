package com.mobiletraderv.paul.daggertraining.di.modules;

import com.mobiletraderv.paul.daggertraining.di.mainoutlet.MainOutletModule;
import com.mobiletraderv.paul.daggertraining.di.mainoutlet.MainOutletScope;
import com.mobiletraderv.paul.daggertraining.di.mainoutlet.MainOutletViewModelModule;
import com.mobiletraderv.paul.daggertraining.di.auth.AuthModule;
import com.mobiletraderv.paul.daggertraining.di.auth.AuthScope;
import com.mobiletraderv.paul.daggertraining.di.auth.AuthViewModelModule;
import com.mobiletraderv.paul.daggertraining.di.main.MainScope;
import com.mobiletraderv.paul.daggertraining.di.main.MainViewModelModule;
import com.mobiletraderv.paul.daggertraining.di.quest.QuestModule;
import com.mobiletraderv.paul.daggertraining.di.quest.QuestScope;
import com.mobiletraderv.paul.daggertraining.di.quest.QuestViewModelModule;
import com.mobiletraderv.paul.daggertraining.ui.auth.AuthActivity;
import com.mobiletraderv.paul.daggertraining.ui.main.MainActivity;
import com.mobiletraderv.paul.daggertraining.ui.mainoutlet.MainOutletActivity;
import com.mobiletraderv.paul.daggertraining.ui.quest.QuestActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class,
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainViewModelModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

    @MainOutletScope
    @ContributesAndroidInjector(
            modules = {
                    MainOutletViewModelModule.class,
                    MainOutletModule.class
            }
    )
    abstract MainOutletActivity contributeMainOutletActivity();

    @QuestScope
    @ContributesAndroidInjector(
            modules = {
                    QuestViewModelModule.class,
                    QuestModule.class
            }
    )
    abstract QuestActivity contributeQuestActivity();
}
