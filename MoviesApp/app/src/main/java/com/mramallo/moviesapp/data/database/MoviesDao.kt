package com.mramallo.moviesapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mramallo.moviesapp.data.entities.MovieDetail
import com.mramallo.moviesapp.data.entities.MoviesList


@Dao
interface MoviesDao {

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMovies(): LiveData<MoviesList?>

    @Query("SELECT * FROM movieDetail_table WHERE id = :id")
    suspend fun getMovieById(id: Int): LiveData<MovieDetail?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(moviesList: MoviesList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieDetail: MovieDetail)

    @Query("DELETE FROM movies_table")
    suspend fun deleteAllMovies()

    // TODO - Ver esto porque creo que quizas no haga falta
    @Query("DELETE FROM movieDetail_table")
    suspend fun deleteMovie()


}