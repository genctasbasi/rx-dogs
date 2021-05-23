package com.genctasbasi.rxdogs.network

import com.genctasbasi.rxdogs.data.DogApiResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.thedogapi.com/v1/images/"
const val SEARCH_END_POINT = "search"

interface DogsApi {

    @GET(SEARCH_END_POINT)
    suspend fun getNextDogImage(
        @Query("limit") limit: Int = 1
    ): List<DogApiResponse>


    @GET(SEARCH_END_POINT)
    fun rxGetNextDogImage(
        @Query("limit") limit: Int = 1
    ): Single<List<DogApiResponse>>
}