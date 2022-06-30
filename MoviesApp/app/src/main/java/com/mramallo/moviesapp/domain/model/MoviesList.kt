package com.mramallo.moviesapp.domain.model

import com.mramallo.moviesapp.data.entities.MoviesListEntity

data class MoviesList(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
)

fun MoviesListEntity.toDomain() = MoviesList(page, results.map { it.toDomain() }, total_results, total_pages)
