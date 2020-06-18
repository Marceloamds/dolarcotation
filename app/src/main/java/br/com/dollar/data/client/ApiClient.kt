package br.com.dollar.data.client

import br.com.dollar.data.util.request.RequestHandler

class ApiClient constructor(
    private val apiService: ApiService
) : RequestHandler()