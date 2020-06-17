package br.com.dollar.presentation.di

import br.com.dollar.data.repository.DefaultCurrencyRepository
import br.com.dollar.data.repository.DefaultQuoteRepository
import br.com.dollar.domain.boundary.CurrencyRepository
import br.com.dollar.domain.boundary.QuoteRepository
import org.koin.dsl.module

fun repositoryModule() = module {
    single {
        DefaultCurrencyRepository(get()) as CurrencyRepository
    }

    single {
        DefaultQuoteRepository(get()) as QuoteRepository
    }
}