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

class Argentina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_argentina)

        val recyclerView: RecyclerView = findViewById(R.id.rvArgentina)
        customAdapter = ItemAdapter(argentinaList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(argentinaList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@Argentina, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@Argentina, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(argentinaList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(argentinaList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in argentinaList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val argentinaList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        argentinaList.add(
            Triple(
                "5RTV Santa Fe",
                R.drawable.argentina1,
                "https://api.new.livestream.com/accounts/22636012/events/8242619/live.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "FENIX TV",
                R.drawable.argentina2,
                "https://stmv1.questreaming.com/fenixlarioja/fenixlarioja/playlist.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "Argentinísima Satelital",
                R.drawable.argentina3,
                "https://stream1.sersat.com/hls/argentinisima.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "Canal 17 Milenium Salta",
                R.drawable.argentina4,
                "https://59c5c86e10038.streamlock.net/6605140/6605140/playlist.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "Encuentro",
                R.drawable.argentina5,
                "https://538d0bde28ccf.streamlock.net/live-cont.ar/encuentro/.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "Pakapaka",
                R.drawable.argentina6,
                "https://5fb24b460df87.streamlock.net/live-cont.ar/pakapaka/playlist.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "Televisión Pública",
                R.drawable.argentina7,
                "https://www.youtube.com/watch?v=MaO-W4Mi93I"
            )
        )
        argentinaList.add(
            Triple(
                "Crónica TV",
                R.drawable.argentina8,
                "https://www.youtube.com/watch?v=avly0uwZzOE"
            )
        )
        argentinaList.add(
            Triple(
                "C5N",
                R.drawable.argentina9,
                "https://ythls.armelin.one/channel/UCFgk2Q2mVO1BklRQhSv6p0w.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "C5N YouTube",
                R.drawable.argentina9,
                "https://www.youtube.com/watch?v=lOAt5-gi8t8"
            )
        )
        argentinaList.add(
            Triple(
                "LA NACION",
                R.drawable.argentina10,
                "https://ythls.armelin.one/channel/UCba3hpU7EFBSk817y9qZkiA.m3u8"
            )
        )
        argentinaList.add(
            Triple(
                "LA NACION - YouTube",
                R.drawable.argentina10,
                "https://www.youtube.com/watch?v=vfkUsBe_uBU"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("Argentina", num.toString(), url, "argentina$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}