package com.example.formula1.data

import com.example.formula1.data.source.remote.APIService
import com.example.formula1.utils.BASE_URL
import com.example.formula1.utils.CONNECTION_TIMEOUT
import com.example.formula1.utils.KEY_AUTH
import com.example.formula1.utils.MY_KEY
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {
    single { provideOkHttpClient() }

    single { provideRetrofit(get()) }

    single { provideService(get()) }
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addInterceptor(
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(KEY_AUTH, MY_KEY).build()
            chain.proceed(request)
        }).build()
}

private fun provideService(retrofit: Retrofit): APIService {
    return retrofit.create(APIService::class.java)
}
