package com.explained.nycschools.app

import com.explained.nycschools.services.SchoolService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ServiceModule {

    companion object {
        const val HOST = "https://data.cityofnewyork.us/"
    }

    @Provides
    open fun provideSchoolService(): SchoolService {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(logging)
        }

        val gson = GsonBuilder().apply {
            setLenient()
        }.create()

        val retrofit = Retrofit.Builder().apply {
            baseUrl(HOST)
            client(httpClient.build())
            addConverterFactory(GsonConverterFactory.create(gson))
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        }.build()

        return retrofit.create(SchoolService::class.java)
    }
}