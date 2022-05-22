package com.mramallo.moviesapp.data.repository

import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.data.network.MoviesDataSource
import com.mramallo.moviesapp.data.network.MoviesService
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesDataSource: MoviesDataSource) {

    // To API
    suspend fun getAllMovies(): MoviesList {
        val response = moviesDataSource.getAllMovies()
        return response.data!!
    }

}