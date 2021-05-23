package com.genctasbasi.rxdogs.data

import io.reactivex.rxjava3.core.Single

interface DogsRepo {
    suspend fun getNextDog(limit: Int): List<DogApiResponse>
    fun rxGetNextDog(limit: Int): Single<List<DogApiResponse>>
}