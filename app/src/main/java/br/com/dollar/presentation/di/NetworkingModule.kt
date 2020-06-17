package br.com.dollar.presentation.di

import br.com.dollar.BuildConfig
import br.com.dollar.data.client.ApiClient
import br.com.dollar.data.client.ApiService
import br.com.dollar.data.util.request.AuthInterceptor
import br.com.dollar.data.util.resource.API_DATE_FORMAT
import br.com.dollar.data.util.resource.API_ENDPOINT_NAMED
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun networkingModule() = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single { GsonConverterFactory.create() }

    single(
        named(API_ENDPOINT_NAMED)
    ) {
        BuildConfig.API_ENDPOINT
    }

    single {
        GsonBuilder()
            .serializeNulls()
            .setDateFormat(API_DATE_FORMAT)
            .create()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(get<String>(named(API_ENDPOINT_NAMED)))
            .addConverterFactory(GsonConverterFactory.create(get<Gson>()))
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        ApiClient(
            apiService = get()
        )
    }
}