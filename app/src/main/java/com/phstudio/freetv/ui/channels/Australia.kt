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

class Australia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_australia)

        val recyclerView: RecyclerView = findViewById(R.id.rvAustralia)
        customAdapter = ItemAdapter(australiaList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(australiaList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@Australia, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@Australia, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(australiaList)
                favorite(stringList1[position], position + 1, stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(australiaList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in australiaList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val australiaList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        australiaList.add(
            Triple(
                "ABC 23",
                R.drawable.australia1,
                "https://content.uplynk.com/channel/ff809e6d9ec34109abfb333f0d4444b5.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "ABC Me",
                R.drawable.australia2,
                "https://c.mjh.nz/abc-me.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "ABC News",
                R.drawable.australia3,
                "https://manifest.googlevideo.com/api/manifest/hls_playlist/expire/1703888017/ei/MfCOZeK4K_eJsfIPr--XsA4/ip/13.83.3.160/id/n2UtfFiQb6U.4/itag/95/source/yt_live_broadcast/requiressl/yes/ratebypass/yes/live/1/sgoap/gir%3Dyes%3Bitag%3D140/sgovp/gir%3Dyes%3Bitag%3D136/rqh/1/hls_chunk_host/rr5---sn-n4v7snls.googlevideo.com/xpc/EgVo2aDSNQ%3D%3D/playlist_duration/30/manifest_duration/30/spc/UWF9fyb9J9aJTHceoTlN8tk31SNNK5E/vprv/1/playlist_type/DVR/mh/J4/mm/44/mn/sn-n4v7snls/ms/lva/mv/u/mvi/5/pl/23/dover/11/pacing/0/keepalive/yes/fexp/24007246/mt/1703865803/sparams/expire,ei,ip,id,itag,source,requiressl,ratebypass,live,sgoap,sgovp,rqh,xpc,playlist_duration,manifest_duration,spc,vprv,playlist_type/sig/AJfQdSswRAIgE7pFH8N7qyZ2yXmp9hWbuYFJpvxOh05F1sS9YSmJPlsCIHrOuMui2xdXQFNCILICII1m41AfpYF7wLk-fbv-uqsP/lsparams/hls_chunk_host,mh,mm,mn,ms,mv,mvi,pl/lsig/AAO5W4owRQIgEm4V5G7zi_oQ58M35vjse9tEgbLxXt3pQtMlX0Wr5RgCIQD6DSx8OQhTRWleo59qv0RFeJ09ByIkT5plC6uIMWN2lQ%3D%3D/playlist/index.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "ABC Au",
                R.drawable.australia4,
                "https://d9quh89lh7dtw.cloudfront.net/public-output/index.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "ABC AUSTRALIA",
                R.drawable.australia4,
                "http://dtv21.org:8080/play/live.php?mac=00:1A:79:00:21:D9&extension=ts&stream=283908"
            )
        )
        australiaList.add(
            Triple(
                "ABC Kids",
                R.drawable.australia5,
                "https://c.mjh.nz/abc-tv-plus.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "ABC News Australia",
                R.drawable.australia6,
                "https://abc-iview-mediapackagestreams-2.akamaized.net/out/v1/6e1cc6d25ec0480ea099a5399d73bc4b/index.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "ABC TV Plus",
                R.drawable.australia7,
                "https://c.mjh.nz/abc-tv-plus.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Ausbiz TV",
                R.drawable.australia8,
                "https://d9quh89lh7dtw.cloudfront.net/public-output/index.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Aus Tamil",
                R.drawable.australia9,
                "https://bk7l2pn7dx53-hls-live.5centscdn.com/austamil/fe01ce2a7fbac8fafaed7c982a04e229.sdp/playlist.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Horse and Country",
                R.drawable.australia10,
                "https://hncfree-samsungau.amagi.tv/playlist.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "JonmoBhumi TV",
                R.drawable.australia11,
                "https://dai.google.com/linear/hls/event/-V3XSvA2Sa6e8h7cnHXB8w/master.m3u8\n"
            )
        )
        australiaList.add(
            Triple(
                "Juice TV",
                R.drawable.australia12,
                "https://juicex.nz/hls/mystream.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "M4TV Malayalam",
                R.drawable.australia13,
                "https://app.m4stream.live/mfourmalayalamhls/live.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Real Stories",
                R.drawable.australia14,
                "https://lds-realstories-samsungau.amagi.tv/playlist.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Ryan and Friends",
                R.drawable.australia15,
                "https://ryanandfriends-samsungau.amagi.tv/playlist.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Time Line Australia",
                R.drawable.australia16,
                "https://lds-timeline-samsungau.amagi.tv/playlist.m3u8"
            )
        )
        australiaList.add(
            Triple(
                "Wonder",
                R.drawable.australia17,
                "https://lds-wonder-samsungau.amagi.tv/playlist.m3u8"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("Australia", num.toString(), url, "australia$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}