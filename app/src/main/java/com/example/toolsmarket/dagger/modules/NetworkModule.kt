package com.example.toolsmarket.dagger.modules

import com.example.toolsmarket.networks.ToolsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://develtop.ru/study/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun getApi(retrofit: Retrofit): ToolsApi =
        retrofit.create(ToolsApi::class.java)
}