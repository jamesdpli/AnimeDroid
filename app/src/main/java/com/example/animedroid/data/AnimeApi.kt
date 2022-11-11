package com.example.animedroid.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL: String = "https://kitsu.io/api/edge/"

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object AnimeApi {
    val animeService = retrofit.create(AnimeService::class.java)
}