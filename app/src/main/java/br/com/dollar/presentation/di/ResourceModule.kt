package br.com.dollar.presentation.di

import br.com.dollar.domain.util.resource.Strings
import br.com.dollar.presentation.util.error.ErrorHandler
import org.koin.dsl.module

fun resourceModule() = module {

    single {
        Strings(get())
    }

    single {
        ErrorHandler(get())
    }
}