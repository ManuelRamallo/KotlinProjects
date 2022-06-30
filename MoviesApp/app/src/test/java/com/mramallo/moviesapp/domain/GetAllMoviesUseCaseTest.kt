package com.mramallo.moviesapp.domain

import com.mramallo.moviesapp.data.repository.MoviesRepository
import com.mramallo.moviesapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllMoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var moviesRepository: MoviesRepository

    lateinit var getAllMoviesUseCase: GetAllMoviesUseCase


    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getAllMoviesUseCase = GetAllMoviesUseCase(moviesRepository)
    }

    @Test
    fun `when the api return something then get values from api` () = runBlocking {
            // Given
            val movieList = mutableListOf<Movie>()
            movieList.add(Movie("poster_path", false, "overview", "release_date",
                emptyList(), 1, "original_title", "original_language", "title", "backdrop_path",
                1, 1, false, 1))
            coEvery { moviesRepository.getAllMovies() } returns movieList

            // When
            val response = getAllMoviesUseCase()

            // Then
            coVerify(exactly = 1) { moviesRepository.deleteAllMoviesToDDBB() }
            coVerify(exactly = 1) { moviesRepository.insertAllMoviesToDDBB(any()) }
            coVerify(exactly = 0) { moviesRepository.getAllMoviesFromDDBB() }
            assert(movieList == response)


    }

    @Test
    fun `when The Api Doesnt Return Anything Then Get Values From api`() = runBlocking {
        // Given
        coEvery { moviesRepository.getAllMovies() } returns null

        // When
        getAllMoviesUseCase()

        // Then
        coVerify(exactly = 1) { moviesRepository.getAllMoviesFromDDBB() }
    }

}