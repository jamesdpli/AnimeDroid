package com.example.animedroid.data

import com.example.animedroid.data.response.NetworkAnime
import com.example.animedroid.data.response.NetworkAnimeList
import retrofit2.Response
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApi: AnimeService) {

    suspend fun getAnimes(): Response<NetworkAnimeList> {
        return animeApi.getAnimes()
    }

    suspend fun getAnimeById(animeId: String): Response<NetworkAnime> {
        return animeApi.getAnimeById(animeId)
    }
}