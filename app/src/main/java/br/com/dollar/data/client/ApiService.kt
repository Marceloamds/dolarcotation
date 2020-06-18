package br.com.dollar.data.client

import br.com.dollar.data.entity.ApiCurrentQuotes
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("live")
    suspend fun getCurrentQuotes(): Response<ApiCurrentQuotes>
}