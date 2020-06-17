package br.com.dollar.presentation.util.placeholder

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import br.com.dollar.R
import br.com.dollar.databinding.LoadingPlaceholderBinding
import br.com.dollar.presentation.util.placeholder.types.Loading

class PlaceholderView constructor(
    context: Context,
    attrs: AttributeSet
) : FrameLayout(context, attrs) {

    private lateinit var binding: LoadingPlaceholderBinding
    private val layoutInflater by lazy { LayoutInflater.from(context) }

    fun setPlaceholder(placeholder: Placeholder?) {
        placeholder?.let { _placeholder ->
            setBaseVariables(_placeholder)
            when (_placeholder) {
                is Loading -> configureLoadingPlaceholder(_placeholder)
            }
        }
    }

    init {
        loadBinding()
    }

    private fun loadBinding() {
        binding = LoadingPlaceholderBinding.inflate(layoutInflater, this, true)
    }

    private fun setBaseVariables(placeholder: Placeholder) {
        binding.run {
            visible = placeholder.visible
            buttonVisible = placeholder.buttonVisible
            messageVisible = placeholder.messageVisible
            progressVisible = placeholder.progressVisible
        }
    }

    private fun configureLoadingPlaceholder(placeholder: Loading) {
        binding.messageTextView.text = placeholder.message ?: context.getString(R.string.app_name)
    }
}