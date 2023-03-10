package com.example.roomretro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomretro.api.QuoteService
import com.example.roomretro.api.RetroHelper
import com.example.roomretro.repository.quoteRepository
import com.example.roomretro.viewmodel.MainViewModel
import com.example.roomretro.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository=(application as QuoteApplication).quoteRepository

        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quote.observe(this, Observer {
            Log.d("tag",it.results.toString())
        })
    }
}