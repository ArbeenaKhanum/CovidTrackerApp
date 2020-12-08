package com.example.covidtracker.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StatesResponseModel(

	@field:SerializedName("covid19SiteQuinary")
	val covid19SiteQuinary: String? = null,

	@field:SerializedName("notes")
	val notes: String? = null,

	@field:SerializedName("covid19SiteSecondary")
	val covid19SiteSecondary: String? = null,

	@field:SerializedName("pui")
	val pui: String? = null,

	@field:SerializedName("covid19SiteOld")
	val covid19SiteOld: String? = null,

	@field:SerializedName("pum")
	val pum: Boolean? = null,

	@field:SerializedName("fips")
	val fips: String? = null,

	@field:SerializedName("covid19Site")
	val covid19Site: String? = null,

	@field:SerializedName("twitter")
	val twitter: String? = null,

	@field:SerializedName("covidTrackingProjectPreferredTotalTestUnits")
	val covidTrackingProjectPreferredTotalTestUnits: String? = null,

	@field:SerializedName("totalTestResultsField")
	val totalTestResultsField: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("covid19SiteTertiary")
	val covid19SiteTertiary: String? = null,

	@field:SerializedName("state")
	val state: String? = null,

	@field:SerializedName("covidTrackingProjectPreferredTotalTestField")
	val covidTrackingProjectPreferredTotalTestField: String? = null,

	@field:SerializedName("covid19SiteQuaternary")
	val covid19SiteQuaternary: String? = null
)