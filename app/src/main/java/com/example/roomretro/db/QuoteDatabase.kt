package com.example.roomretro.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Result::class],version=1)
abstract class QuoteDatabase:RoomDatabase() {

    abstract fun quoteDao():QuoteDao

    companion object{
        private var INSTANCE:QuoteDatabase?=null

        fun getDatabase(context:Context):QuoteDatabase{
            if (INSTANCE!=null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context,
                        QuoteDatabase::class.java,
                        "quotedb"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}