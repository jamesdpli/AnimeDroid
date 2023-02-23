package com.example.animedroid.data

import com.example.animedroid.data.response.NetworkAnime
import com.example.animedroid.data.response.NetworkAnimeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeService {
    @GET("anime?page%5Blimit%5D=20")
    suspend fun getAnimes(): Response<NetworkAnimeList>

    @GET("anime/{animeId}")
    suspend fun getAnimeById(@Path("animeId") animeId: String): Response<NetworkAnime>
}