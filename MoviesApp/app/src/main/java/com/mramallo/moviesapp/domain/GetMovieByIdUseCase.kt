package com.mramallo.moviesapp.domain
import com.mramallo.moviesapp.data.entities.toDataBase
import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.data.repository.MoviesRepository
import com.mramallo.moviesapp.domain.model.toDomain
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val repository: MoviesRepository) {

    suspend operator fun invoke(id: Int): MovieDetail? {
        // TODO - FALTA AÑADIR LOS DATOS PARA QUE LOS COJA POR ROOM
        val movie = repository.getMovieById(id)

        return if(movie != null) {
            repository.deleteMovieToDDBB()
            repository.insertMovieToDDBB(movie.toDataBase())
            movie
        } else {
            repository.getMovieByIdToDDBB(id)?.toDomain()
        }
    }

}