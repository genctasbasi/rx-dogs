package com.genctasbasi.rxdogs

import android.app.Application
import com.genctasbasi.rxdogs.di.appModule
import com.genctasbasi.rxdogs.di.dataModule
import com.genctasbasi.rxdogs.di.viewModelModule
import org.koin.core.context.startKoin

class RxDogsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoinDI()
    }

    private fun initKoinDI() {
        startKoin {
            applicationContext
            modules(
                listOf(
                    viewModelModule,
                    appModule,
                    dataModule
                )
            )
        }
    }
}