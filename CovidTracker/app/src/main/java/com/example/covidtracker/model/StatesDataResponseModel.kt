package com.example.covidtracker.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StatesDataResponseModel(

	@field:SerializedName("date")
	val date: Int? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("positive")
	val positive: Int? = null,

	@field:SerializedName("probableCases")
	val probableCases: Any? = null,

	@field:SerializedName("negative")
	val negative: Int? = null,

	@field:SerializedName("pending")
	val pending: Any? = null,

	@field:SerializedName("totalTestResultsSource")
	val totalTestResultsSource: String? = null,

	@field:SerializedName("totalTestResults")
	val totalTestResults: Int? = null,

	@field:SerializedName("hospitalizedCurrently")
	val hospitalizedCurrently: Int? = null,

	@field:SerializedName("hospitalizedCumulative")
	val hospitalizedCumulative: Any? = null,

	@field:SerializedName("inIcuCurrently")
	val inIcuCurrently: Int? = null,

	@field:SerializedName("inIcuCumulative")
	val inIcuCumulative: Any? = null,

	@field:SerializedName("onVentilatorCurrently")
	val onVentilatorCurrently: Any? = null,

	@field:SerializedName("onVentilatorCumulative")
	val onVentilatorCumulative: Any? = null,

	@field:SerializedName("recovered")
	val recovered: Any? = null,

	@field:SerializedName("dataQualityGrade")
	val dataQualityGrade: String? = null,

	@field:SerializedName("lastUpdateEt")
	val lastUpdateEt: String? = null,

	@field:SerializedName("dateModified")
	val dateModified: String? = null,

	@field:SerializedName("checkTimeEt")
	val checkTimeEt: String? = null,

	@field:SerializedName("death")
	val death: Int? = null,

	@field:SerializedName("hospitalized")
	val hospitalized: Any? = null,

	@field:SerializedName("dateChecked")
	val dateChecked: String? = null,

	@field:SerializedName("totalTestsViral")
	val totalTestsViral: Int? = null,

	@field:SerializedName("positiveTestsViral")
	val positiveTestsViral: Any? = null,

	@field:SerializedName("negativeTestsViral")
	val negativeTestsViral: Any? = null,

	@field:SerializedName("positiveCasesViral")
	val positiveCasesViral: Int? = null,

	@field:SerializedName("deathConfirmed")
	val deathConfirmed: Any? = null,

	@field:SerializedName("deathProbable")
	val deathProbable: Any? = null,

	@field:SerializedName("totalTestEncountersViral")
	val totalTestEncountersViral: Any? = null,

	@field:SerializedName("totalTestsPeopleViral")
	val totalTestsPeopleViral: Any? = null,

	@field:SerializedName("totalTestsAntibody")
	val totalTestsAntibody: Any? = null,

	@field:SerializedName("positiveTestsAntibody")
	val positiveTestsAntibody: Any? = null,

	@field:SerializedName("negativeTestsAntibody")
	val negativeTestsAntibody: Any? = null,

	@field:SerializedName("totalTestsPeopleAntibody")
	val totalTestsPeopleAntibody: Any? = null,

	@field:SerializedName("positiveTestsPeopleAntibody")
	val positiveTestsPeopleAntibody: Any? = null,

	@field:SerializedName("negativeTestsPeopleAntibody")
	val negativeTestsPeopleAntibody: Any? = null,

	@field:SerializedName("totalTestsPeopleAntigen")
	val totalTestsPeopleAntigen: Any? = null,

	@field:SerializedName("positiveTestsPeopleAntigen")
	val positiveTestsPeopleAntigen: Any? = null,

	@field:SerializedName("totalTestsAntigen")
	val totalTestsAntigen: Any? = null,

	@field:SerializedName("positiveTestsAntigen")
	val positiveTestsAntigen: Any? = null,

	@field:SerializedName("fips")
	val fips: String? = null,

	@field:SerializedName("positiveIncrease")
	val positiveIncrease: Int? = null,

	@field:SerializedName("negativeIncrease")
	val negativeIncrease: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("totalTestResultsIncrease")
	val totalTestResultsIncrease: Int? = null,

	@field:SerializedName("posNeg")
	val posNeg: Int? = null,

	@field:SerializedName("deathIncrease")
	val deathIncrease: Int? = null,

	@field:SerializedName("hospitalizedIncrease")
	val hospitalizedIncrease: Int? = null,

	@field:SerializedName("hash")
	val hash: String? = null,

	@field:SerializedName("commercialScore")
	val commercialScore: Int? = null,

	@field:SerializedName("negativeRegularScore")
	val negativeRegularScore: Int? = null,

	@field:SerializedName("negativeScore")
	val negativeScore: Int? = null,

	@field:SerializedName("positiveScore")
	val positiveScore: Int? = null,

	@field:SerializedName("score")
	val score: Int? = null,

	@field:SerializedName("grade")
	val grade: String? = null
)