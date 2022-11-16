package com.example.animedroid.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedroid.data.AnimesRepository
import com.example.animedroid.data.response.AnimeResponse
import kotlinx.coroutines.launch

class SharedAnimeViewModel : ViewModel() {

    private val repository = AnimesRepository()

    private val _animeLiveData = MutableLiveData<AnimeResponse>()
    val animeLiveData: LiveData<AnimeResponse> = _animeLiveData

    fun getAnimes() {
        viewModelScope.launch {
            val response = repository.getAnimes().body()
            _animeLiveData.postValue(response!!)
        }
    }
}
