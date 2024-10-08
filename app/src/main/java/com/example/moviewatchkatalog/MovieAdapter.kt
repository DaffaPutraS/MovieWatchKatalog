package com.example.moviewatchkatalog

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.tv_movie_title)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tv_movie_description)
        private val imageView: ImageView = itemView.findViewById(R.id.iv_movie_image)
        private val tvMovieTahun: TextView = itemView.findViewById(R.id.tv_movie_tahun)
        private val tvMovieRating: TextView = itemView.findViewById(R.id.tv_movie_rating)

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            descriptionTextView.text = movie.description
            imageView.setImageResource(movie.image)
            tvMovieTahun.text = movie.tahun    // Set tahun film
            tvMovieRating.text = movie.rating  // Set rating film
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("key_movie", movie)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}
