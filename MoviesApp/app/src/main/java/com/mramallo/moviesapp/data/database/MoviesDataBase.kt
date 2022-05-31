package com.mramallo.moviesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.data.entities.MovieDetail

@Database(entities = [Movie::class, MovieDetail::class], version = 1)
abstract class MoviesDataBase: RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}