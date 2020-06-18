package br.com.dollar.domain.entity.quote

data class CurrentQuotes(
    val success: Boolean,
    val quotes: List<Quote>
) {

    fun convertBrl(conversionValue: Double): Double? {
        val realQuote = quotes.find { it.currencyCode == "BRL" }
        return realQuote?.convertedValue?.let {
            it * conversionValue
        }
    }
}