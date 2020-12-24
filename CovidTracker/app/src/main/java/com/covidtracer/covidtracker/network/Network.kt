package com.covidtracer.covidtracker.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {

        private val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getInstance(): Retrofit {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.covidtracking.com/")
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}