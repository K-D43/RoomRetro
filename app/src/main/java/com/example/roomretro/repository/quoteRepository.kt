package com.example.roomretro.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomretro.Models.QuoteList
import com.example.roomretro.api.QuoteService
import com.example.roomretro.db.QuoteDatabase

class quoteRepository(private val quoteService: QuoteService,val quoteDatabase: QuoteDatabase) {

    private val  quoteLiveData=MutableLiveData<QuoteList>()

    val quote:LiveData<QuoteList>
    get() = quoteLiveData

    suspend fun getQuotes(page: Int){
        val result=quoteService.getQuotes(page)
        if(result?.body()!=null){
            quoteDatabase.quoteDao().addQuote(result.body()!!.results)
            quoteLiveData.postValue(result.body())
        }
    }

}