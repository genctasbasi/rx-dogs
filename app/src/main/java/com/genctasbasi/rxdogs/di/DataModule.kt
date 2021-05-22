package com.genctasbasi.rxdogs.di

import com.genctasbasi.rxdogs.data.DogsRepo
import com.genctasbasi.rxdogs.data.DogsRepoImpl
import com.genctasbasi.rxdogs.network.BASE_URL
import com.genctasbasi.rxdogs.network.DogsApi
import com.genctasbasi.rxdogs.network.DogsHttpClientImpl
import com.genctasbasi.rxdogs.network.DogsInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<DogsApi> {
        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(DogsHttpClientImpl(get()))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        builder.create(DogsApi::class.java)
    }

    single<DogsRepo> { DogsRepoImpl(get()) }
    single<OkHttpClient> { DogsHttpClientImpl(get()) }
    single<Interceptor> { DogsInterceptor() }
}