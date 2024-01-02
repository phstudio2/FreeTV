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

class Slovakia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_slovakia)

        val recyclerView: RecyclerView = findViewById(R.id.rvSlovakia)
        customAdapter = ItemAdapter(slovakiaList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(slovakiaList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@Slovakia, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@Slovakia, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(slovakiaList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(slovakiaList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in slovakiaList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val slovakiaList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        slovakiaList.add(
            Triple(
                "RTVS Jednotka",
                R.drawable.slovakia1,
                "https://yoink-that-stv-jgskjbq68tnj.runkit.sh/?x=1"
            )
        )
        slovakiaList.add(
            Triple(
                "RTVS Dvojka",
                R.drawable.slovakia2,
                "http://213.81.133.133:8080/dvojka/index.m3u8"
            )
        )
        slovakiaList.add(
            Triple(
                "RTVS 24",
                R.drawable.slovakia3,
                "https://yoink-that-stv-jgskjbq68tnj.runkit.sh/?x=3"
            )
        )
        slovakiaList.add(
            Triple(
                "RTVS Šport",
                R.drawable.slovakia4,
                "https://yoink-that-stv-jgskjbq68tnj.runkit.sh/?x=15"
            )
        )
        slovakiaList.add(
            Triple(
                "RTVS :O",
                R.drawable.slovakia5,
                "https://yoink-that-stv-jgskjbq68tnj.runkit.sh/?x=4"
            )
        )
        slovakiaList.add(
            Triple(
                "RTVS",
                R.drawable.slovakia6,
                "https://yoink-that-stv-jgskjbq68tnj.runkit.sh/?x=6"
            )
        )
        slovakiaList.add(
            Triple(
                "NR SR",
                R.drawable.slovakia7,
                "https://yoink-that-stv-jgskjbq68tnj.runkit.sh/?x=5"
            )
        )
        slovakiaList.add(
            Triple(
                "JOJ",
                R.drawable.slovakia8,
                "https://nn.geo.joj.sk/live/hls/joj-720.m3u8"
            )
        )
        slovakiaList.add(
            Triple(
                "JOJ Family",
                R.drawable.slovakia9,
                "https://live.cdn.joj.sk/live/hls/family-540.m3u8"
            )
        )
        slovakiaList.add(
            Triple(
                "JOJ Plus",
                R.drawable.slovakia10,
                "https://live.cdn.joj.sk/live/hls/jojplus-540.m3u8"
            )
        )
        slovakiaList.add(
            Triple(
                "JOJ WAU",
                R.drawable.slovakia11,
                "https://nn.geo.joj.sk/hls/wau-540.m3u8"
            )
        )
        slovakiaList.add(
            Triple(
                "Senzi",
                R.drawable.slovakia12,
                "http://lb.streaming.sk/senzi/stream/playlist.m3u8"
            )
        )
        slovakiaList.add(
            Triple(
                "TA3",
                R.drawable.slovakia13,
                "http://get-a-flippin-ta3-url-dss6dgprdpjf.runkit.sh/"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("Slovakia", num.toString(), url, "slovakia$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
