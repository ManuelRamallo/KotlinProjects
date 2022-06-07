package com.mramallo.moviesapp.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mramallo.moviesapp.domain.model.Movie
import com.mramallo.moviesapp.domain.model.MoviesList
import com.mramallo.moviesapp.databinding.ItemMovieBinding

class MoviesAdapter(private val moviesList: MoviesList, private val onClickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MovieListViewHolder>() {

    private lateinit var binding: ItemMovieBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = moviesList.results[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = moviesList.total_results


    class MovieListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)

        fun render(movie: Movie, onClickListener: (Movie) -> Unit){
            binding.tvTitle.text = movie.title
            binding.rbVoteAverage.apply {
                setIsIndicator(true)
                numStars = 5
                stepSize = 1f
                rating = movie.vote_average.toFloat() / 2
                max = 5
            }

            Glide.with(binding.ivPosterPath.context).load("https://image.tmdb.org/t/p/original/${movie.poster_path}").into(binding.ivPosterPath)

            itemView.setOnClickListener {
                onClickListener(movie)
            }

        }

    }
}