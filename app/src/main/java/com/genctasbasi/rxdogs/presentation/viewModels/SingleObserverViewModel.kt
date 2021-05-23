package com.genctasbasi.rxdogs.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genctasbasi.rxdogs.data.DogApiResponse
import com.genctasbasi.rxdogs.data.DogsRepo
import com.genctasbasi.rxdogs.utils.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SingleObserverViewModel(private val dogsRepo: DogsRepo) : ViewModel() {

    private val _dogsLive = SingleLiveEvent<List<DogApiResponse>>()
    val dogsLive: LiveData<List<DogApiResponse>> = _dogsLive

    fun onShowAnotherClick() {

        // we have two options here, for the sake of this demo.
        // enable one and observe how it works (yes, pun intended)
        // option 1: use coroutines
        // coroutineWay()

        // option 2: use rxAndroid
        rxAndroidWay()
    }

    private fun rxAndroidWay() {
        val observable = dogsRepo.rxGetNextDog(1)
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)
    }

    private val subscriber = object : SingleObserver<List<DogApiResponse>> {
        override fun onSubscribe(d: Disposable?) {}

        override fun onSuccess(dogs: List<DogApiResponse>?) {
            _dogsLive.value = dogs ?: emptyList()
        }

        override fun onError(e: Throwable?) {
            _dogsLive.value = emptyList()
        }
    }

    private fun coroutineWay() {
        viewModelScope.launch(Dispatchers.IO) {
            val dogs = dogsRepo.getNextDog(1)

            withContext(Dispatchers.Main) {
                _dogsLive.value = dogs
            }
        }
    }
}