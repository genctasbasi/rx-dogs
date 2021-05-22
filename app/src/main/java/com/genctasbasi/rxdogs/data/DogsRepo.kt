package com.genctasbasi.rxdogs.data

interface DogsRepo {
    suspend fun getNextDog(): List<DogApiResponse>
}