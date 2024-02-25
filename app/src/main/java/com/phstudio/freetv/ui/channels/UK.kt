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
import com.phstudio.freetv.ui.ItemAdapter.*


class UK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_uk)

        val recyclerView: RecyclerView = findViewById(R.id.rvUK)
        customAdapter = ItemAdapter(UKList, object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(UKList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@UK, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@UK, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(UKList)
                favorite(stringList1[position], stringList2[position])

                return true
            }
        })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun splitList(UKList: ArrayList<Triple<String, Int, String>>): Triple<ArrayList<String>, ArrayList<Int>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<Int>()
        val stringList2 = ArrayList<String>()

        for (pair in UKList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val UKList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        UKList.add(
            Triple(
                "Animal Planet",
                R.drawable.image,
                "http://cineapp.org:8000/Fernando/Fernando/314?checkedby:iptvcat.com"
            )
        )
        UKList.add(
            Triple(
                "Access Sacramento Channel 17",
                R.drawable.image,
                "https://reflect-access-sacramento.cablecast.tv/live-7/live/live.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Access Sacramento Channel 18",
                R.drawable.image,
                "https://reflect-access-sacramento.cablecast.tv/live-8/live/live.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Action Hollywood Movies",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg01076-lightningintern-actionhollywood-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Ahlulbayt TV",
                R.drawable.image,
                "https://5f3e23ac71915.streamlock.net:4434/live/livestream1.sdp/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "BBC 1",
                R.drawable.image,
                "http://cineapp.org:8000/Fernando/Fernando/318"
            )
        )
        UKList.add(
            Triple(
                "BBC 2",
                R.drawable.image,
                "http://cineapp.org:8000/Fernando/Fernando/317"
            )
        )
        UKList.add(
            Triple(
                "BBC Arabic",
                R.drawable.image,
                "https://vs-cmaf-pushb-ww.live.cf.md.bbci.co.uk/x=3/i=urn:bbc:pips:service:bbc_arabic_tv/pc_hd_abr_v2_cloudfrontms_live.mpd"
            )
        )
        UKList.add(
            Triple(
                "BBC Persian",
                R.drawable.image,
                "https://vs-cmaf-pushb-ww.live.cf.md.bbci.co.uk/x=3/i=urn:bbc:pips:service:bbc_persian_tv/pc_hd_abr_v2_cloudfrontms_live_http.mpd"
            )
        )
        UKList.add(
            Triple(
                "Bloomberg Quicktake",
                R.drawable.image,
                "https://bloomberg-quicktake-4-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Bloomberg TV",
                R.drawable.image,
                "https://bloomberg-bloomberg-2-nz.samsung.wurl.tv/playlist.m3u8<"
            )
        )
        UKList.add(
            Triple(
                "Bloomberg TV+",
                R.drawable.image,
                "https://bloomberg-bloombergtv-3-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Bloomberg TV Europe",
                R.drawable.image,
                "https://bloomberg-bloombergtv-1-it.samsung.wurl.com/manifest/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Bloomberg TV EMEA Live Event",
                R.drawable.image,
                "https://www.bloomberg.com/media-manifest/streams/eu-event.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Bounty",
                R.drawable.image,
                "https://bountyfilms-bounty-1-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "CineView",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg01076-lightningintern-rialto-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Clubbing TV",
                R.drawable.image,
                "https://clubbingtv-samsungnz.amagi.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Craft Store TV",
                R.drawable.image,
                "https://live-hochanda.simplestreamcdn.com/hochanda/live.m3u8"
            )
        )
        UKList.add(
            Triple(
                "DISNEY CHANNEL",
                R.drawable.image,
                "http://cineapp.org:8000/Fernando/Fernando/286"
            )
        )
        UKList.add(
            Triple(
                "DISNEY JUNIOR",
                R.drawable.image,
                "http://cineapp.org:8000/Fernando/Fernando/5626"
            )
        )
        UKList.add(
            Triple(
                "Deluxe Lounge",
                R.drawable.image,
                "https://d46c0ebf9ef94053848fdd7b1f2f6b90.mediatailor.eu-central-1.amazonaws.com/v1/master/81bfcafb76f9c947b24574657a9ce7fe14ad75c0/live-prod/9a087b26-8be4-11eb-a7de-bacfe1f83627/0/master.m3u8?country=DE&optout=0&uid=749544ec3d9a45d48c600d03cac91dfd&vendor=philips"
            )
        )
        UKList.add(
            Triple(
                "Discover Film",
                R.drawable.image,
                "https://discoverfilm-discoverfilm-1-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Drybar Comedy",
                R.drawable.image,
                "https://drybar-drybarcomedy-1-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Dust",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg00219-gunpowdersky-dustintlnz-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "FOX",
                R.drawable.image,
                "http://cineapp.org:8000/Fernando/Fernando/16715"
            )
        )
        UKList.add(
            Triple(
                "GemsTV",
                R.drawable.image,
                "http://57d6b85685bb8.streamlock.net:1935/abrgemporiaukgfx/livestream_360p/index.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Gigant FM",
                R.drawable.image,
                "https://video.uitzending.tv:19360/gigantfm/gigantfm.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Hell\\'s Kitchen",
                R.drawable.image,
                "https://cdn-uw2-prod.tsv2.amagi.tv/linear/amg00654-itvstudios-hellskitchennl-samsungnl/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "InWonder",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg00861-terninternation-inwondernz-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Insight TV",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg00861-terninternation-insighttvrow-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Introuble",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg00861-terninternation-introublenz-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Jewlery Maker",
                R.drawable.image,
                "https://lo2-1.gemporia.com/abrjewellerymaker/smil:livestream.smil/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Kanshi TV",
                R.drawable.image,
                "http://live.kanshitv.co.uk/mobile/kanshitvkey.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Kartoon Channel",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg01076-lightningintern-kartoonchannel-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "LOL!",
                R.drawable.image,
                "https://lol-lolnetwork-2-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Love Stories TV",
                R.drawable.image,
                "https://lovestoriestv-lovestoriestv-1-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "METV (Merced Educational Television)",
                R.drawable.image,
                "https://mercedcouedu.secure.footprint.net/egress/bhandler/mercedcouedu/streamc/chunklist_b1192000.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Made in Hollywood",
                R.drawable.image,
                "https://connection3-ent-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Magellen TV",
                R.drawable.image,
                "https://magellantv-3-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Marin TV Education",
                R.drawable.image,
                "https://dacastmmd.mmdlive.lldns.net/dacastmmd/8e6d110b223b4aca9dd6f7c368baec07/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Marin TV Government Channel",
                R.drawable.image,
                "https://dacastmmd.mmdlive.lldns.net/dacastmmd/ddf2a073e3da4acb9feb34bef6d58672/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Mav TV Motorsports Network",
                R.drawable.image,
                "https://mavtv-mavtvglobal-1-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Mobile County Public Schools TV Network (MCPSS)",
                R.drawable.image,
                "https://5b200f5268ceb.streamlock.net/MCPSS/MCPSS247.smil/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Mojitv",
                R.drawable.image,
                "https://odmedia-mojitv-1-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Motorvision TV",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg01329-otterainc-motorvisionnz-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Mtrspt 1",
                R.drawable.image,
                "https://kravemedia-mtrspt1-1-nz.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "MyZen TV",
                R.drawable.image,
                "https://cdn-ue1-prod.tsv2.amagi.tv/linear/amg01255-secomcofites-my-myzen-en-plex/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "NCM Educational & Kid",
                R.drawable.image,
                "https://cdn3.wowza.com/5/cHYzekYzM2kvTVFH/nevco/G0644_005/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "NCM Government & Politics",
                R.drawable.image,
                "https://cdn3.wowza.com/5/cHYzekYzM2kvTVFH/nevco/G0644_002/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "NCM KodiTvMain Channel",
                R.drawable.image,
                "https://cdn3.wowza.com/5/cHYzekYzM2kvTVFH/nevco/G0644_001/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "PBS America",
                R.drawable.image,
                "https://pbs-samsunguk.amagi.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Pet Club TV",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg01076-lightningintern-petclub-samsungnz/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "QVC",
                R.drawable.image,
                "https://d1txbbj1u9asam.cloudfront.net/live/qvcuk_main_clean/bitrate1.isml/3/prog_index.m3u8"
            )
        )
        UKList.add(
            Triple(
                "QVC Beauty",
                R.drawable.image,
                "http://live.qvcuk.simplestreamcdn.com/live/qvcuk_beauty_clean/bitrate1.isml/live.m3u8"
            )
        )
        UKList.add(
            Triple(
                "QVC Style",
                R.drawable.image,
                "http://live.qvcuk.simplestreamcdn.com/live/qvcuk_style_clean/bitrate1.isml/live.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Sofy TV",
                R.drawable.image,
                "https://cdn-uw2-prod.tsv2.amagi.tv/linear/amg00535-largofilmsltdli-sofytvnl-samsungnl/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Sporty Stuff TV",
                R.drawable.image,
                "https://ayozat-live.secure2.footprint.net/egress/bhandler/ayozat/sportystufftv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "The Guardian",
                R.drawable.image,
                "https://rakuten-guardian-1-nl.samsung.wurl.tv/playlist.m3u8"
            )
        )
        UKList.add(
            Triple(
                "Timeline",
                R.drawable.image,
                "https://cdn-apse1-prod.tsv2.amagi.tv/linear/amg00426-littledotstudio-timelinenz-samsungnz/playlist.m3u8"
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
