package com.mramallo.moviesapp.ui.movies

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.moviesapp.domain.model.MoviesList
import com.mramallo.moviesapp.domain.GetAllMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
): ViewModel() {

    val moviesList = MutableLiveData<MoviesList?>()
    val isLoading = MutableLiveData<Boolean>()
    
    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)

            val movies = getAllMoviesUseCase()

            if(movies != null) {
                moviesList.postValue(movies)
                isLoading.postValue(false)
            } else {
                Timber.d("Error with movies, null object")
            }


        }
    }
}