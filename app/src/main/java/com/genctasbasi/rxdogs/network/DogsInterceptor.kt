package com.genctasbasi.rxdogs.network

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY = "x-api-key"
private const val API_KEY_VALUE = "b690a1af-b37d-4277-87e1-98446176a775"

class DogsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader(API_KEY, API_KEY_VALUE)
        return chain.proceed(requestBuilder.build())
    }
}