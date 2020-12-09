package com.example.covidtracker.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StatesResponseModel(

	@field:SerializedName("date")
	val date: Int? = null,

	@field:SerializedName("totalTestResultsSource")
	val totalTestResultsSource: String? = null,

	@field:SerializedName("hospitalizedCurrently")
	val hospitalizedCurrently: Int? = null,

	@field:SerializedName("negativeScore")
	val negativeScore: Int? = null,

	@field:SerializedName("hospitalizedIncrease")
	val hospitalizedIncrease: Int? = null,

	@field:SerializedName("score")
	val score: Int? = null,

	@field:SerializedName("hospitalizedCumulative")
	val hospitalizedCumulative: Int? = null,

	@field:SerializedName("commercialScore")
	val commercialScore: Int? = null,

	@field:SerializedName("dataQualityGrade")
	val dataQualityGrade: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("fips")
	val fips: String? = null,

	@field:SerializedName("totalTestsViral")
	val totalTestsViral: Int? = null,

	@field:SerializedName("grade")
	val grade: String? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("death")
	val death: Int? = null,

	@field:SerializedName("totalTestResultsIncrease")
	val totalTestResultsIncrease: Int? = null,

	@field:SerializedName("lastUpdateEt")
	val lastUpdateEt: String? = null,

	@field:SerializedName("hospitalized")
	val hospitalized: Int? = null,

	@field:SerializedName("negative")
	val negative: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("positiveTestsViral")
	val positiveTestsViral: Int? = null,

	@field:SerializedName("deathConfirmed")
	val deathConfirmed: Int? = null,

	@field:SerializedName("positiveScore")
	val positiveScore: Int? = null,

	@field:SerializedName("positiveIncrease")
	val positiveIncrease: Int? = null,

	@field:SerializedName("negativeIncrease")
	val negativeIncrease: Int? = null,

	@field:SerializedName("deathIncrease")
	val deathIncrease: Int? = null,

	@field:SerializedName("totalTestResults")
	val totalTestResults: Int? = null,

	@field:SerializedName("negativeTestsViral")
	val negativeTestsViral: Int? = null,

	@field:SerializedName("checkTimeEt")
	val checkTimeEt: String? = null,

	@field:SerializedName("dateChecked")
	val dateChecked: String? = null,

	@field:SerializedName("negativeRegularScore")
	val negativeRegularScore: Int? = null,

	@field:SerializedName("onVentilatorCurrently")
	val onVentilatorCurrently: Int? = null,

	@field:SerializedName("dateModified")
	val dateModified: String? = null,

	@field:SerializedName("positive")
	val positive: Int? = null,

	@field:SerializedName("posNeg")
	val posNeg: Int? = null,

	@field:SerializedName("recovered")
	val recovered: Int? = null
)