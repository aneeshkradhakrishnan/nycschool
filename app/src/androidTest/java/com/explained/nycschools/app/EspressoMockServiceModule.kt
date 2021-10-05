package com.explained.nycschools.app

import com.explained.nycschools.services.SchoolService
import com.explained.nycschools.service.EspressoMockService
import dagger.Provides

class EspressoMockServiceModule : ServiceModule() {

    @Provides
    override fun provideSchoolService(): SchoolService {
        return EspressoMockService()
    }
}