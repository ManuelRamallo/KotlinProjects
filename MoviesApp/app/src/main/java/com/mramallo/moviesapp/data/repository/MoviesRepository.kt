package com.mramallo.moviesapp.data.repository

import com.mramallo.moviesapp.data.network.MoviesService
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val moviesService: MoviesService) {
}