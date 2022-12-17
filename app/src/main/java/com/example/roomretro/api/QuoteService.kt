package com.example.roomretro.api

import com.example.roomretro.Models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page:Int) : Response<QuoteList>

//    baseurl



}