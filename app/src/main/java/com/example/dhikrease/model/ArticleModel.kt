package com.example.dhikrease.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleModel(
    val imageArtikel: Int,
    val titleArtikel: String,
    val descArtikel: String
) : Parcelable