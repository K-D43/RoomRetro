package com.example.roomretro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomretro.Models.QuoteList
import com.example.roomretro.repository.quoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: quoteRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }

    }
    val quote:LiveData<QuoteList>
    get() = repository.quote
}