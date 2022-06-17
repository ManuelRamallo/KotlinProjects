package com.mramallo.moviesapp.domain

import com.mramallo.moviesapp.data.entities.toDataBase
import com.mramallo.moviesapp.data.repository.MoviesRepository
import com.mramallo.moviesapp.domain.model.Movie
import com.mramallo.moviesapp.domain.model.toDomain
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(): List<Movie>? {
        val movieList = repository.getAllMovies()
        return if(movieList != null) {
            repository.deleteAllMoviesToDDBB()
            repository.insertAllMoviesToDDBB(movieList.map { it.toDataBase() })
            movieList
        } else {
            repository.getAllMoviesFromDDBB()?.results?.map { it.toDomain() }
        }
    }
    
}