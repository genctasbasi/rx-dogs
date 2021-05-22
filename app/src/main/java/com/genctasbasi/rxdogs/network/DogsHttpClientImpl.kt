package com.genctasbasi.rxdogs.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient

class DogsHttpClientImpl(private val interceptor: Interceptor) : OkHttpClient() {

    override fun interceptors(): MutableList<Interceptor> {
        return mutableListOf(interceptor)
    }
}