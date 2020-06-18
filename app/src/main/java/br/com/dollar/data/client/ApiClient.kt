package br.com.dollar.data.client

import br.com.dollar.data.entity.ApiCurrentQuotes
import br.com.dollar.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getCurrentQuotes(): ApiCurrentQuotes? {
        return makeRequest(apiService.getCurrentQuotes())
    }
}