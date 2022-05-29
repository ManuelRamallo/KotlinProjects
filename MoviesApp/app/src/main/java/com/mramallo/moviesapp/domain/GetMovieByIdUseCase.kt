package com.mramallo.moviesapp.domain
import com.mramallo.moviesapp.data.entities.MovieDetail
import com.mramallo.moviesapp.data.repository.MoviesRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(id: Int): MovieDetail? {
        // TODO - FALTA AÑADIR LOS DATOS PARA QUE LOS COJA POR ROOM
        val movie = repository.getMovieById(id)

        return movie ?: MovieDetail(
            false,
        "backdrop_path_mock",
        1,
        "homepage_mock",
        "original_lenguage_mock",
        "original_title_mock",
        "overview_mock",
        1,
        "poster_path_mock",
        -1,
        "imbd_id_mock",
        "release_date_mock",
        1,
        1,
        "status_mock",
        "title_mock",
        "tagline_mock",
        1,
        false,
        1
        )
    }

}