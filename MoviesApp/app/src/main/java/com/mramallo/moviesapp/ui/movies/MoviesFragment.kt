package com.mramallo.moviesapp.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
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
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onCreate()
        setupRecyclerViewAndObservers()
        searchMovie()

        // Set max value to search view to display on the entire screen
        binding.svMovies.maxWidth = Integer.MAX_VALUE
    }


    /**
     * Method to setup the recycler view of the movie list
     * */
    private fun setupRecyclerViewAndObservers() {
        val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.rvMovies.layoutManager = manager
        viewModel.moviesList.observe(viewLifecycleOwner) {
            binding.rvMovies.adapter = MoviesAdapter(it!!) { movie ->
                onMovieSelected(movie.id)
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }
    }

    /**
     * Method to move to the selected movie detail view
     * */
    private fun onMovieSelected(id_movie: Int) {
        findNavController().navigate(
            R.id.action_moviesFragment_to_movieDetailFragment,
            bundleOf("id_movie" to id_movie)
        )
    }

    /**
     * Method to move to search movie
     * */
    private fun searchMovie(){
        binding.svMovies.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if(newText.isNotEmpty()) {
                        if(!viewModel.getMovieBySearchName(newText)) binding.tvEmptyList.visibility = View.VISIBLE
                        else binding.tvEmptyList.visibility = View.GONE
                    } else {
                        binding.tvEmptyList.visibility = View.GONE
                        viewModel.onCreate()
                    }
                }

                return true
            }
        })
    }

}