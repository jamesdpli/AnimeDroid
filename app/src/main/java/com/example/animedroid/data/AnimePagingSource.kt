package com.example.animedroid.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animedroid.data.responses.NetworkAnimeList
import javax.inject.Inject

class AnimePagingSource @Inject constructor(
    private val animeApi: AnimeRepository
) : PagingSource<Int, NetworkAnimeList.Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NetworkAnimeList.Data> {
        val nextPageNumber = params.key ?: 0
        val response = animeApi.getPagedAnimeList(nextPageNumber)

        return LoadResult.Page(
            data = response.body()!!.data,
            prevKey = null, // Only paging forward.
            nextKey = nextPageNumber + 10
        )
    }

    override fun getRefreshKey(state: PagingState<Int, NetworkAnimeList.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(10) ?: anchorPage?.nextKey?.minus(10)
        }
    }

}