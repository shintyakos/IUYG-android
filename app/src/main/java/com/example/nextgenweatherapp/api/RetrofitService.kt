package com.example.nextgenweatherapp.api

import com.example.nextgenweatherapp.api.service.service.WeatherService
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        val weatherService =
            RetrofitService().createRetrofitService().create(WeatherService::class.java)
    }

    private fun createRetrofitService(): Retrofit {
        val apiUrl = "https://weather.visualcrossing.com"
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        return Retrofit.Builder().apply {
            baseUrl(apiUrl)
            client(builderHttpClient())
            addConverterFactory(GsonConverterFactory.create(gson))
        }.build()
    }

    private fun builderHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(BearerTokenInterceptor())
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                },
            )
        }.build()
    }

    class BearerTokenInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val token = "token"
            val request = chain.request().newBuilder()
                .header("Authorization", "Bearer $token")
                .build()

            return chain.proceed(request)
        }
    }
}
