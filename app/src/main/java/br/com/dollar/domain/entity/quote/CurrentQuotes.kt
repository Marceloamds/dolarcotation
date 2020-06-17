package br.com.dollar.domain.entity.quote

data class CurrentQuotes(
    val success: Boolean,
    val quotes: List<Quote>
)