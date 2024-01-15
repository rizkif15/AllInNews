package com.rizkifauzi.allinnews_rizkifauzi_submissionandroidpemula_dicoding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_NEWS = "key_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataNews = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<News>(KEY_NEWS, News::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<News>(KEY_NEWS)
        }

        val tvDetailName = findViewById<TextView>(R.id.tv_detail_name)
        val tvDetailDescription = findViewById<TextView>(R.id.tv_detail_description)
        val ivDetailPhoto = findViewById<ImageView>(R.id.iv_detail_photo)

        if (dataNews != null) {
            tvDetailName.text = dataNews.title
            tvDetailDescription.text = dataNews.description
            ivDetailPhoto.setImageResource(dataNews.photo)
        }
    }
}