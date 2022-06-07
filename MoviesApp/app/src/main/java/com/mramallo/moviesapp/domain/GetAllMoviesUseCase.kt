package com.mramallo.moviesapp.domain

import android.util.Log
import com.mramallo.moviesapp.data.entities.toDataBase
import com.mramallo.moviesapp.domain.model.MoviesList
import com.mramallo.moviesapp.data.repository.MoviesRepository
import com.mramallo.moviesapp.domain.model.toDomain
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(): MoviesList? {
        val movieList = repository.getAllMovies()

        return if(movieList != null) {
            repository.deleteAllMoviesToDDBB()
            repository.insertAllMoviesToDDBB(movieList.toDataBase())
            movieList
        } else {
            repository.getAllMoviesFromDDBB()?.toDomain()
        }
    }
    
}