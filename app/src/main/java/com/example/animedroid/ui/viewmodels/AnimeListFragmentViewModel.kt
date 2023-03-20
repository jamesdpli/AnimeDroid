package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.animedroid.data.AnimePagingSource
import com.example.animedroid.data.AnimeRepository
import com.example.animedroid.data.responses.NetworkAnimeList
import kotlinx.coroutines.delay
import javax.inject.Inject

class AnimeListFragmentViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    fun getPagedAnimeData(): LiveData<PagingData<NetworkAnimeList.Data>> {
        return Pager(
            PagingConfig(pageSize = 20)
        ) {
            AnimePagingSource(repository)
        }
            .liveData
            .cachedIn(viewModelScope)
    }
}