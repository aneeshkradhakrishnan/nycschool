package com.explained.nycschools.models

import com.google.gson.annotations.SerializedName

data class SatResult(
    @SerializedName("dbn")
    val dbn: String,

    @SerializedName("school_name")
    val schoolName: String,

    @SerializedName("num_of_sat_test_takers")
    val numOfSatTestTakers: String,

    @SerializedName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String,

    @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String,

    @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String,
)

/***
{
"dbn": "31R080",
"school_name": "THE MICHAEL J. PETRIDES SCHOOL",
"num_of_sat_test_takers": "107",
"sat_critical_reading_avg_score": "472",
"sat_math_avg_score": "488",
"sat_writing_avg_score": "466"
}
 **/

