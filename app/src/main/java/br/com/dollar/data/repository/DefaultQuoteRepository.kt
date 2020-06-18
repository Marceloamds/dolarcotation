package br.com.dollar.data.repository

import br.com.dollar.data.client.ApiClient

class DefaultQuoteRepository constructor(
    private val apiClient: ApiClient
)