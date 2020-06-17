package br.com.dollar.presentation.di

import br.com.dollar.domain.interactor.GetCurrencyList
import br.com.dollar.domain.interactor.GetCurrentQuotes
import br.com.dollar.domain.interactor.PerformConversion
import org.koin.dsl.module

fun interactorModule() = module {
    single {
        GetCurrencyList(get())
    }

    single {
        GetCurrentQuotes(get())
    }

    single {
        PerformConversion()
    }
}