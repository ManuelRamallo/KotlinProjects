package com.mramallo.moviesapp.data.network

import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.utils.Constants.API_KEY
import javax.inject.Inject

// TODO - ESTA CLASE ES COMO LA DEL SERVICE DEL PROYECTO DE MVVMKOTLINEX (QUOTESERVICE)

/**
 * Class dedicated to obtain response of the request to the API and transmit that response*/
class MoviesDataSource @Inject constructor(private val movieService: MoviesService): BaseDataSource() {


    // Obtain all popular movies
    suspend fun getAllMovies() = getResult { movieService.getAllMovies(API_KEY) }

    // Obtain movie by ID
    suspend fun getMovieById(id: Int) = getResult { movieService.getMovieById(API_KEY, id) }


}