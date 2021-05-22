package com.genctasbasi.rxdogs.network

import com.genctasbasi.rxdogs.data.DogApiResponse
import retrofit2.http.GET

const val BASE_URL = "https://api.thedogapi.com/v1/images/"
const val SEARCH_END_POINT = "search"

interface DogsApi {

    @GET(SEARCH_END_POINT)
    suspend fun getNextDogImage(): List<DogApiResponse>
}