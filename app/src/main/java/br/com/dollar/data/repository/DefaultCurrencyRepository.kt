package br.com.dollar.data.repository

import br.com.dollar.data.client.ApiClient
import br.com.dollar.domain.boundary.CurrencyRepository
import br.com.dollar.domain.entity.currency.CurrencyList

class DefaultCurrencyRepository constructor(
    private val apiClient: ApiClient
) : CurrencyRepository {

    override suspend fun getCurrencyList(): CurrencyList? {
        return apiClient.getCurrencyList()?.toDomainObject()
    }
}