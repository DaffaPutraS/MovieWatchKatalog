package com.example.moviewatchkatalog

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    private lateinit var ivDetailPhoto: ImageView
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailDescription: TextView
    private lateinit var tvDetailTahun: TextView
    private lateinit var tvDetailRating: TextView
    private lateinit var tvDetailDirector: TextView
    private lateinit var tvDetailWriter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        ivDetailPhoto = findViewById(R.id.iv_detail_movie_image)
        tvDetailTitle = findViewById(R.id.tv_detail_movie_title)
        tvDetailDescription = findViewById(R.id.tv_detail_movie_description)
        tvDetailTahun = findViewById(R.id.tv_detail_movie_tahun)
        tvDetailRating = findViewById(R.id.tv_detail_movie_rating)
        tvDetailDirector = findViewById(R.id.tv_detail_movie_director)
        tvDetailWriter = findViewById(R.id.tv_detail_movie_writer)

        // Inisialisasi view yang digunakan
        val movieTitle = findViewById<TextView>(R.id.tv_detail_movie_title).text.toString()
        val movieRating = findViewById<TextView>(R.id.tv_detail_movie_rating).text.toString()
        val movieDescription = findViewById<TextView>(R.id.tv_detail_movie_description).text.toString()

        // Tombol Share
        val shareButton = findViewById<Button>(R.id.action_share)
        shareButton.setOnClickListener {
            shareMovieDetails(movieTitle, movieRating, movieDescription)
        }

        val dataMovie = intent.getParcelableExtra<Movie>("key_movie")
        dataMovie?.let {
            tvDetailTitle.text = it.title
            tvDetailDescription.text = it.description
            ivDetailPhoto.setImageResource(it.image)
            tvDetailTahun.text = it.tahun
            tvDetailRating.text = it.rating
            tvDetailDirector.text = "Director: ${it.director}"
            tvDetailWriter.text = "Writer: ${it.writer}"
        }

        val button = findViewById<ImageView>(R.id.imageView)
        button.setOnClickListener {
            finish()
        }

    }

    private fun shareMovieDetails(movieTitle: String, movieRating: String, movieDescription: String) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Check out this movie!")
            val shareMessage = "Movie Title: $title\n" +
                    "Rating: $movieRating\n" +
                    "Description: $movieDescription"
            putExtra(Intent.EXTRA_TEXT, shareMessage)
        }

        // Menjalankan intent share
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}