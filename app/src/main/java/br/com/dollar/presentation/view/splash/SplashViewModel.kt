package br.com.dollar.presentation.view.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.dollar.presentation.util.base.BaseViewModel
import br.com.dollar.presentation.util.constants.SPLASH_DELAY
import kotlinx.coroutines.delay

class SplashViewModel : BaseViewModel() {

    val goToMain: LiveData<Boolean> get() = _goToMain
    private val _goToMain by lazy { MutableLiveData<Boolean>() }

    init {
        launchDataLoad {
            delay(SPLASH_DELAY)
            _goToMain.value = true
        }
    }
}