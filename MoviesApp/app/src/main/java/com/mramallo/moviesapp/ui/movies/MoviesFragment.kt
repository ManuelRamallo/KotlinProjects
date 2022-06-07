package com.mramallo.moviesapp.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mramallo.moviesapp.R
import com.mramallo.moviesapp.databinding.FragmentMoviesBinding
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

        // Set max value to search view to display on the entire screen
        binding.svMovies.maxWidth = Integer.MAX_VALUE
    }


    /**
     * Method to setup the recycler view of the movie list
     * */
    private fun setupRecyclerViewAndObservers() {
        val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // TODO - FALTA AÑADIR UN LOADER PARA MOSTRAR MIENTRAS NO SE VEN LAS PELICULAS Y CARGAN LOS DATOS
        binding.rvMovies.layoutManager = manager
        viewModel.moviesList.observe(viewLifecycleOwner, Observer {
            binding.rvMovies.adapter = MoviesAdapter(it!!) { movie ->
                onMovieSelected(movie.id)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }
    }

    private fun onMovieSelected(id_movie: Int) {
        findNavController().navigate(
            R.id.action_moviesFragment_to_movieDetailFragment,
            bundleOf("id_movie" to id_movie)
        )
    }

}