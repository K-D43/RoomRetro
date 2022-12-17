package com.example.roomretro

import android.app.Application
import com.example.roomretro.api.QuoteService
import com.example.roomretro.api.RetroHelper
import com.example.roomretro.db.QuoteDatabase
import com.example.roomretro.repository.quoteRepository

class QuoteApplication:Application() {

    lateinit var quoteRepository: quoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize(){
        val quoteService=RetroHelper.getInstance().create(QuoteService::class.java)
        val database=QuoteDatabase.getDatabase(applicationContext)
        quoteRepository=quoteRepository(quoteService,database)
    }
}