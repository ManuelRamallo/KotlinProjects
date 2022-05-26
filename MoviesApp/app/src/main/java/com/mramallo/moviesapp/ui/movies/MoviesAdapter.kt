package com.mramallo.moviesapp.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mramallo.moviesapp.R
import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.databinding.ItemMovieBinding

class MoviesAdapter(private val moviesList: MoviesList, private val onClickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesAdapter.MovieListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieListViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
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
            binding.tvVoteAverage.text = movie.vote_average.toString()

            Glide.with(binding.ivPosterPath.context).load(movie.poster_path).into(binding.ivPosterPath)

            itemView.setOnClickListener {
                onClickListener(movie)
            }

        }

    }
}

/*
* package com.mramallo.moviesapp.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mramallo.moviesapp.R
import com.mramallo.moviesapp.data.entities.Movie
import com.mramallo.moviesapp.data.entities.MoviesList
import com.mramallo.moviesapp.databinding.ItemMovieBinding

class MoviesAdapter(private val listener: MoviesItemListener) :
    RecyclerView.Adapter<MoviesAdapter.MovieListViewHolder>() {

    private var moviesList: MoviesList? = null

    fun setItems(moviesList: MoviesList) {
        this.moviesList = null
        this.moviesList = moviesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieListViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = moviesList!!.results[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = moviesList.total_results


    class MovieListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemMovieBinding.bind(view)

        fun render(movie: Movie, onClickListener: (Movie) -> Unit){
            binding.tvTitle.text = movie.title
            binding.tvVoteAverage.text = movie.vote_average.toString()

            Glide.with(binding.ivPosterPath.context).load(movie.poster_path).into(binding.ivPosterPath)

            itemView.setOnClickListener {
                onClickListener(movie)
            }

        }

    }

    interface MoviesItemListener {
        fun onClickMovie(movieId: Int)
    }
}*/