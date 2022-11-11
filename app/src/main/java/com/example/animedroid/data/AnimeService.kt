package com.example.animedroid.data

import com.example.animedroid.data.response.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET

interface AnimeService {
    @GET("anime")
    suspend fun getAnimes() : Response<AnimeResponse>
}