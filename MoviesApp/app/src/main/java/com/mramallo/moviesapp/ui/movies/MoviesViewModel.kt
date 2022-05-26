package com.mramallo.moviesapp.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.domain.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    val moviesList = MutableLiveData<MoviesList>()
    // TODO - Hay que añadir un loading mientras cargan las peliculas

    fun onCreate(){
        viewModelScope.launch {
            // TODO - Aquí faltaría el loading
            // This is not a error, is only a bug to android studio
            moviesList.postValue(getAllMoviesUseCase())
        }
    }
}