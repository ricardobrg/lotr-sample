package com.example.lordoftherings.quote.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lordoftherings.quote.data.QuoteRepository


class QuoteViewModelProvFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
