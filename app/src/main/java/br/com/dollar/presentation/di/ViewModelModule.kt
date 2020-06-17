package br.com.dollar.presentation.di

import br.com.dollar.presentation.view.converter.DollarQuoteViewModel
import br.com.dollar.presentation.view.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        DollarQuoteViewModel(get(), get(), get())
    }

    viewModel { SplashViewModel() }
}