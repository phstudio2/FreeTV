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

class Czech : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_czech)

        val recyclerView: RecyclerView = findViewById(R.id.rvCzech)
        customAdapter = ItemAdapter(czechList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(czechList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com") || url.contains("https://www.televizeseznam.cz/tv")) {
                    val intent = Intent(this@Czech, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@Czech, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(czechList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(czechList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in czechList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val czechList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        czechList.add(
            Triple(
                "Prima",
                R.drawable.cz1,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_family/playlist/cze/live_hq.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "CNN Prima News",
                R.drawable.cz2,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_cnn/playlist/cze/live_hd.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima Zoom",
                R.drawable.cz3,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_zoom/playlist/cze/live_hq.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima Love",
                R.drawable.cz4,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_love/playlist/cze/live_hq.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima STAR",
                R.drawable.cz5,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_star/playlist/cze/live_hq.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima Krimi",
                R.drawable.cz6,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_krimi/playlist/cze/live_hq.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima MAX",
                R.drawable.cz7,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_max/playlist/cze/live_hq.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima Cool",
                R.drawable.cz8,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_cool/playlist/cze/live_hd.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Prima Show",
                R.drawable.cz9,
                "https://prima-ott-live.ssl.cdn.cra.cz/channels/prima_show/playlist/cze/live_hd.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Óčko",
                R.drawable.cz10,
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko/playlist.m3u8"
            )
        )
        czechList.add(
            Triple(
                "Óčko Star",
                R.drawable.cz11,
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko_gold/playlist.m3u8"
            )
        )
        czechList.add(
            Triple(
                "Óčko Expres",
                R.drawable.cz12,
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko_expres/playlist.m3u8"
            )
        )
        czechList.add(
            Triple(
                "TV Seznam",
                R.drawable.cz13,
                "https://www.televizeseznam.cz/tv"
            )
        )
        czechList.add(
            Triple(
                "ČT1",
                R.drawable.cz14,
                "https://sktv-forwarders.7m.pl/get.php?x=CT1"
            )
        )
        czechList.add(
            Triple(
                "ČT2",
                R.drawable.cz15,
                "https://sktv-forwarders.7m.pl/get.php?x=CT2"
            )
        )
        czechList.add(
            Triple(
                "ČT24",
                R.drawable.cz17,
                "https://sktv-forwarders.7m.pl/get.php?x=CT24"
            )
        )
        czechList.add(
            Triple(
                "ČT sport",
                R.drawable.cz18,
                "https://sktv-forwarders.7m.pl/get.php?x=CTsport"
            )
        )
        czechList.add(
            Triple(
                "ČT :D",
                R.drawable.cz19,
                "https://sktv-forwarders.7m.pl/get.php?x=CT_D"
            )
        )
        czechList.add(
            Triple(
                "ČT art",
                R.drawable.cz20,
                "https://sktv-forwarders.7m.pl/get.php?x=CTart"
            )
        )
        czechList.add(
            Triple(
                "Retro Music Television",
                R.drawable.cz21,
                "https://stream.mediawork.cz/retrotv/smil:retrotv2.smil/playlist.m3u8"
            )
        )
        czechList.add(
            Triple(
                "Šlágr Originál",
                R.drawable.cz22,
                "https://stream-13.mazana.tv/slagroriginal.m3u8s"
            )
        )
        czechList.add(
            Triple(
                "Šlágr Muzika",
                R.drawable.cz23,
                "https://stream-23.mazana.tv/slagrmuzika.m3u8s"
            )
        )
        czechList.add(
            Triple(
                "Šlágr Premium",
                R.drawable.cz24,
                "https://stream-17.mazana.tv/slagrpremium.m3u8s"
            )
        )
        czechList.add(
            Triple(
                "Východočeská TV",
                R.drawable.cz25,
                "https://stream.polar.cz/vctv/vctvlive-1/playlist.m3u8"
            )
        )
        czechList.add(
            Triple(
                "Praha TV",
                R.drawable.image,
                "https://stream.polar.cz/prahatv/prahatvlive-1/playlist.m3u8"
            )
        )
        czechList.add(
            Triple(
                "TN LIVE",
                R.drawable.image,
                "https://nova-ott-live-tn-sec.ssl.cdn.cra.cz/70xNRw9kiZs9EUkDVaUZTw==,1703883594/channels/nova-news/playlist/cze/live_hd.m3u8?offsetSeconds=0&url=0"
            )
        )
        czechList.add(
            Triple(
                "Mňau TV",
                R.drawable.image,
                "https://5ca49f2417d90.streamlock.net/mnau/livestream/playlist.m3u8"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("Czech", num.toString(), url, "cz$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}