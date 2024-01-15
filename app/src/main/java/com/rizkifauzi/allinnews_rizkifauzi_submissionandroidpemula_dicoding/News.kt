package com.rizkifauzi.allinnews_rizkifauzi_submissionandroidpemula_dicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val description: String,
    val photo: Int
) : Parcelable
