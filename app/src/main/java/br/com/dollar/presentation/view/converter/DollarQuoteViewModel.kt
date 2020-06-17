package br.com.dollar.presentation.view.converter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.dollar.domain.entity.currency.Conversion
import br.com.dollar.domain.entity.quote.CurrentQuotes
import br.com.dollar.domain.interactor.GetCurrentQuotes
import br.com.dollar.domain.interactor.PerformConversion
import br.com.dollar.domain.util.form.ConversionForm
import br.com.dollar.domain.util.resource.Strings
import br.com.dollar.presentation.util.base.BaseViewModel
import br.com.dollar.presentation.util.dialog.DialogData

class DollarQuoteViewModel constructor(
    private val getCurrentQuotes: GetCurrentQuotes,
    private val performConversion: PerformConversion,
    private val strings: Strings
) : BaseViewModel() {

    val conversion: LiveData<Conversion> get() = _conversion

    private val _conversion by lazy { MutableLiveData<Conversion>() }

    private var currentQuotes: CurrentQuotes? = null
    val conversionForm = ConversionForm()

    init {
        getCurrentQuotes()
    }

    fun performConversion() {
        if (currentQuotes == null) getCurrentQuotes()
        else {
            when {
                conversionForm.isCurrenciesEmpty() -> showEmptyCurrenciesDialog()
                conversionForm.isValueEmpty() -> showEmptyValueDialog()
                else -> {
                    currentQuotes?.let {
                        val convertedValue = performConversion.execute(conversionForm, it)
                        sendConversionResult(convertedValue)
                    }
                }
            }
        }
    }

    fun setConversionValue(conversionValue: String) {
        conversionForm.conversionValue = conversionValue.toDoubleOrNull()
    }

    private fun getCurrentQuotes() {
        launchDataLoad(onFailure = ::onFailure) {
            val currentQuotes = getCurrentQuotes.execute()
            if (currentQuotes?.success == false)
                showCurrentQuotesErrorDialog()
            else
                this.currentQuotes = currentQuotes
        }
    }

    private fun sendConversionResult(convertedValue: Double?) {
        if (convertedValue == null) {
            showConversionErrorDialog()
        } else {
            _conversion.value = Conversion(
                conversionForm.originCurrency,
                conversionForm.destinationCurrency,
                convertedValue
            )
        }
    }

    private fun showEmptyCurrenciesDialog() {
        setDialog(
            DialogData.confirm(
                strings.emptyFieldsErrorTitle,
                strings.emptyCurrenciesError,
                { /* Do Nothing */ },
                strings.globalOk,
                true
            )
        )
    }

    private fun showEmptyValueDialog() {
        setDialog(
            DialogData.confirm(
                strings.errorTitle,
                strings.emptyValueError,
                { /* Do Nothing */ },
                strings.globalOk,
                true
            )
        )
    }

    private fun showConversionErrorDialog() {
        setDialog(
            DialogData.confirm(
                strings.errorTitle,
                strings.conversionError,
                { /* Do Nothing */ },
                strings.globalOk,
                true
            )
        )
    }

    private fun showCurrentQuotesErrorDialog() {
        setDialog(
            DialogData.confirm(
                strings.errorTitle,
                strings.currentQuotesError,
                { /* Do Nothing */ },
                strings.globalOk,
                true
            )
        )
    }

    private fun onFailure(throwable: Throwable) {
        setDialog(throwable, ::getCurrentQuotes)
    }
}