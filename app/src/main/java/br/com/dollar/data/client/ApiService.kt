package br.com.dollar.data.client

import br.com.dollar.data.entity.ApiCurrencyList
import br.com.dollar.data.entity.ApiCurrentQuotes
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getCurrencyList(): Response<ApiCurrencyList>

    @GET("live")
    suspend fun getCurrentQuotes(): Response<ApiCurrentQuotes>
}