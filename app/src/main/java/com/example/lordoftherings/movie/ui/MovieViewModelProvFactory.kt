package com.example.lordoftherings.movie.ui

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lordoftherings.AppDatabase
import com.example.lordoftherings.movie.data.MovieApi
import com.example.lordoftherings.movie.data.MovieApiService
import com.example.lordoftherings.movie.data.MovieDao
import com.example.lordoftherings.movie.data.MovieRepository

class MovieViewModelProvFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val movieDao : MovieDao = AppDatabase.getInstance(context).movieDao()
        val movieApiService : MovieApiService = MovieApi.retrofitService
        val repository = MovieRepository(
            movieDao, movieApiService
        )
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
