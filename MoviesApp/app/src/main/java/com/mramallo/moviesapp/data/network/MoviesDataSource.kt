package com.mramallo.moviesapp.data.network

import com.mramallo.moviesapp.domain.model.Movie
import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.utils.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class dedicated to obtain response of the request to the API and transmit that response*/
class MoviesDataSource @Inject constructor(private val movieService: MoviesService) {


    // Obtain all popular movies
    suspend fun getAllMovies(): List<Movie>? {
        return withContext(Dispatchers.IO) {
            val response = movieService.getAllMovies(API_KEY)
            if(response.body() != null) {
                response.body()?.results
            } else {
                mutableListOf()
            }
        }

    }

    // Obtain movie by ID
    suspend fun getMovieById(id: Int): MovieDetail? {
        return withContext(Dispatchers.IO) {
            val response = movieService.getMovieById(id, API_KEY)
            response.body()
        }
    }


}