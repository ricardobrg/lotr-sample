package com.example.lordoftherings.movie.ui

import androidx.lifecycle.*
import com.example.lordoftherings.movie.data.MovieModel
import com.example.lordoftherings.movie.data.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    val toggleFav: (id: String) -> Unit = {
        id ->  repository.toggleFav(id)
    }

    lateinit var movieList: LiveData<List<MovieModel>>

    init{
        viewModelScope.launch {
           movieList = repository.getMovies()
        }
    }
}
