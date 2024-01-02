package com.phstudio.freetv.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_news)

        val recyclerView: RecyclerView = findViewById(R.id.rvNews)
        customAdapter = ItemAdapter(newsList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(newsList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@NewsActivity, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@NewsActivity, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(newsList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(newsList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in newsList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val newsList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        newsList.add(
            Triple(
                "Al Jazeera English",
                R.drawable.news1,
                "https://live-hls-web-aje.getaj.net/AJE/index.m3u8"
            )
        )
        newsList.add(
            Triple(
                "Al Jazeera Arabic",
                R.drawable.news2,
                "https://live-hls-web-aja.getaj.net/AJA/02.m3u8"
            )
        )
        newsList.add(
            Triple(
                "DW English",
                R.drawable.news3,
                "https://dwamdstream102.akamaized.net/hls/live/2015525/dwstream102/index.m3u8"
            )
        )
        newsList.add(
            Triple(
                "DW German",
                R.drawable.news4,
                "https://dwamdstream106.akamaized.net/hls/live/2017965/dwstream106/index.m3u8"
            )
        )
        newsList.add(
            Triple(
                "DW German+",
                R.drawable.news5,
                "https://dwamdstream105.akamaized.net/hls/live/2015531/dwstream105/index.m3u8"
            )
        )
        newsList.add(
            Triple(
                "DW Spanish",
                R.drawable.news6,
                "https://dwamdstream104.akamaized.net/hls/live/2015530/dwstream104/index.m3u8"
            )
        )
        newsList.add(
            Triple(
                "DW Arabic",
                R.drawable.news7,
                "https://dwamdstream103.akamaized.net/hls/live/2015526/dwstream103/index.m3u8"
            )
        )
        newsList.add(
            Triple(
                "France 24 English",
                R.drawable.news8,
                "https://www.youtube.com/c/FRANCE24English/live"
            )
        )
        newsList.add(
            Triple(
                "France 24 French",
                R.drawable.news9,
                "https://www.youtube.com/c/FRANCE24/live"
            )
        )
        newsList.add(
            Triple(
                "France 24 Spanish",
                R.drawable.news10,
                "https://www.youtube.com/watch?v=Y-IlMeCCtIg"
            )
        )
        newsList.add(
            Triple(
                "France 24 Arabic",
                R.drawable.news11,
                "https://www.youtube.com/c/FRANCE24Arabic/live"
            )
        )
        newsList.add(
            Triple(
                "Euronews English",
                R.drawable.news12,
                "https://www.youtube.com/watch?v=pykpO5kQJ98"
            )
        )
        newsList.add(
            Triple(
                "Euronews French",
                R.drawable.news13,
                "https://www.youtube.com/watch?v=NiRIbKwAejk"
            )
        )
        newsList.add(
            Triple(
                "Euronews Spanish",
                R.drawable.news14,
                "https://www.youtube.com/watch?v=O9mOtdZ-nSk"
            )
        )
        newsList.add(
            Triple(
                "Euronews Italian",
                R.drawable.news15,
                "https://www.youtube.com/watch?v=pUcmpyynASM"
            )
        )
        newsList.add(
            Triple(
                "Euronews Russian",
                R.drawable.news16,
                "https://www.youtube.com/watch?v=lwYzwdBiaho"
            )
        )
        newsList.add(
            Triple(
                "Euronews German",
                R.drawable.news17,
                "https://www.youtube.com/watch?v=CQ3KsEbsYHs"
            )
        )
        newsList.add(
            Triple(
                "Euronews Portuguese",
                R.drawable.news18,
                "https://www.youtube.com/watch?v=fLtn2L7OdeI"
            )
        )
        newsList.add(
            Triple(
                "Euronews Greek",
                R.drawable.news19,
                "https://www.youtube.com/watch?v=uWIhV9gQClg"
            )
        )
        newsList.add(
            Triple(
                "Euronews Hungarian",
                R.drawable.news20,
                "https://www.youtube.com/watch?v=jAn7L2Kt32U"
            )
        )
        newsList.add(
            Triple(
                "Africanews African",
                R.drawable.news21,
                "https://www.youtube.com/watch?v=NQjabLGdP5g"
            )
        )
        newsList.add(
            Triple(
                "Africanews French",
                R.drawable.news22,
                "https://www.youtube.com/watch?v=b6R9-7KZ8YM"
            )
        )
        newsList.add(
            Triple(
                "Sky News English",
                R.drawable.news23,
                "https://www.youtube.com/watch?v=w9uJg68CV4g"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("News", num.toString(), url, "news$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
