package com.mramallo.moviesapp.domain.model

import com.mramallo.moviesapp.data.entities.MovieDetailEntity


data class MovieDetail(
    val adult: Boolean,
    val backdrop_path: String?, val budget: Int,
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

fun MovieDetailEntity.toDomain() = MovieDetail(adult, backdrop_path, budget, homepage, original_language, original_title, overview, popularity, poster_path, id, imdb_id, release_date, revenue, runtime, status, title, tagline, vote_count, video, vote_average)
