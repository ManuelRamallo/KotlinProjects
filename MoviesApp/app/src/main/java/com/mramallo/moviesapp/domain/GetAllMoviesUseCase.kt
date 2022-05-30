package com.mramallo.moviesapp.domain

import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.data.repository.MoviesRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(): MoviesList {
        // TODO - FALTA AÑADIR LOS DATOS PARA QUE LOS COJA POR ROOM
        val movieList = repository.getAllMovies()

        return movieList ?:
        MoviesList(1, listOf(), 1, 1)
    }
    
}