package br.com.dollar.domain.interactor

import br.com.dollar.domain.boundary.QuoteRepository

class GetCurrentQuotes constructor(
    private val quoteRepository: QuoteRepository
) {

    suspend fun execute() = quoteRepository.getCurrentQuotes()
}