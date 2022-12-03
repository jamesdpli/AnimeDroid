package com.example.animedroid.data

import com.example.animedroid.utils.Constant
import com.example.animedroid.data.responses.AnimeListResponse
import com.example.animedroid.data.responses.AnimeResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private val retrofit = Retrofit.Builder()
    .baseUrl(Constant.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface AnimeService {
    @GET("anime?page%5Blimit%5D=20")
    suspend fun getAnimes(): Response<AnimeListResponse>

    @GET("anime/{animeId}")
    suspend fun getAnimeById(@Path("animeId") animeId: String): Response<AnimeResponse>
}

object AnimeApi {
    val animeService: AnimeService by lazy {
        retrofit.create(AnimeService::class.java)
    }
}
