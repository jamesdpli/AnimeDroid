package com.example.animedroid.data

import com.example.animedroid.data.responses.AnimeListResponse
import com.example.animedroid.data.responses.AnimeResponse
import retrofit2.Response

class AnimesRepository {

    private val animeApi = AnimeApi.animeService

    suspend fun getAnimes(): Response<AnimeListResponse> {
        return animeApi.getAnimes()
    }

    suspend fun getAnimeById(animeId: String): Response<AnimeResponse> {
        return animeApi.getAnimeById(animeId)
    }
}
