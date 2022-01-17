package com.mf.data.di

import com.mf.data.api.retrofit.DateAdapter
import com.mf.data.api.retrofit.ILocationService
import com.mf.data.api.retrofit.IWeatherService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

private const val API_KEY_PARAM = "appid"
private const val API_KEY = "8f3598d0957d836dd11daa29b7778633"
private const val BASE_URL = "http://api.openweathermap.org/"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(OkHttpClient.Builder().applyQueryParams().build())
        .addConverterFactory(buildMoshi())

    @Provides
    fun provideLocationService(retrofit: Retrofit.Builder): ILocationService =
        buildRetrofit(retrofit, ILocationService::class.java)

    @Provides
    fun provideWeatherService(retrofit: Retrofit.Builder): IWeatherService =
        buildRetrofit(retrofit, IWeatherService::class.java)

    private fun buildMoshi(): Converter.Factory =
        MoshiConverterFactory.create(
            Moshi.Builder().add(Date::class.java, DateAdapter()).build()
        )

    private fun <T> buildRetrofit(retrofit: Retrofit.Builder, service: Class<T>): T =
        retrofit.build().create(service)

    private fun OkHttpClient.Builder.applyQueryParams() =
        addInterceptor { chain ->
            chain.proceed(
                chain.request().run {
                    newBuilder().url(
                        url.newBuilder().addQueryParameter(API_KEY_PARAM, API_KEY).build()
                    ).build()
                })
        }.addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
}




