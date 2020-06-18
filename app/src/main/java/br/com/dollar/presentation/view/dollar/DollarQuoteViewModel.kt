package br.com.dollar.presentation.view.dollar

import android.content.Context
import br.com.dollar.R
import br.com.dollar.presentation.util.base.BaseViewModel
import br.com.dollar.presentation.util.dialog.DialogData

class DollarQuoteViewModel constructor(
    private val context: Context
) : BaseViewModel() {

    private fun showCurrentQuotesErrorDialog() {
        setDialog(
            DialogData.confirm(
                context.getString(R.string.error_title),
                context.getString(R.string.current_quotes_error),
                { /* Do Nothing */ },
                context.getString(R.string.global_ok),
                true
            )
        )
    }

    private fun onFailure(throwable: Throwable) {
        setDialog(throwable)
    }
}