package br.com.dollar.domain.util.form

import br.com.dollar.domain.entity.currency.Currency

class ConversionForm {

    var originCurrency: Currency? = null
    var destinationCurrency: Currency? = null
    var conversionValue: Double? = null

    fun isValueEmpty(): Boolean {
        return (conversionValue == null)
    }
}