package com.mramallo.moviesapp.ui.movieDetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.domain.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieByIdUseCase: GetMovieByIdUseCase
): ViewModel() {

    val movie = MutableLiveData<MovieDetail?>()

    fun onCreate(id_movie: Int){
        Log.d("SEARCH", "ID MOVIE: $id_movie")
        viewModelScope.launch {
            movie.postValue(getMovieByIdUseCase(id_movie))
        }
    }
}