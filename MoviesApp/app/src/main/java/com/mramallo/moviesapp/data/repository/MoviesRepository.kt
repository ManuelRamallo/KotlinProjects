package com.mramallo.moviesapp.data.repository

import com.mramallo.moviesapp.data.database.MoviesDao
import com.mramallo.moviesapp.data.entities.MovieDetailEntity
import com.mramallo.moviesapp.data.entities.MoviesListEntity
import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.domain.model.MoviesList
import com.mramallo.moviesapp.data.network.MoviesDataSource
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val moviesDataSource: MoviesDataSource,
    private val moviesDao: MoviesDao
    ) {

    // To API
    suspend fun getAllMovies(): MoviesList? {
        return moviesDataSource.getAllMovies()
    }

    suspend fun getMovieById(id: Int): MovieDetail? {
        return moviesDataSource.getMovieById(id)
    }

    // To DataBase Room
    suspend fun getAllMoviesFromDDBB(): MoviesListEntity? {
        return moviesDao.getAllMovies()
    }

    suspend fun insertAllMoviesToDDBB(moviesList: MoviesListEntity) {
        moviesDao.insertAll(moviesList)
    }

    suspend fun insertMovieToDDBB(movieDetail: MovieDetailEntity) {
        moviesDao.insertMovie(movieDetail)
    }

    suspend fun getMovieByIdToDDBB(id: Int): MovieDetailEntity? {
        return moviesDao.getMovieById(id)
    }

    suspend fun deleteMovieToDDBB() {
        moviesDao.deleteMovie()
    }

    suspend fun deleteAllMoviesToDDBB() {
        moviesDao.deleteAllMovies()
    }

}