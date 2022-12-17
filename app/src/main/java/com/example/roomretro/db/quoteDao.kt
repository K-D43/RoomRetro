package com.example.roomretro.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomretro.Models.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuote(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes():List<Result>
}