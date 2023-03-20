package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.animedroid.data.AnimePagingSource
import com.example.animedroid.data.AnimeRepository
import javax.inject.Inject

class AnimeListFragmentViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

        val pagedAnimeData =  Pager(
            PagingConfig(pageSize = 20)
        ) {
            AnimePagingSource(repository)
        }
            .liveData
            .cachedIn(viewModelScope)

}