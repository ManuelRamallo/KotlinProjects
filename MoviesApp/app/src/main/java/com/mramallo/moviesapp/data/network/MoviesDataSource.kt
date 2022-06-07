package com.mramallo.moviesapp.data.network

import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.domain.model.MoviesList
import com.mramallo.moviesapp.utils.Constants.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

// TODO - ESTA CLASE ES COMO LA DEL SERVICE DEL PROYECTO DE MVVMKOTLINEX (QUOTESERVICE)

/**
 * Class dedicated to obtain response of the request to the API and transmit that response*/
class MoviesDataSource @Inject constructor(private val movieService: MoviesService): BaseDataSource() {


    // Obtain all popular movies
    //suspend fun getAllMovies() = getResult { movieService.getAllMovies(API_KEY) }
    suspend fun getAllMovies(): MoviesList? {
        return withContext(Dispatchers.IO) {
            val response = movieService.getAllMovies(API_KEY)
            response.body()
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