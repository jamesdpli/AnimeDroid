package com.example.animedroid.data

import com.example.animedroid.data.responses.AnimeResponse
import com.example.animedroid.data.responses.Data
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL: String = "https://kitsu.io/api/edge/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface AnimeService {
    @GET("anime?page%5Blimit%5D=20")
    suspend fun getAnimes(): Response<AnimeResponse>

    @GET("anime/{animeId}")
    suspend fun getAnimeById(@Path("animeId") animeId: String) : Response<Data>
}

object AnimeApi {
    val animeService: AnimeService by lazy {
        retrofit.create(AnimeService::class.java)
    }
}
