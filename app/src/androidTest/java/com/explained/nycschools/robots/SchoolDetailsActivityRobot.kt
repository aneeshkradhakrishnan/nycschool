package com.explained.nycschools.robots

import com.explained.nycschools.R
import com.explained.nycschools.util.EspressoUtil

interface SchoolDetailsActivityRobot {

    class Eyes {

        fun seesSchoolName(): Eyes {
            EspressoUtil.seesViewWithText(
                R.id.schoolName,
                "Clinton School Writers & Artists, M.S. 260"
            )
            return this
        }

        fun seesSchoolAddress(): Eyes {
            EspressoUtil.seesViewWithText(R.id.address, "10 East 15th Street")
            return this
        }

        fun seesSchoolWebsite(): Eyes {
            EspressoUtil.seesViewWithText(R.id.website, "www.theclintonschool.net")
            return this
        }

        fun seesSchoolEmail(): Eyes {
            EspressoUtil.seesViewWithText(R.id.contact, "admissions@theclintonschool.net")
            return this
        }

        fun seesSatTakers(): Eyes {
            EspressoUtil.seesViewWithText(R.id.satTakers, "107")
            return this
        }

        fun seesSatMathScore(): Eyes {
            EspressoUtil.seesViewWithText(R.id.satMathScore, "488")
            return this
        }

        fun seesSatReadingScore(): Eyes {
            EspressoUtil.seesViewWithText(R.id.satReadingScore, "472")
            return this
        }

        fun seesSatWritingScore(): Eyes {
            EspressoUtil.seesViewWithText(R.id.satWritingScore, "466")
            return this
        }
    }
}
