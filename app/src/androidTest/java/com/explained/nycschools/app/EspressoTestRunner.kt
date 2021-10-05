package com.explained.nycschools.app

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class EspressoTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, EspressoTestApplication::class.qualifiedName, context)
    }
}