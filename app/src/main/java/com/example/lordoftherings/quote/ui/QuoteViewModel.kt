package com.example.lordoftherings.quote.ui

import androidx.lifecycle.*
import com.example.lordoftherings.quote.data.QuoteModel
import com.example.lordoftherings.quote.data.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {

    lateinit var quoteList: LiveData<List<QuoteModel>>

    init{
        viewModelScope.launch {
           quoteList = repository.getQuotes()
        }
    }
}
