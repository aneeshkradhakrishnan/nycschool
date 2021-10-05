package com.explained.nycschools.app

import com.explained.nycschools.MainActivity
import com.explained.nycschools.views.SchoolDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UIModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindSchoolDetailsActivity(): SchoolDetailsActivity
}