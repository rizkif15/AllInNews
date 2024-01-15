package com.rizkifauzi.allinnews_rizkifauzi_submissionandroidpemula_dicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Intent untuk berpindah ke MainActivity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            // Tutup SplashActivity agar tidak dapat diakses lagi dengan tombol kembali
            finish()
        }, SPLASH_TIME_OUT)
    }
}