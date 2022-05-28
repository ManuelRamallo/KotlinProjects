package com.mramallo.moviesapp.domain

import android.util.Log
import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.data.repository.MoviesRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(id: Int): Movie? {
        // TODO - FALTA AÑADIR LOS DATOS PARA QUE LOS COJA POR ROOM
        val movie = repository.getMovieById(id)

        return movie ?: Movie(
            "Poster_path_mock",
            false,
            "overview_mock",
            "release_date_mock",
            listOf(),
            -1,
            "original_title_mock",
            "original_lenguage_mock",
            "title_mock",
            "backdrop_path_mock",
            1,
            1,
            false,
            1
        )
    }

}