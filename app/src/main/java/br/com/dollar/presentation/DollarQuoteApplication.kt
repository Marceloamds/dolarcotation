package br.com.dollar.presentation

import android.app.Application
import br.com.dollar.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DollarQuoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DollarQuoteApplication)
            modules(
                listOf(
                    networkingModule(),
                    viewModelModule(),
                    repositoryModule(),
                    interactorModule(),
                    resourceModule()
                )
            )
        }
    }
}