package com.explained.nycschools.views

import android.content.Intent
import com.explained.nycschools.MainActivity
import com.explained.nycschools.robots.MainActivityRobot
import org.junit.Before
import org.junit.Test

class MainActivityTest : EspressoBaseTest<MainActivity>(MainActivity::class.java) {

    val eyes: MainActivityRobot.Eyes = MainActivityRobot.Eyes()

    @Before
    fun startActivity() {
        startActivity(Intent())
    }

    @Test
    fun testOnServiceSuccess_itemsCount() {
        eyes.seesNumberOfItems()
    }

    @Test
    fun testItemDetails_verifyRow() {
        eyes.seesSchoolName()
            .seesSchoolAddress()
            .seesSchoolWebsite()
    }
}