package br.com.dollar.presentation.di

import br.com.dollar.domain.interactor.GetCurrentQuotes
import org.koin.dsl.module

fun interactorModule() = module {

    single {
        GetCurrentQuotes(get())
    }
}