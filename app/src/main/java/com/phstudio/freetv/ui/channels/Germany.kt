package com.phstudio.freetv.ui.channels

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
import com.phstudio.freetv.ui.ItemAdapter


class Germany : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_germany)

        val recyclerView: RecyclerView = findViewById(R.id.rvGermany)
        customAdapter = ItemAdapter(germanyList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(germanyList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@Germany, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@Germany, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(germanyList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(germanyList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in germanyList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val germanyList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        germanyList.add(
            Triple(
                "Das Erste",
                R.drawable.image,
                "https://mcdn.daserste.de/daserste/de/master.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "WDR",
                R.drawable.image,
                "https://mcdn.wdr.de/wdr/wdrfs/de/master.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "HR",
                R.drawable.image,
                "https://hrhls.akamaized.net/hls/live/2024525/hrhls/master.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "BR Nord",
                R.drawable.image,
                "http://brlive-lh.akamaihd.net/i/bfsnord_germany@119898/master.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "Tagesschau24",
                R.drawable.image,
                "https://tagesschau.akamaized.net/hls/live/2020115/tagesschau/tagesschau_1/master.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "ARD Alpha",
                R.drawable.image,
                "http://brlive-lh.akamaihd.net/i/bralpha_germany@119899/master.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "Deluxe Music",
                R.drawable.image,
                "https://sdn-global-live-streaming-packager-cache.3qsdn.com/13456/13456_264_live.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "Euronews Deutsch",
                R.drawable.news13,
                "https://www.youtube.com/watch?v=CQ3KsEbsYHs"
            )
        )
        germanyList.add(
            Triple(
                "SYFY",
                R.drawable.image,
                "https://srv4.zcast.com.br/tvnovaplay/tvnovaplay/playlist.m3u8"
            )
        )
        germanyList.add(
            Triple(
                "SIXX",
                R.drawable.image,
                "https://5db313b643fd8.streamlock.net/SUPERSIXLombardia/SUPERSIXLombardia/playlist.m3u8"
            )
        )
        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("Germany", num.toString(), url, "image", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }

}
