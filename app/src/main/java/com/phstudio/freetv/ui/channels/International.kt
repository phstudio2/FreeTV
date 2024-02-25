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

class International : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_international)

        val recyclerView: RecyclerView = findViewById(R.id.rvInternational)
        customAdapter = ItemAdapter(internationalList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(internationalList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@International, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@International, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(internationalList)
                favorite(stringList1[position], stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(internationalList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in internationalList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val internationalList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        internationalList.add(
            Triple(
                "Red Bull TV",
                R.drawable.international1,
                "https://rbmn-live.akamaized.net/hls/live/590964/BoRB-AT/master.m3u8"
            )
        )
        internationalList.add(
            Triple(
                "TRT World",
                R.drawable.international2,
                "https://tv-trtworld.live.trt.com.tr/master.m3u8"
            )
        )
        internationalList.add(
            Triple(
                "World Fashion Channel",
                R.drawable.international3,
                "https://live-3.otcnet.ru/wfc-int-master/tracks-v1a1/mono.m3u8"
            )
        )
        internationalList.add(
            Triple(
                "Failarmy International",
                R.drawable.international4,
                "https://failarmy-international-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        internationalList.add(
            Triple(
                "Iran International",
                R.drawable.international5,
                "https://dev-live.livetvstream.co.uk/LS-63503-4/index.m3u8"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, url: String) {
        val db = Database(this, null)
        db.writeToDb(name, "", url)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
