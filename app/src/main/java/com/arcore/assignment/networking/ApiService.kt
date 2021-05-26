package com.arcore.assignment.networking

import com.arcore.assignment.models.JokeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("random")
    fun getJoke(): Call<JokeResponse>
}