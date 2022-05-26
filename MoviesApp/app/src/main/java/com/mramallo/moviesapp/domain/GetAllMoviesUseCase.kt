package com.mramallo.moviesapp.domain

import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.data.repository.MoviesRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(): MoviesList {
        val movieList = repository.getAllMovies()

        // TODO - ESTO DEBERIA RECUPERARLO DE ROOM CUANDO FALLE LA PETICIÓN EN LUGAR DE UN MOCK
        return movieList ?:
        MoviesList(1, listOf(), 1, 1)
    }
    
}