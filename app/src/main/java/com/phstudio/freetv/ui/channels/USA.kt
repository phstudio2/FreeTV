package com.phstudio.freetv.ui.channels

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity
import com.phstudio.freetv.ui.ItemAdapter

class USA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_usa)

        val recyclerView: RecyclerView = findViewById(R.id.rvUSA)
        customAdapter = ItemAdapter(USAList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(USAList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@USA, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@USA, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(USAList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(USAList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in USAList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val USAList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        USAList.add(
            Triple(
                "CNN",
                R.drawable.usa1,
                "https://turnerlive.warnermediacdn.com/hls/live/586495/cnngo/cnn_slate/VIDEO_0_3564000.m3u8"
            )
        )
        USAList.add(
            Triple(
                "ABC News",
                R.drawable.usa2,
                "https://content.uplynk.com/channel/3324f2467c414329b3b0cc5cd987b6be.m3u8"
            )
        )
        USAList.add(
            Triple(
                "Reuters TV",
                R.drawable.usa3,
                "https://reuters-reutersnow-1-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        USAList.add(
            Triple(
                "NASA TV Public",
                R.drawable.usa4,
                "https://ntv1.akamaized.net/hls/live/2014075/NASA-NTV1-HLS/master_2000.m3u8"
            )
        )
        USAList.add(
            Triple(
                "NASA TV Media",
                R.drawable.usa5,
                "https://ntv2.akamaized.net/hls/live/2013923/NASA-NTV2-HLS/master.m3u8"
            )
        )
        USAList.add(
            Triple(
                "BBC Food",
                R.drawable.usa6,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5fb5844bf5514d0007945bda/master.m3u8?deviceId=channel&deviceModel=web&deviceVersion=1.0&appVersion=1.0&deviceType=rokuChannel&deviceMake=rokuChannel&deviceDNT=1&advertisingId=channel&embedPartner=rokuChannel&appName=rokuchannel&is_lat=1&bmodel=bm1&content=channel&platform=web&tags=ROKU_CONTENT_TAGS&coppa=false&content_type=livefeed&rdid=channel&genre=ROKU_ADS_CONTENT_GENRE&content_rating=ROKU_ADS_CONTENT_RATING&studio_id=viacom&channel_id=channel"
            )
        )
        USAList.add(
            Triple(
                "BBC Home",
                R.drawable.usa7,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5fb5836fe745b600070fc743/master.m3u8?deviceId=channel&deviceModel=web&deviceVersion=1.0&appVersion=1.0&deviceType=rokuChannel&deviceMake=rokuChannel&deviceDNT=1&advertisingId=channel&embedPartner=rokuChannel&appName=rokuchannel&is_lat=1&bmodel=bm1&content=channel&platform=web&tags=ROKU_CONTENT_TAGS&coppa=false&content_type=livefeed&rdid=channel&genre=ROKU_ADS_CONTENT_GENRE&content_rating=ROKU_ADS_CONTENT_RATING&studio_id=viacom&channel_id=channel"
            )
        )
        USAList.add(
            Triple(
                "CCX Media Minnesota",
                R.drawable.usa8,
                "https://content.uplynk.com/channel/4bb4901b934c4e029fd4c1abfc766c37.m3u8"
            )
        )
        USAList.add(
            Triple(
                "Newsy",
                R.drawable.usa9,
                "https://d3ra88okaj5j4j.cloudfront.net/out/v1/e3e6e29095844c4ba7d887f01e44a5ef/index.m3u8"
            )
        )
        USAList.add(
            Triple(
                "Retro TV",
                R.drawable.usa10,
                "https://cdn.igocast.com/channel9_hls/channel9_master.m3u8"
            )
        )
        USAList.add(
            Triple(
                "Heartland",
                R.drawable.usa11,
                "https://d76toswjmqqzm.cloudfront.net/playlist.m3u8"
            )
        )
        USAList.add(
            Triple(
                "Rev'n",
                R.drawable.usa12,
                "https://cdn.igocast.com/channel7_hls/channel7_master.m3u8"
            )
        )
        USAList.add(
            Triple(
                "23 ABC (KERO)",
                R.drawable.usa13,
                "https://content.uplynk.com/channel/ff809e6d9ec34109abfb333f0d4444b5.m3u8"
            )
        )
        USAList.add(
            Triple(
                "30A TV",
                R.drawable.usa14,
                "https://30a-tv.com/my999.m3u8"
            )
        )
        USAList.add(
            Triple(
                "30A Investment Pitch",
                R.drawable.usa15,
                "https://www.30a-tv.com/InvPit.m3u8"
            )
        )
        USAList.add(
            Triple(
                "30A Sidewalks",
                R.drawable.usa16,
                "https://30a-tv.com/sidewalks.m3u8"
            )
        )
        USAList.add(
            Triple(
                "AKC TV",
                R.drawable.usa17,
                "https://install.akctvcontrol.com/speed/broadcast/138/desktop-playlist.m3u8"
            )
        )
        USAList.add(
            Triple(
                "American Horrors",
                R.drawable.usa18,
                "https://linear-82.frequency.stream/dist/localnow/82/hls/master/playlist.m3u8"
            )
        )
        USAList.add(
            Triple(
                "Darcizzle Offshore",
                R.drawable.usa19,
                "http://30a-tv.com/darcizzle.m3u8"
            )
        )
        USAList.add(
            Triple(
                "CBS 3 KMTV",
                R.drawable.usa20,
                "http://content.uplynk.com/channel/328d1434fb51476cb6567c74d5b2cc70.m3u8"
            )
        )
        USAList.add(
            Triple(
                "CNBC",
                R.drawable.usa23,
                "https://www.youtube.com/watch?v=9NyxcX3rhQs"
            )
        )
        USAList.add(
            Triple(
                "CBS News",
                R.drawable.usa24,
                "https://www.youtube.com/watch?v=L7nhXGJEBPg"
            )
        )
        USAList.add(
            Triple(
                "Bloomberg",
                R.drawable.usa25,
                "https://www.youtube.com/watch?v=iyOq8DhaMYw"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("USA", num.toString(), url, "usa$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}