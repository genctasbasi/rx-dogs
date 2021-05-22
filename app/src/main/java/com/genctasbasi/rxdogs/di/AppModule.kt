package com.genctasbasi.rxdogs.di

import com.genctasbasi.rxdogs.navigation.NavigationManager
import com.genctasbasi.rxdogs.navigation.NavigationManagerImpl
import org.koin.dsl.module

val appModule = module {
    single<NavigationManager> { NavigationManagerImpl() }
}