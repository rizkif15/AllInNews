package com.rizkifauzi.allinnews_rizkifauzi_submissionandroidpemula_dicoding

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvNews: RecyclerView
    private val list = ArrayList<News>()

    //val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNews = findViewById(R.id.rv_news)
        rvNews.setHasFixedSize(true)

        list.addAll(getListNews())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvNews.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    rvNews.layoutManager = GridLayoutManager(this, 2)
                }
            }
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListNews(): ArrayList<News> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listNews = ArrayList<News>()
        for (i in dataName.indices) {
            val news = News(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listNews.add(news)
        }
        return listNews
    }

    private fun showRecyclerList() {
        rvNews.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListNewsAdapter(list)
        rvNews.adapter = listHeroAdapter
    }

}