package com.genctasbasi.rxdogs.data

import com.genctasbasi.rxdogs.network.DogsApi

class DogsRepoImpl(private val dogsApi: DogsApi) : DogsRepo {
    override suspend fun getNextDog(): List<DogApiResponse> {
        return dogsApi.getNextDogImage()
    }
}