package com.mramallo.moviesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mramallo.moviesapp.data.entities.MovieDetailEntity
import com.mramallo.moviesapp.data.entities.MovieEntity
import com.mramallo.moviesapp.data.entities.MoviesListEntity
import com.mramallo.moviesapp.utils.Converters

@Database(entities = [MovieEntity::class, MovieDetailEntity::class, MoviesListEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class MoviesDataBase: RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}