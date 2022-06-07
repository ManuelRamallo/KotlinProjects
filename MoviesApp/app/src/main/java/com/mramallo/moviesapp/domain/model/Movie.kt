package com.mramallo.moviesapp.domain.model

import com.mramallo.moviesapp.data.entities.MovieEntity

data class Movie(
    val poster_path: String?,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String?,
    val popularity: Number,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Number
)

fun MovieEntity.toDomain() = Movie(poster_path, adult, overview, release_date, genre_ids, id, original_title, original_language, title, backdrop_path, popularity, vote_count, video, vote_average)
