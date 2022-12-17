package com.example.roomretro.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroHelper {
    private const val baseurl="https://quotable.io"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}