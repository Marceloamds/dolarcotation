package br.com.dollar.data.repository

import br.com.dollar.data.client.ApiClient
import br.com.dollar.domain.boundary.QuoteRepository
import br.com.dollar.domain.entity.quote.CurrentQuotes

class DefaultQuoteRepository constructor(
    private val apiClient: ApiClient
) : QuoteRepository {

    override suspend fun getCurrentQuotes(): CurrentQuotes? {
        return apiClient.getCurrentQuotes()?.toDomainObject()
    }
}