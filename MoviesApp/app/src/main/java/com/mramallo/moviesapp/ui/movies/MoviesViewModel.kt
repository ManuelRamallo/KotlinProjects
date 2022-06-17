package com.mramallo.moviesapp.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.moviesapp.domain.GetAllMoviesUseCase
import com.mramallo.moviesapp.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    val moviesList = MutableLiveData<List<Movie>?>()
    val isLoading = MutableLiveData<Boolean>()
    var movies = listOf<Movie>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)

            movies = getAllMoviesUseCase() ?: listOf()

            if(movies.isNotEmpty()) {
                moviesList.postValue(movies)
                isLoading.postValue(false)
            } else {
                Timber.d("Error with movies, null object")
            }


        }
    }

    fun getMovieBySearchName(name: String): Boolean {
        val movieListSearched = mutableListOf<Movie>()

        movies.forEach { movie ->
            if(movie.title.lowercase().contains(name.lowercase())) {
                movieListSearched.add(movie)
            }
        }

        return if(movieListSearched.size > 0) {
            moviesList.postValue(movieListSearched)
            isLoading.postValue(false)
            true
        } else {
            moviesList.postValue(listOf())
            isLoading.postValue(false)
            false

        }
    }
}