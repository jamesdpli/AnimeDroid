package com.example.animedroid.data

import com.example.animedroid.data.response.AnimeResponse
import retrofit2.Response

class AnimesRepository {

    private val animeApi = AnimeApi.animeService

    suspend fun getAnimes(): Response<AnimeResponse> {
        return animeApi.getAnimes()
    }
}
