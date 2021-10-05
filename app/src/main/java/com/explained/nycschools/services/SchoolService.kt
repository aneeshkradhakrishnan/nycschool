package com.explained.nycschools.services

import com.explained.nycschools.models.SatResult
import com.explained.nycschools.models.SchoolInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolService {

    @GET("resource/s3k6-pzi2.json")
    fun getList(): Single<List<SchoolInfo>>

    @GET("resource/f9bf-2cp4.json")
    fun getSatResult(@Query("dbn") dbn: String): Single<List<SatResult>>
}