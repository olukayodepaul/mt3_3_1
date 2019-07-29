package com.mobiletraderv.paul.daggertraining.di.component;

import android.app.Application;

import com.mobiletraderv.paul.daggertraining.BaseApplication;
import com.mobiletraderv.paul.daggertraining.di.modules.ActivityBuilderModule;
import com.mobiletraderv.paul.daggertraining.di.modules.NetworkModule;
import com.mobiletraderv.paul.daggertraining.di.modules.PersistencyModule;
import com.mobiletraderv.paul.daggertraining.di.modules.ViewModelFactoryModule;
import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                NetworkModule.class,
                ViewModelFactoryModule.class,
                PersistencyModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
