package com.mramallo.moviesapp.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mramallo.moviesapp.domain.model.MovieDetail

@Entity(tableName = "movie_detail_table")
data class MovieDetailEntity(
    @ColumnInfo(name = "adult") val adult: Boolean,
    @ColumnInfo(name = "backdrop_path") val backdrop_path: String?,
    @ColumnInfo(name = "budget") val budget: Int,
    @ColumnInfo(name = "homepage") val homepage: String?,
    @ColumnInfo(name = "original_language") val original_language: String,
    @ColumnInfo(name = "original_title") val original_title: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "popularity") val popularity: Number,
    @ColumnInfo(name = "poster_path") val poster_path: String?,
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "imdb_id") val imdb_id: String?,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "revenue") val revenue: Int,
    @ColumnInfo(name = "runtime") val runtime: Int?,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "tagline") val tagline: String,
    @ColumnInfo(name = "vote_count") val vote_count: Int,
    @ColumnInfo(name = "video") val video: Boolean,
    @ColumnInfo(name = "vote_average") val vote_average: Number
)

fun MovieDetail.toDataBase() = MovieDetailEntity(adult, backdrop_path, budget, homepage, original_language, original_title, overview, popularity, poster_path, id, imdb_id, release_date, revenue, runtime, status, title, tagline, vote_count, video, vote_average)