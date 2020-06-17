package br.com.dollar.domain.boundary

import br.com.dollar.domain.entity.quote.CurrentQuotes

interface QuoteRepository {

    suspend fun getCurrentQuotes(): CurrentQuotes?
}