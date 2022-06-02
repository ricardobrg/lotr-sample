package com.example.lordoftherings.movie.data

import androidx.lifecycle.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow

class MovieRepository constructor(
    private val movieDao: MovieDao,
    private val movieApiService: MovieApiService) {

    private var movies : List<MovieModel> = listOf()

    fun getMovies() : LiveData<List<MovieModel>> = liveData {
        emitSource(movieDao.getAll().asLiveData())
        val movieModelList : MovieModelList = movieApiService.getMovies()
        movies = movieModelList.docs
        movieDao.insert(movies)
        emitSource(movieDao.getAll().asLiveData())
    }

    fun toggleFav(id: String) {
        val movie = movies[movies.indexOfFirst { it.id == id }]
        movie.favorite = !movie.favorite
        movieDao.update(movie)
        getMovies()
    }

}