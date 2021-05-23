package com.genctasbasi.rxdogs.data

import com.genctasbasi.rxdogs.network.DogsApi
import io.reactivex.rxjava3.core.Single

class DogsRepoImpl(private val dogsApi: DogsApi) : DogsRepo {
    override suspend fun getNextDog(limit: Int): List<DogApiResponse> {
        return dogsApi.getNextDogImage(limit)
    }

    override fun rxGetNextDog(limit: Int): Single<List<DogApiResponse>> {
        return dogsApi.rxGetNextDogImage(limit)
    }
}