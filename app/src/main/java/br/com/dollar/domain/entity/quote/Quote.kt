package br.com.dollar.domain.entity.quote

data class Quote(
    val currencyCode: String,
    val convertedValue: Double
)