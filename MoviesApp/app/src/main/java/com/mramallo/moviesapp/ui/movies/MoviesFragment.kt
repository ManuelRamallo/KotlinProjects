package com.mramallo.moviesapp.ui.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mramallo.moviesapp.R
import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.databinding.FragmentMoviesBinding
import com.mramallo.moviesapp.domain.GetAllMoviesUseCase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onCreate()
        setupRecyclerViewAndObservers()
    }


    /**
     * Method to setup the recycler view of the movie list
     * */
    private fun setupRecyclerViewAndObservers() {
        val manager = LinearLayoutManager(context)
        val decoration = DividerItemDecoration(context, manager.orientation)

        binding.rvMovies.layoutManager = manager
        viewModel.moviesList.observe(viewLifecycleOwner, Observer {
            binding.rvMovies.adapter = MoviesAdapter(it) { movie ->
                onMovieSelected(movie)
            }
        })

        binding.rvMovies.addItemDecoration(decoration)
    }

    fun onMovieSelected(movie: Movie) {
        Toast.makeText(context, movie.toString(), Toast.LENGTH_LONG).show()
    }

}