package br.com.dollar.presentation.di

import br.com.dollar.data.repository.DefaultQuoteRepository
import br.com.dollar.domain.boundary.QuoteRepository
import org.koin.dsl.module

fun repositoryModule() = module {

    single {
        DefaultQuoteRepository(get()) as QuoteRepository
    }
}