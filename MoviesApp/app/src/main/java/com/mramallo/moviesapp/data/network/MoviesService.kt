package com.mramallo.moviesapp.data.network

import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.data.entities.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    // Get all movies
    @GET("movie/popular/")
    suspend fun getAllMovies(@Query("api_key") api_key: String): Response<MoviesList>

    @GET("movie/{movie_id}")
    suspend fun getMovieById(@Query("api_key") api_key: String, @Path("movie_id") movie_id: String): Response<Movie>

}