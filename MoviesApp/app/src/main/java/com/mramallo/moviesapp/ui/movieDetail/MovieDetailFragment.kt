package com.mramallo.moviesapp.ui.movieDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
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
        setButtonListener()
    }

    private fun setupObservers() {
        viewModel.movie.observe(viewLifecycleOwner) {  movieDetail ->
            if(movieDetail != null) {
                Glide.with(binding.ivBackgroundMovie.context).load("https://image.tmdb.org/t/p/original/${movieDetail.poster_path}").into(binding.ivBackgroundMovie)
                binding.tvTitle.text = movieDetail.title
                binding.tvReleaseDate.text = movieDetail.release_date
                binding.tvDuration.text = movieDetail.runtime.toString() + " min"
                binding.tvOverview.text = movieDetail.overview
                binding.rbVoteAverage.apply {
                    setIsIndicator(true)
                    numStars = 5
                    stepSize = 1f
                    rating = movieDetail.vote_average.toFloat() / 2
                    max = 5
                }
            }

        }
    }

    private fun setButtonListener() {
        binding.ibBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}