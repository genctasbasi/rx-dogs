package com.genctasbasi.rxdogs.di

import com.genctasbasi.rxdogs.presentation.viewModels.SingleObserverViewModel
import com.genctasbasi.rxdogs.presentation.viewModels.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { SingleObserverViewModel(get()) }
    single { MainViewModel() }
}