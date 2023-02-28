package com.example.animedroid.data

import com.example.animedroid.data.responses.NetworkAnime
import com.example.animedroid.data.responses.NetworkAnimeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    @GET("anime/{animeId}")
    suspend fun getAnimeById(@Path("animeId") animeId: String): Response<NetworkAnime>

    @GET("anime")
    suspend fun getPagedAnimeList(@Query("page[offset]") offset: Int): Response<NetworkAnimeList>
}