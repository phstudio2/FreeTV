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


class MusicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_music)

        val recyclerView: RecyclerView = findViewById(R.id.rvMusic)
        customAdapter = ItemAdapter(musicList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(musicList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@MusicActivity, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@MusicActivity, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(musicList)
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

    private val musicList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        musicList.add(
            Triple(
                "Afrobeats",
                R.drawable.music1,
                "https://stream.ecable.tv/afrobeats/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Artist Aloud",
                R.drawable.music2,
                "https://live.hungama.com/linear/artist-aloud/playlist.m3u8" //nejde
            )
        )
        musicList.add(
            Triple(
                "88 Stereo",
                R.drawable.music3,
                "http://k3.usastreams.com/CableLatino/88stereo/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "1HD Music Television",
                R.drawable.music4,
                "http://103.199.161.254/Content/7smusic/Live/Channel(7smusic)/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "30A Music",
                R.drawable.music5,
                "https://30a-tv.com/music.m3u8"
            )
        )
        musicList.add(
            Triple(
                "9XM",
                R.drawable.music6,
                "https://d2q8p4pe5spbak.cloudfront.net/bpk-tv/9XM/9XM.isml/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "101 Tele Antequera",
                R.drawable.music7,
                "https://limited38.todostreaming.es/live/101tv-AntequeraHD.m3u8"
            )
        )
        musicList.add(
            Triple(
                "A2i Music",
                R.drawable.music8,
                "https://stream.sen-gt.com/A2iMusic/myStream/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "A Son de Salsa",
                R.drawable.music9,
                "https://cloud01.mipaneltv.xyz/asondesalsa/asondesalsa/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Activa TV",
                R.drawable.music10,
                "https://streamtv.mediasector.es/hls/activatv/.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Arabica TV",
                R.drawable.music11,
                "http://istream.binarywaves.com:8081/hls/arabica/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Baeble Music",
                R.drawable.music12,
                "https://dai2.xumo.com/amagi_hls_data_xumo1212A-redboxbaeble/CDN/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Baraza TV",
                R.drawable.music13,
                "https://eco.streams.ovh/BarazaTV/BarazarazaTV/BarazaTV/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Barbud Music",
                R.drawable.music14,
                "https://raw.githubusercontent.com/taodicakhia/IPTV_Exception/master/channels/af/tolomusic.m3u8" //nejde
            )
        )
        musicList.add(
            Triple(
                "Beats Radio",
                R.drawable.music15,
                "https://59537faa0729a.streamlock.net/beatsradio/beatsradio/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Best Cable Más Cumbia",
                R.drawable.music16,
                "https://tv.inka.net.pe/mascumbiatvonline/mascumbiatvonline/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Best Cable Music",
                R.drawable.music17,
                "https://tv.inka.net.pe/bestcablemusic/bestcablemusic/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Bibel TV Musik",
                R.drawable.music18,
                "http://bibeltv03.iptv-playoutcenter.de/bibeltv03/bibeltv03.stream_1/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Carolina TV",
                R.drawable.music19,
                "https://unlimited1-us.dps.live/carolinatv/carolinatv.smil/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Dhamaal",
                R.drawable.music20,
                "https://live.hungama.com/linear/dhamaal/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Galáctica TV (Peru)",
                R.drawable.music21,
                "https://pacific.direcnode.com:3715/hybrid/play.m3u8"
            )
        )
        musicList.add(
            Triple(
                "High Vision",
                R.drawable.music22,
                "https://streamer1.connectto.com/HIGHVISION_WEB_1205/tracks-v1a1/mono.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Huila TV",
                R.drawable.music23,
                "https://plataformavideo.com:19360/8020/8020.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Kadak Hits",
                R.drawable.music24,
                "https://live.hungama.com/linear/kadak-hits/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Kronehit",
                R.drawable.music25,
                "https://bitcdn-kronehit.bitmovin.com/v2/hls/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "MBC FM",
                R.drawable.music26,
                "ttps://mbcfm-riyadh-prod-dub.shahid.net/out/v1/69c8a03f507e422f99cf5c07291c9e3a/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "MCM Top",
                R.drawable.music27,
                "http://ott-cdn.ucom.am/s49/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "MCN6 Music Channel",
                R.drawable.music28,
                "https://5b464b69d264e.streamlock.net/Channels_live/ngrp:MelodyChannel_all/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Mnet",
                R.drawable.music29,
                "https://allanf181.github.io/adaptive-streams/streams/kr/Mnet.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Óčko",
                R.drawable.music30,
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Óčko Expres",
                R.drawable.music31,
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko_expres/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Óčko Gold",
                R.drawable.music32,
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko_gold/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Panorama FM",
                R.drawable.music33,
                "https://shls-panoramafm-prod-dub.shahid.net/out/v1/66262e420d824475aaae794dc2d69f14/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Pluto TV VEVO 2K",
                R.drawable.music34,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5fd7bca3e0a4ee0007a38e8c/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        musicList.add(
            Triple(
                "Pluto TV VEVO 70's",
                R.drawable.music35,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5f32f26bcd8aea00071240e5/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        musicList.add(
            Triple(
                "Pluto TV VEVO 90's",
                R.drawable.music36,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5fd7bb1f86d94a000796e2c2/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        musicList.add(
            Triple(
                "Pluto TV VEVO Country",
                R.drawable.music37,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5da0d75e84830900098a1ea0/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        musicList.add(
            Triple(
                "Pluto TV VEVO R&B",
                R.drawable.music38,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5da0d83f66c9700009b96d0e/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        musicList.add(
            Triple(
                "Pluto TV VEVO Reggeaton & Trap",
                R.drawable.music39,
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5f32f397795b750007706448/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        musicList.add(
            Triple(
                "PMC",
                R.drawable.music40,
                "https://hls.pmchd.live/hls/stream.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Rotana Khalijia",
                R.drawable.music41,
                "https://shls-rotanakhalijia-prod-dub.shahid.net/out/v1/a639fd49db684f1b8c063d398101a888/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Rotana Music",
                R.drawable.music42,
                "https://rotanastudios-rotanamusic-1-eu.xiaomi.wurl.tv/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "RTV Vida",
                R.drawable.music43,
                "https://vidartv2.todostreaming.es/live/radiovida-emisiontvhd.m3u8"
            )
        )
        musicList.add(
            Triple(
                "The Country Network 4K",
                R.drawable.music44,
                "https://endpnt.com/hls/tcn4k/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "The Retro Channel",
                R.drawable.music45,
                "https://5fd5567570c0e.streamlock.net/theretrochannel/stream/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Trace Urban (Australia)",
                R.drawable.music46,
                "https://lightning-traceurban-samsungau.amagi.tv/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Vevo 80s",
                R.drawable.music47,
                "https://dai2.xumo.com/amagi_hls_data_xumo1212A-redboxvevo80s/CDN/playlist.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Vevo Hip Hop",
                R.drawable.music48,
                "https://5dcc6a54d90e8c5dc4345c16-s-4.ssai.zype.com/5dcc6a54d90e8c5dc4345c16-s-4/manifest.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Vevo Latino",
                R.drawable.music49,
                "https://5dcc6a9f1621dc5dd511ca14-s-5.ssai.zype.com/5dcc6a9f1621dc5dd511ca14-s-5/manifest.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Vevo Pop Europe",
                R.drawable.music50,
                "https://5f3491c50b093e00015a3c4c-samsung.eu.ssai.zype.com/5f3491c50b093e00015a3c4c_samsung_eu/manifest.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Wanasah",
                R.drawable.music51,
                "https://shls-wanasah-prod-dub.shahid.net/out/v1/c84ef3128e564b74a6a796e8b6287de6/index.m3u8"
            )
        )
        musicList.add(
            Triple(
                "Матур ТВ",
                R.drawable.music52,
                "https://public.streaming.matur-tv.ru/hls/h264_aac/stream.m3u8"
            )
        )
        musicList.add(
            Triple(
                "ТНТ Music",
                R.drawable.music53,
                "http://83.222.205.65:8080/tntmusic/index.m3u8"
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
