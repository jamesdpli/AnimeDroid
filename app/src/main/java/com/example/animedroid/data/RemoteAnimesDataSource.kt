package com.example.animedroid.data

import com.example.animedroid.data.response.AnimeResponse
import retrofit2.Response

class RemoteAnimesDataSource(
    private val animeApi: AnimeApi
) {

    suspend fun getAnimes(): Response<AnimeResponse> {
        return animeApi.animeService.getAnimes()
    }

}