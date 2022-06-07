package com.mramallo.moviesapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mramallo.moviesapp.domain.model.Movie
import com.mramallo.moviesapp.domain.model.MoviesList

@Entity(tableName = "movies_list_table")
data class MoviesListEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,

    @ColumnInfo(name = "page") val page: Int,
    @ColumnInfo(name = "results") val results: List<MovieEntity>,
    @ColumnInfo(name = "total_results") val total_results: Int,
    @ColumnInfo(name = "total_pages") val total_pages: Int
)

fun MoviesList.toDataBase() = MoviesListEntity(page = page, results = results.map { it.toDataBase() }, total_results = total_results, total_pages = total_pages)
