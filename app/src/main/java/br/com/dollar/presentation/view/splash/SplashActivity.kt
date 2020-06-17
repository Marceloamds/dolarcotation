package br.com.dollar.presentation.view.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.dollar.R
import br.com.dollar.databinding.ActivitySplashBinding
import br.com.dollar.presentation.util.base.BaseActivity
import br.com.dollar.presentation.util.base.BaseViewModel
import br.com.dollar.presentation.util.extension.observe
import br.com.dollar.presentation.util.extension.transparentStatusAndNavigation
import br.com.dollar.presentation.view.converter.DollarQuoteActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    override val baseViewModel: BaseViewModel get() = _viewModel
    private val _viewModel: SplashViewModel by viewModel()

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        transparentStatusAndNavigation(window)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
    }

    override fun subscribeUi() {
        super.subscribeUi()
        _viewModel.goToMain.observe(this) { startActivity(DollarQuoteActivity.createIntent(this)) }
    }
}