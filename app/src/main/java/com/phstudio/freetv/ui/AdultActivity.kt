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


class AdultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_adult)

        val recyclerView: RecyclerView = findViewById(R.id.rvAdult)
        customAdapter = ItemAdapter(adultList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(adultList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@AdultActivity, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@AdultActivity, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(adultList)
                favorite(stringList1[position], stringList2[position])

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

    private val adultList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        adultList.add(
            Triple(
                "Teen",
                R.drawable.p1,
                "https://live.redtraffic.xyz/teen.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Pornstar",
                R.drawable.p2,
                "https://live.redtraffic.xyz/pornstar.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Big Ass",
                R.drawable.p3,
                "https://live.redtraffic.xyz/bigass.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Fetish",
                R.drawable.p4,
                "https://live.redtraffic.xyz/fetish.m3u8"
            )
        )
        adultList.add(
            Triple(
                "MILF",
                R.drawable.p5,
                "https://live.redtraffic.xyz/milf.m3u8"
            )
        )
        adultList.add(
            Triple(
                "POV",
                R.drawable.p6,
                "https://live.redtraffic.xyz/pov.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Big Dick",
                R.drawable.p7,
                "https://live.redtraffic.xyz/bigdick.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Big Tits",
                R.drawable.p8,
                "https://live.redtraffic.xyz/bigtits.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Interracial",
                R.drawable.p9,
                "https://live.redtraffic.xyz/interracial.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Anal",
                R.drawable.p10,
                "https://live.redtraffic.xyz/anal.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Blowjob",
                R.drawable.p11,
                "https://live.redtraffic.xyz/blowjob.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Hardcore",
                R.drawable.p12,
                "https://live.redtraffic.xyz/hardcore.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Cuckold",
                R.drawable.p13,
                "https://live.redtraffic.xyz/cuckold.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Threesome",
                R.drawable.p14,
                "https://live.redtraffic.xyz/threesome.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Lesbian",
                R.drawable.p15,
                "https://live.redtraffic.xyz/lesbian.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Gangbang",
                R.drawable.p16,
                "https://live.redtraffic.xyz/gangbang.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Brunette",
                R.drawable.p17,
                "https://live.redtraffic.xyz/brunette.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Blonde",
                R.drawable.p18,
                "https://live.redtraffic.xyz/blonde.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Rough",
                R.drawable.p19,
                "https://live.redtraffic.xyz/rough.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Compilation",
                R.drawable.p20,
                "https://live.redtraffic.xyz/compilation.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Livecams",
                R.drawable.p21,
                "https://live.redtraffic.xyz/livecams.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Latina",
                R.drawable.p22,
                "https://live.redtraffic.xyz/latina.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Russian",
                R.drawable.p23,
                "https://live.redtraffic.xyz/russian.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Asian",
                R.drawable.p24,
                "https://live.redtraffic.xyz/asian.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Fashion TV Midnite Secrets",
                R.drawable.p25,
                "https://fash1043.cloudycdn.services/slive/ftv_ftv_midnite_k1y_27049_midnite_secr_108_hls.smil/playlist.m3u8"
            )
        )
        adultList.add(
            Triple(
                "REDLIGHT",
                R.drawable.p28,
                "https://cdn-main.lolokoko.tv/REDLIGHT.stream/chunks.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Brazzers TV Europe",
                R.drawable.image,
                "https://cdn-main.lolokoko.tv/BRAZZERS.stream/chunks.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Dorcel TV",
                R.drawable.image,
                "https://cdn-main.lolokoko.tv/DorcelTV.stream/playlist.m3u8"
            )
        )
        adultList.add(
            Triple(
                "Hustler TV",
                R.drawable.image,
                "https://cdn-main.lolokoko.tv/HUSTLER.stream/chunks.m3u8"
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
