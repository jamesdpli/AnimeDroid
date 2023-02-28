package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.animedroid.data.AnimePagingSource
import com.example.animedroid.data.AnimeRepository
import javax.inject.Inject

class AnimeListFragmentViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    val pagedAnimeList = Pager(
        PagingConfig(pageSize = 20)
    ) {
        AnimePagingSource(repository)
    }
        .liveData
        .cachedIn(viewModelScope)
}