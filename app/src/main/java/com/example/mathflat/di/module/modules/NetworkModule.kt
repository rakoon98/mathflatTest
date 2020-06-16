package com.example.mathflat.di.module.modules

import com.example.mathflat.BuildConfig
import com.example.mathflat.model.data.baseUrl
import com.example.mathflat.model.network.MathFlatInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideOkHttp() }
    single { provideMathFlat(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttp():OkHttpClient{
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    var client = OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)

    return client.build()
}

fun provideMathFlat(retrofit: Retrofit) : MathFlatInterface = retrofit.create(MathFlatInterface::class.java)
