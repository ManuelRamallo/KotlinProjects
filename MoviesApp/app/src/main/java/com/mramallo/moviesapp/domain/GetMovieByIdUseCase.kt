package com.mramallo.moviesapp.domain
import com.mramallo.moviesapp.data.entities.MovieDetail
import com.mramallo.moviesapp.data.repository.MoviesRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(id: Int): MovieDetail? {
        // TODO - FALTA AÑADIR LOS DATOS PARA QUE LOS COJA POR ROOM
        val movie = repository.getMovieById(id)

        return null
    }

}