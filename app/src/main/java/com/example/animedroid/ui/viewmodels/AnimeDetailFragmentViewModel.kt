package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedroid.data.AnimeRepository
import com.example.animedroid.data.responses.NetworkAnime
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimeDetailFragmentViewModel @Inject constructor(private val repository: AnimeRepository) :
    ViewModel() {

    private val _animeDetailLiveData = MutableLiveData<NetworkAnime>()
    val animeDetailLiveData: LiveData<NetworkAnime> = _animeDetailLiveData

    fun getAnimeById(animeId: String) {
        viewModelScope.launch {
            val response = repository.getAnimeById(animeId).body()
            _animeDetailLiveData.postValue(response!!)
        }
    }
}