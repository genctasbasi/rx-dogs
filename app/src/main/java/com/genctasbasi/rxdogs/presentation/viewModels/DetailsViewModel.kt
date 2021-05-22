package com.genctasbasi.rxdogs.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genctasbasi.rxdogs.data.DogApiResponse
import com.genctasbasi.rxdogs.data.DogsRepo
import com.genctasbasi.rxdogs.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(private val dogsRepo: DogsRepo) : ViewModel() {

    private val _dogsLive = SingleLiveEvent<List<DogApiResponse>>()
    val dogsLive: LiveData<List<DogApiResponse>> = _dogsLive

    fun onShowAnotherClick() {

        viewModelScope.launch(Dispatchers.IO) {
            val dogs = dogsRepo.getNextDog()

            withContext(Dispatchers.Main) {
                _dogsLive.value = dogs
            }
        }
    }
}