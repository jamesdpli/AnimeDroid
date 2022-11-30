package com.example.animedroid.data

import com.example.animedroid.data.responses.AnimeResponse
import com.example.animedroid.data.responses.Data
import retrofit2.Response

class AnimesRepository {

    private val animeApi = AnimeApi.animeService

    suspend fun getAnimes(): Response<AnimeResponse> {
        return animeApi.getAnimes()
    }

    suspend fun getAnimeById(animeId: String): Response<Data> {
        return animeApi.getAnimeById(animeId)
    }

}
