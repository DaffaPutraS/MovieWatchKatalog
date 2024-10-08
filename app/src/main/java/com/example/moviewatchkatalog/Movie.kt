package com.example.moviewatchkatalog

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val image: Int,
    val tahun: String,
    val rating: String,
    val director: String,
    val writer: String
) : Parcelable