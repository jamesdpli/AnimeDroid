package com.example.animedroid.data

import com.example.animedroid.data.response.AnimeResponse
import retrofit2.Response

class AnimesRepository(
    private val remoteAnimesDataSource: RemoteAnimesDataSource
) {

    suspend fun getAnimes(): Response<AnimeResponse> {
        return remoteAnimesDataSource.getAnimes()
    }

}