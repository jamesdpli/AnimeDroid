package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedroid.data.AnimeRepository
import com.example.animedroid.data.response.NetworkAnimeList
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimeListFragmentViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    private val _animeLiveData = MutableLiveData<NetworkAnimeList>()
    val animeLiveData: LiveData<NetworkAnimeList> = _animeLiveData

    fun getAnimes() {
        viewModelScope.launch {
            val response = repository.getAnimes().body()
            _animeLiveData.postValue(response!!)
        }
    }
}