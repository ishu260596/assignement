package com.arcore.assignment.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetwork {
    companion object {
        private val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        fun getInstance(): Retrofit {
            val retrofitBuilder = Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/jokes/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())

            return retrofitBuilder.build()

        }
    }
}