package com.explained.nycschools.service

import com.explained.nycschools.models.SatResult
import com.explained.nycschools.models.SchoolInfo
import com.explained.nycschools.services.SchoolService
import com.explained.nycschools.util.ServiceUtil
import io.reactivex.rxjava3.core.Single

//This is an easy go
//it should be done with mock webserver and dispatching the json matching request
class EspressoMockService : SchoolService {
    override fun getList(): Single<List<SchoolInfo>> {
        return Single.just(listOf(ServiceUtil.createSchoolInfo()))
    }

    override fun getSatResult(dbn: String): Single<List<SatResult>> {
        return Single.just(listOf(ServiceUtil.createSATResult()))
    }
}