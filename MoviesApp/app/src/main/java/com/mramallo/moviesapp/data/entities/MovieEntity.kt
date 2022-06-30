package com.mramallo.moviesapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mramallo.moviesapp.domain.model.Movie

@Entity(tableName = "movies_table")
data class MovieEntity(
    @ColumnInfo(name = "poster_path") val poster_path: String?,
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "genre_ids") val genre_ids: List<Int>,
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "original_title") val original_title: String,
    @ColumnInfo(name = "original_language") val original_language: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "backdrop_path") val backdrop_path: String?,
    @ColumnInfo(name = "popularity") val popularity: Number,
    @ColumnInfo(name = "vote_count") val vote_count: Int,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "vote_average") val vote_average: Number
)

fun Movie.toDataBase() = MovieEntity(poster_path, adult, overview, release_date, genre_ids.map { it }, id, original_title, original_language, title, backdrop_path, popularity, vote_count, video, vote_average)
