package br.com.dollar.presentation.view.dollar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.dollar.domain.entity.quote.CurrentQuotes
import br.com.dollar.domain.interactor.GetCurrentQuotes
import br.com.dollar.domain.util.resource.Strings
import br.com.dollar.presentation.util.base.BaseViewModel
import br.com.dollar.presentation.util.dialog.DialogData

class DollarQuoteViewModel constructor(
    private val getCurrentQuotes: GetCurrentQuotes,
    private val strings: Strings
) : BaseViewModel() {

    val convertedValue: LiveData<Double> get() = _convertedValue

    private val _convertedValue by lazy { MutableLiveData<Double>() }

    private var conversionValue: Double? = null

    fun getCurrentQuotes() {
        launchDataLoad(onFailure = ::onFailure) {
            val currentQuotes = getCurrentQuotes.execute()
            if (currentQuotes?.success == false) showCurrentQuotesErrorDialog()
            else _convertedValue.value = currentQuotes?.convertBrl(conversionValue ?: 1.0)
        }
    }

    fun setConversionValue(conversionValue: String) {
        this.conversionValue = conversionValue.toDoubleOrNull()
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