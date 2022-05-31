package com.mramallo.moviesapp.domain

import android.util.Log
import androidx.lifecycle.LiveData
import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.data.repository.MoviesRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(): MoviesList? {
        val movieList = repository.getAllMovies()

        val moviesListBBDD = repository.getAllMoviesFromDDBB()
        Log.d("MOVIELIST", "movielistbbdd: $moviesListBBDD")

        return if(movieList != null) {
            repository.deleteAllMoviesToDDBB()
            repository.insertAllMoviesToDDBB(movieList)
            movieList
        } else {
            repository.getAllMoviesFromDDBB()
        }
    }
    
}