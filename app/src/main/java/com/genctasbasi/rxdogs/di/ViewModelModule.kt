package com.genctasbasi.rxdogs.di

import com.genctasbasi.rxdogs.presentation.viewModels.DetailsViewModel
import com.genctasbasi.rxdogs.presentation.viewModels.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { DetailsViewModel(get()) }
    single { MainViewModel() }
}