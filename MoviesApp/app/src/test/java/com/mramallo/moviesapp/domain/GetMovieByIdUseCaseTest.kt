package com.mramallo.moviesapp.domain

import com.mramallo.moviesapp.data.entities.MovieDetailEntity
import com.mramallo.moviesapp.data.entities.toDataBase
import com.mramallo.moviesapp.data.repository.MoviesRepository
import com.mramallo.moviesapp.domain.model.MovieDetail
import com.mramallo.moviesapp.domain.model.toDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetMovieByIdUseCaseTest {

    @RelaxedMockK
    private lateinit var moviesRepository: MoviesRepository

    lateinit var getMovieByIdUseCase: GetMovieByIdUseCase

    @Before
    fun onBeforeCreate() {
        MockKAnnotations.init(this)
        getMovieByIdUseCase = GetMovieByIdUseCase(moviesRepository)
    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        // Given
        val movieDetail = MovieDetail(false, "backdrop_path", 1, "homepage",
            "original_language", "original title", "overview", 1, "poster_path", 1,
            "imbd_id", "release_date", 1, 1, "status", "title", "tagline", 1, false, 1)
        coEvery { moviesRepository.getMovieById(1) } returns movieDetail

        // When
        val response = getMovieByIdUseCase(1)

        // Then
        assert(movieDetail == response)
    }

    @Test
    fun `when api return null then database return something`() = runBlocking {
        // Given
        coEvery { moviesRepository.getMovieById(1) } returns null

        // When
        getMovieByIdUseCase(1)

        // Then
        coVerify(exactly = 1){ moviesRepository.getMovieByIdToDDBB(1) }

    }

}