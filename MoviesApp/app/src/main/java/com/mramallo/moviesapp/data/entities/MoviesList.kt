package com.mramallo.moviesapp.data.entities

data class MoviesList(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
)
