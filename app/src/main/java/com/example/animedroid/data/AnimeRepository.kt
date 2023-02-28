package com.example.animedroid.data

import com.example.animedroid.data.responses.NetworkAnime
import com.example.animedroid.data.responses.NetworkAnimeList
import retrofit2.Response
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val animeApi: AnimeService) {

    suspend fun getAnimeById(animeId: String): Response<NetworkAnime> {
        return animeApi.getAnimeById(animeId)
    }

    suspend fun getPagedAnimeList(offset: Int): Response<NetworkAnimeList> {
        return animeApi.getPagedAnimeList(offset)
    }
}