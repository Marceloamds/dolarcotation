package br.com.dollar.domain.interactor

import br.com.dollar.domain.boundary.CurrencyRepository

class GetCurrencyList constructor(
    private val currencyRepository: CurrencyRepository
) {

    suspend fun execute() = currencyRepository.getCurrencyList()
}