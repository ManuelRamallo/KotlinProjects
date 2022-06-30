package com.mramallo.moviesapp.data.network

import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.domain.model.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    // Get all movies
    @GET("movie/popular/")
    suspend fun getAllMovies(@Query("api_key") api_key: String): Response<MoviesList>

    @GET("movie/{movie_id}")
    suspend fun getMovieById(@Path("movie_id") movie_id: Int, @Query("api_key") api_key: String): Response<MovieDetail>

}