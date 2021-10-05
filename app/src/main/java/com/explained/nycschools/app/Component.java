package com.explained.nycschools.app;

import javax.inject.Singleton;

import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@dagger.Component(
        modules = {AndroidInjectionModule.class,
                AndroidSupportInjectionModule.class,
                ServiceModule.class,
                UIModule.class}
)
interface Component extends AndroidInjector<NYCSchool> {
}
