package com.explained.nycschools.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class NYCSchool extends DaggerApplication {
    @Override
    protected AndroidInjector<NYCSchool> applicationInjector() {
        return DaggerComponent.builder().build();
    }
}
