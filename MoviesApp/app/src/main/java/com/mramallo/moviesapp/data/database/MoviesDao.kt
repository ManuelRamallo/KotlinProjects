package com.mramallo.moviesapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mramallo.moviesapp.data.entities.MovieDetailEntity
import com.mramallo.moviesapp.data.entities.MovieEntity
import com.mramallo.moviesapp.data.entities.MoviesListEntity
import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.domain.model.MoviesList


@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_list_table")
    suspend fun getAllMovies(): MoviesListEntity?

    @Query("SELECT * FROM movie_detail_table WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieDetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moviesList: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieDetail: MovieDetailEntity)

    @Query("DELETE FROM movies_list_table")
    suspend fun deleteAllMovies()

    @Query("DELETE FROM movie_detail_table")
    suspend fun deleteMovie()


}