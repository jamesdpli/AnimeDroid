package com.example.animedroid.data

import com.example.animedroid.data.responses.AnimeResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL: String = "https://kitsu.io/api/edge/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface AnimeService {
    @GET("anime?page%5Blimit%5D=20")
    suspend fun getAnimes(): Response<AnimeResponse>
}

object AnimeApi {
    val animeService: AnimeService by lazy {
        retrofit.create(AnimeService::class.java)
    }
}
