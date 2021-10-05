package com.explained.nycschools.views

import android.content.Intent
import androidx.test.runner.AndroidJUnit4
import com.explained.nycschools.robots.SchoolDetailsActivityRobot
import com.explained.nycschools.util.ServiceUtil
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SchoolDetailsActivityTest :
    EspressoBaseTest<SchoolDetailsActivity>(SchoolDetailsActivity::class.java) {

    val eyes: SchoolDetailsActivityRobot.Eyes = SchoolDetailsActivityRobot.Eyes()

    @Before
    fun startActivity() {
        var intent = Intent()
        intent.putExtra(SchoolDetailsActivity.SCHOOL_INFO, ServiceUtil.createSchoolInfo())
        startActivity(intent)
    }

    @Test
    fun testSchoolDetails() {
        eyes.seesSatMathScore()
            .seesSatTakers()
            .seesSatReadingScore()
            .seesSatWritingScore()
            .seesSchoolName()
            .seesSchoolEmail()
            .seesSchoolAddress()
            .seesSchoolWebsite()

    }
}