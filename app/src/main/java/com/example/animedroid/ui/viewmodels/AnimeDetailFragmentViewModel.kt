package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedroid.data.AnimesRepository
import com.example.animedroid.data.responses.Data
import kotlinx.coroutines.launch

class AnimeDetailFragmentViewModel : ViewModel() {

    private val repository = AnimesRepository()

    private val _animeDetailLiveData = MutableLiveData<Data>()
    val animeDetailLiveData: LiveData<Data> = _animeDetailLiveData

    fun getAnimeById(animeId: String) {
        viewModelScope.launch {
            val response = repository.getAnimeById(animeId).body()
            _animeDetailLiveData.postValue(response!!)
        }
    }
}
