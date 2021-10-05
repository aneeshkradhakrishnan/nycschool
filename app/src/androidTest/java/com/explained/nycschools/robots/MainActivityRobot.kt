package com.explained.nycschools.robots

import com.explained.nycschools.R
import com.explained.nycschools.util.EspressoUtil

interface MainActivityRobot {

    class Eyes {

        fun seesNumberOfItems(): Eyes {
            EspressoUtil.seesRecyclerViewItems(R.id.schoolView, 1)
            return this
        }

        fun seesSchoolName(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.schoolView, 0, "Clinton School Writers & Artists, M.S. 260")
            return this
        }

        fun seesSchoolAddress(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.schoolView, 0, "10 East 15th Street")
            return this
        }

        fun seesSchoolWebsite(): Eyes {
            EspressoUtil.seesRecyclerViewIndexWithText(R.id.schoolView, 0, "www.theclintonschool.net")
            return this
        }
    }
}
