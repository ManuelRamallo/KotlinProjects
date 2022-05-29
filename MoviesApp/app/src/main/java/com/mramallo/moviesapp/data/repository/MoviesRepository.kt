package com.mramallo.moviesapp.data.repository

import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.data.entities.MovieDetail
import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.data.network.MoviesDataSource
import javax.inject.Inject


// TODO - DE AQUÍ VA A LOS CASOS DE USO ( EN LA APP DE RICK Y MORTY VA AL VIEW MODEL DEL TIRON )
// TODO - AQUÍ EN ESTE CASO VAMOS A HACER LOS CASOS DE USO Y ESO
class MoviesRepository @Inject constructor(private val moviesDataSource: MoviesDataSource) {

    // To API
    suspend fun getAllMovies(): MoviesList? {
        return moviesDataSource.getAllMovies()
    }

    suspend fun getMovieById(id: Int): MovieDetail? {
        return moviesDataSource.getMovieById(id)
    }

}