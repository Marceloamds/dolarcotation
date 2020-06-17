package br.com.dollar.data.client

import br.com.dollar.data.entity.ApiCurrencyList
import br.com.dollar.data.entity.ApiCurrentQuotes
import br.com.dollar.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getCurrencyList(): ApiCurrencyList? {
        return makeRequest(apiService.getCurrencyList())
    }

    suspend fun getCurrentQuotes(): ApiCurrentQuotes? {
        return makeRequest(apiService.getCurrentQuotes())
    }
}