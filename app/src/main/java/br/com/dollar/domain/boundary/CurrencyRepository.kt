package br.com.dollar.domain.boundary

import br.com.dollar.domain.entity.currency.CurrencyList


interface CurrencyRepository {

    suspend fun getCurrencyList(): CurrencyList?
}