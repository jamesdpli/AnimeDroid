package com.example.animedroid.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedroid.data.AnimesRepository
import com.example.animedroid.data.responses.AnimeListResponse
import kotlinx.coroutines.launch

class AnimeListFragmentViewModel : ViewModel() {

    private val repository = AnimesRepository()

    private val _animeLiveData = MutableLiveData<AnimeListResponse>()
    val animeLiveData: LiveData<AnimeListResponse> = _animeLiveData

    fun getAnimes() {
        viewModelScope.launch {
            val response = repository.getAnimes().body()
            _animeLiveData.postValue(response!!)
        }
    }
}
