package com.explained.nycschools.app

import dagger.android.AndroidInjector

class EspressoTestApplication : NYCSchool() {
    override fun applicationInjector(): AndroidInjector<NYCSchool> {
        return DaggerComponent
                .builder()
                .serviceModule(EspressoMockServiceModule())
                .build()
    }
}
