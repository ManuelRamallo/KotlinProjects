package com.mramallo.moviesapp.ui.movieDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mramallo.moviesapp.R
import com.mramallo.moviesapp.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id_movie")?.let { viewModel.onCreate(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.movie.observe(viewLifecycleOwner) { movie ->
            // TODO - SOLO FALTA AÑADIR LA VISTA BIEN
            Log.d("MOVIELOG", "movie: ${movie.toString()}")
            binding.tvTitle.text = movie?.title ?: "titulo"
            binding.tvOverview.text = movie?.overview ?: "overview"
            binding.tvPopularity.text = movie?.popularity.toString() ?: "popularity"
            binding.tvVoteCount.text = movie?.vote_count.toString() ?: "vote count"
        }
    }

}