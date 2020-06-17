package br.com.dollar.domain.entity.currency

data class CurrencyList(
    val success: Boolean,
    val currencies: List<Currency>
)