package com.mramallo.moviesapp.data.entities

import androidx.room.Entity

@Entity(tableName = "movieDetail_table")
data class MovieDetail(
    val adult: Boolean,
    val backdrop_path: String?,
    val budget: Int,
    val homepage: String?,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Number,
    val poster_path: String?,
    val id: Int,
    val imdb_id: String?,
    val release_date: String,
    val revenue: Int,
    val runtime: Int?,
    val status: String,
    val title: String,
    val tagline: String,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Number
)
