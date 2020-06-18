package br.com.dollar.presentation.view.dollar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.dollar.R
import br.com.dollar.databinding.ActivityConverterBinding
import br.com.dollar.presentation.util.base.BaseActivity
import br.com.dollar.presentation.util.base.BaseViewModel
import br.com.dollar.presentation.util.constants.TWO_DECIMAL_NUMBER
import br.com.dollar.presentation.util.extension.observe
import br.com.dollar.presentation.util.extension.onTextChanges
import br.com.dollar.presentation.util.extension.setSafeClickListener
import org.koin.android.viewmodel.ext.android.viewModel

class DollarQuoteActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: DollarQuoteViewModel by viewModel()

    private lateinit var binding: ActivityConverterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_converter)
        setupUi()
    }

    override fun subscribeUi() {
        super.subscribeUi()
        _viewModel.placeholder.observe(this) { binding.placeholderView.setPlaceholder(it) }
        _viewModel.convertedValue.observe(this, ::onConversionReceived)
    }

    private fun setupUi() {
        with(binding) {
            textInputConversionValue.onTextChanges(_viewModel::setConversionValue)
            buttonConvert.setSafeClickListener { _viewModel.getCurrentQuotes() }
        }
    }

    private fun onConversionReceived(convertedValue: Double?) {
        convertedValue?.let {
            binding.textViewConvertedValue.text = String.format(TWO_DECIMAL_NUMBER, it)
        }
    }

    companion object {
        fun createIntent(context: Context) =
            Intent(context, DollarQuoteActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
    }
}