package com.phstudio.freetv.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.Timer
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.schedule


class LinkActivity : AppCompatActivity() {

    @Suppress("DEPRECATION")
    private fun internet(): Boolean {
        val connectivityManager =
            this@LinkActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_country)

        val country = intent.getStringExtra("country")
        val code = intent.getStringExtra("code")

        val tvPrimary: TextView = findViewById(R.id.tvPrimary)
        tvPrimary.text = intent.getStringExtra("tvPrimary")

        val ivDrawable: AppCompatImageView = findViewById(R.id.ivDrawable)
        val image = intent.getIntExtra("ivDrawable", 0)
        ivDrawable.setImageResource(image)

        val recyclerView: RecyclerView = findViewById(R.id.rvCountry)
        customAdapter =
            ItemAdapter2(
                this@LinkActivity,
                filteredLinkList,
                object : ItemAdapter2.OnItemClickListener {
                    override fun onItemClick(position: Int) {
                        val (_, _, stringList2) = splitList(filteredLinkList)
                        val url = stringList2[position]
                        if (url.contains("https://www.youtube.com")) {
                            val intent = Intent(this@LinkActivity, HTMLActivity::class.java)
                            intent.putExtra("Name", url)
                            startActivity(intent)
                        } else {
                            val intent = Intent(this@LinkActivity, PlayerActivity::class.java)
                            intent.putExtra("Name", url)
                            startActivity(intent)
                        }

                    }
                }, object : ItemAdapter2.OnItemLongClickListener {
                    override fun onItemLongClick(position: Int): Boolean {
                        val (name, logo, url) = splitList(filteredLinkList)
                        favorite(name[position], logo[position], url[position])

                        return true
                    }
                })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter

        val searchView: SearchView = findViewById(R.id.svCountry)

        val searchEditText =
            searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchEditText.setTextColor(ContextCompat.getColor(this, R.color.primary_text))
        searchView.setIconifiedByDefault(false)
        searchEditText.setHintTextColor(ContextCompat.getColor(this, R.color.primary_text))
        searchView.setQueryHint(getString(R.string.search_channel))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        when (country) {
            "zz_news_en" -> {
                prepareItemsNews()
            }

            "music" -> {
                prepareItemsMusic()
            }
        }

        if (country != "music") {
            getPublic(
                1,
                "https://raw.githubusercontent.com/Free-TV/IPTV/master/playlists/playlist_$country.m3u8"
            )
        }
        Timer().schedule(1000) {
            when (country) {
                "zz_news_en" -> {
                    getPublic(2, "https://iptv-org.github.io/iptv/categories/news.m3u")
                }

                "zz_movies" -> {
                    getPublic(2, "https://iptv-org.github.io/iptv/categories/movies.m3u")
                }

                "music" -> {
                    getPublic(2, "https://iptv-org.github.io/iptv/categories/music.m3u")
                }

                else -> {
                    getPublic(2, "https://iptv-org.github.io/iptv/countries/$code.m3u")
                }
            }
        }

        if (country == "germany") {
            getPublic(
                3,
                "https://raw.githubusercontent.com/jnk22/kodinerds-iptv/master/iptv/kodi/kodi_tv_main.m3u"
            )
            Timer().schedule(1000) {
                getPublic(
                    3,
                    "https://raw.githubusercontent.com/jnk22/kodinerds-iptv/master/iptv/kodi/kodi_tv_regional.m3u"
                )
            }
        }
    }

    private val filteredLinkList = ArrayList<Triple<String, String, String>>()

    @SuppressLint("NotifyDataSetChanged")
    private fun filterList(query: String?) {
        filteredLinkList.clear()
        if (query.isNullOrBlank()) {
            filteredLinkList.addAll(linkList)
        } else {
            val lowerCaseQuery = query.lowercase()
            filteredLinkList.addAll(linkList.filter {
                it.first.lowercase().contains(lowerCaseQuery)
            })
        }
        customAdapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getPublic(type: Int, streamURL: String) {
        if (internet()) {
            Thread {
                try {
                    val website =
                        URL(streamURL)
                    val uc: HttpsURLConnection = website.openConnection() as HttpsURLConnection
                    val br = BufferedReader(InputStreamReader(uc.inputStream))
                    var line: String?
                    val lin2 = StringBuilder()
                    while (br.readLine().also { line = it } != null) {
                        lin2.append(line)
                    }

                    val inputText = lin2.toString().trimIndent()
                    val parts =
                        inputText.split("#EXTINF:-1").filter { it.isNotBlank() }.map { it.trim() }
                    val linkToAdd = ArrayList<Triple<String, String, String>>()

                    parts.forEachIndexed { index, part ->
                        if (index != 0) {

                            if (type == 1) {
                                val regex =
                                    Regex("""tvg-name="([^"]+)" tvg-logo="([^"]+)" tvg-id="(.*?)" group-title="(.*?)",([^"]+)""")

                                val matchResult = regex.find(part)

                                if (matchResult != null) {
                                    val (name, logo, _, _, url) = matchResult.destructured

                                    linkToAdd.add(
                                        Triple(
                                            name,
                                            logo,
                                            url.replaceBefore("http", "")
                                        )
                                    )
                                }
                            } else if (type == 2) {
                                val regex =
                                    Regex("""tvg-id="(.*?)" tvg-logo="([^"]+)" group-title="(.*?)",([^"]+)""")

                                val matchResult = regex.find(part)

                                if (matchResult != null) {
                                    val (_, logo, _, res) = matchResult.destructured
                                    val url = res.replaceBefore("http", "")
                                    val name = res.replaceAfter("http", "").replace("http", "")

                                    linkToAdd.add(
                                        Triple(
                                            name,
                                            logo,
                                            url.replaceBefore("http", "")
                                        )
                                    )
                                }
                            } else if (type == 3) {
                                val regex =
                                    Regex("""tvg-name="([^"]+)" tvg-id="(.*?)" group-title="(.*?)" tvg-logo="([^"]+)",([^"]*)""")

                                val matchResult = regex.find(part)

                                if (matchResult != null) {
                                    val (name, _, _, logo, url) = matchResult.destructured

                                    linkToAdd.add(
                                        Triple(
                                            name,
                                            logo,
                                            url.replaceBefore("http", "")
                                        )
                                    )
                                }
                            }
                        }
                    }


                    runOnUiThread {
                        filteredLinkList.addAll(linkToAdd)
                        linkList.addAll(linkToAdd)
                        customAdapter.notifyDataSetChanged()
                    }
                } catch (e: IOException) {
                    println(e.localizedMessage!!.toString())
                }
            }.start()
        } else {
            Toast.makeText(
                this@LinkActivity,
                getString(R.string.no_internet), Toast.LENGTH_SHORT
            ).show()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItemsNews() {
        linkList.add(
            Triple(
                "Al Jazeera English",
                "https://upload.wikimedia.org/wikipedia/en/thumb/8/8f/Al_Jazeera_Media_Network_Logo.svg/1280px-Al_Jazeera_Media_Network_Logo.svg.png",
                "https://live-hls-web-aje.getaj.net/AJE/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Al Jazeera Arabic",
                "https://upload.wikimedia.org/wikipedia/en/thumb/8/8f/Al_Jazeera_Media_Network_Logo.svg/1280px-Al_Jazeera_Media_Network_Logo.svg.png",
                "https://live-hls-web-aja.getaj.net/AJA/02.m3u8"
            )
        )
        linkList.add(
            Triple(
                "DW English",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Deutsche_Welle_symbol_2012.svg/1280px-Deutsche_Welle_symbol_2012.svg.png",
                "https://dwamdstream102.akamaized.net/hls/live/2015525/dwstream102/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "DW German",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Deutsche_Welle_symbol_2012.svg/1280px-Deutsche_Welle_symbol_2012.svg.png",
                "https://dwamdstream106.akamaized.net/hls/live/2017965/dwstream106/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "DW German+",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Deutsche_Welle_symbol_2012.svg/1280px-Deutsche_Welle_symbol_2012.svg.png",
                "https://dwamdstream105.akamaized.net/hls/live/2015531/dwstream105/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "DW Spanish",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Deutsche_Welle_symbol_2012.svg/1280px-Deutsche_Welle_symbol_2012.svg.png",
                "https://dwamdstream104.akamaized.net/hls/live/2015530/dwstream104/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "DW Arabic",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Deutsche_Welle_symbol_2012.svg/1280px-Deutsche_Welle_symbol_2012.svg.png",
                "https://dwamdstream103.akamaized.net/hls/live/2015526/dwstream103/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "France 24 English",
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/65/FRANCE_24_logo.svg/1024px-FRANCE_24_logo.svg.png",
                "https://www.youtube.com/c/FRANCE24English/live"
            )
        )
        linkList.add(
            Triple(
                "France 24 French",
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/65/FRANCE_24_logo.svg/1024px-FRANCE_24_logo.svg.png",
                "https://www.youtube.com/c/FRANCE24/live"
            )
        )
        linkList.add(
            Triple(
                "France 24 Spanish",
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/65/FRANCE_24_logo.svg/1024px-FRANCE_24_logo.svg.png",
                "https://www.youtube.com/watch?v=Y-IlMeCCtIg"
            )
        )
        linkList.add(
            Triple(
                "France 24 Arabic",
                "https://upload.wikimedia.org/wikipedia/en/thumb/6/65/FRANCE_24_logo.svg/1024px-FRANCE_24_logo.svg.png",
                "https://www.youtube.com/c/FRANCE24Arabic/live"
            )
        )
        linkList.add(
            Triple(
                "Euronews English",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=pykpO5kQJ98"
            )
        )
        linkList.add(
            Triple(
                "Euronews French",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=NiRIbKwAejk"
            )
        )
        linkList.add(
            Triple(
                "Euronews Spanish",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=O9mOtdZ-nSk"
            )
        )
        linkList.add(
            Triple(
                "Euronews Italian",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=pUcmpyynASM"
            )
        )
        linkList.add(
            Triple(
                "Euronews Russian",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=lwYzwdBiaho"
            )
        )
        linkList.add(
            Triple(
                "Euronews German",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=CQ3KsEbsYHs"
            )
        )
        linkList.add(
            Triple(
                "Euronews Portuguese",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=fLtn2L7OdeI"
            )
        )
        linkList.add(
            Triple(
                "Euronews Greek",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=uWIhV9gQClg"
            )
        )
        linkList.add(
            Triple(
                "Euronews Hungarian",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Euronews_2022.svg/1280px-Euronews_2022.svg.png",
                "https://www.youtube.com/watch?v=jAn7L2Kt32U"
            )
        )
        linkList.add(
            Triple(
                "Africanews African",
                "https://upload.wikimedia.org/wikipedia/commons/d/d3/Africanews._alternative_logo_2016.png",
                "https://www.youtube.com/watch?v=NQjabLGdP5g"
            )
        )
        linkList.add(
            Triple(
                "Africanews French",
                "https://upload.wikimedia.org/wikipedia/commons/d/d3/Africanews._alternative_logo_2016.png",
                "https://www.youtube.com/watch?v=b6R9-7KZ8YM"
            )
        )
        linkList.add(
            Triple(
                "Sky News English",
                "https://upload.wikimedia.org/wikipedia/en/thumb/5/57/Sky_News_logo.svg/1024px-Sky_News_logo.svg.png",
                "https://www.youtube.com/watch?v=w9uJg68CV4g"
            )
        )

        filteredLinkList.addAll(linkList)
        customAdapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItemsMusic() {
        linkList.add(
            Triple(
                "Afrobeats",
                "",
                "https://stream.ecable.tv/afrobeats/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Artist Aloud",
                "",
                "https://live.hungama.com/linear/artist-aloud/playlist.m3u8" //nejde
            )
        )
        linkList.add(
            Triple(
                "88 Stereo",
                "",
                "http://k3.usastreams.com/CableLatino/88stereo/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "1HD Music Television",
                "",
                "http://103.199.161.254/Content/7smusic/Live/Channel(7smusic)/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "30A Music",
                "",
                "https://30a-tv.com/music.m3u8"
            )
        )
        linkList.add(
            Triple(
                "9XM",
                "",
                "https://d2q8p4pe5spbak.cloudfront.net/bpk-tv/9XM/9XM.isml/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "101 Tele Antequera",
                "",
                "https://limited38.todostreaming.es/live/101tv-AntequeraHD.m3u8"
            )
        )
        linkList.add(
            Triple(
                "A2i Music",
                "",
                "https://stream.sen-gt.com/A2iMusic/myStream/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "A Son de Salsa",
                "",
                "https://cloud01.mipaneltv.xyz/asondesalsa/asondesalsa/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Activa TV",
                "",
                "https://streamtv.mediasector.es/hls/activatv/.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Arabica TV",
                "",
                "http://istream.binarywaves.com:8081/hls/arabica/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Baeble Music",
                "",
                "https://dai2.xumo.com/amagi_hls_data_xumo1212A-redboxbaeble/CDN/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Baraza TV",
                "",
                "https://eco.streams.ovh/BarazaTV/BarazarazaTV/BarazaTV/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Barbud Music",
                "",
                "https://raw.githubusercontent.com/taodicakhia/IPTV_Exception/master/channels/af/tolomusic.m3u8" //nejde
            )
        )
        linkList.add(
            Triple(
                "Beats Radio",
                "",
                "https://59537faa0729a.streamlock.net/beatsradio/beatsradio/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Best Cable Más Cumbia",
                "",
                "https://tv.inka.net.pe/mascumbiatvonline/mascumbiatvonline/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Best Cable Music",
                "",
                "https://tv.inka.net.pe/bestcablemusic/bestcablemusic/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Bibel TV Musik",
                "",
                "http://bibeltv03.iptv-playoutcenter.de/bibeltv03/bibeltv03.stream_1/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Carolina TV",
                "",
                "https://unlimited1-us.dps.live/carolinatv/carolinatv.smil/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Dhamaal",
                "",
                "https://live.hungama.com/linear/dhamaal/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Galáctica TV (Peru)",
                "",
                "https://pacific.direcnode.com:3715/hybrid/play.m3u8"
            )
        )
        linkList.add(
            Triple(
                "High Vision",
                "",
                "https://streamer1.connectto.com/HIGHVISION_WEB_1205/tracks-v1a1/mono.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Huila TV",
                "",
                "https://plataformavideo.com:19360/8020/8020.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Kadak Hits",
                "",
                "https://live.hungama.com/linear/kadak-hits/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Kronehit",
                "",
                "https://bitcdn-kronehit.bitmovin.com/v2/hls/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "MBC FM",
                "",
                "ttps://mbcfm-riyadh-prod-dub.shahid.net/out/v1/69c8a03f507e422f99cf5c07291c9e3a/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "MCM Top",
                "",
                "http://ott-cdn.ucom.am/s49/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "MCN6 Music Channel",
                "",
                "https://5b464b69d264e.streamlock.net/Channels_live/ngrp:MelodyChannel_all/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Mnet",
                "",
                "https://allanf181.github.io/adaptive-streams/streams/kr/Mnet.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Óčko",
                "https://upload.wikimedia.org/wikipedia/commons/2/20/%C3%93%C4%8Dko_logo_2012.png",
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Óčko Expres",
                "https://upload.wikimedia.org/wikipedia/commons/2/2b/%C3%93%C4%8Dko_Expres_logo.png",
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko_expres/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Óčko Gold",
                "https://upload.wikimedia.org/wikipedia/commons/b/b5/%C3%93%C4%8Dko_Star_logo.png",
                "https://ocko-live.ssl.cdn.cra.cz/channels/ocko_gold/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Panorama FM",
                "",
                "https://shls-panoramafm-prod-dub.shahid.net/out/v1/66262e420d824475aaae794dc2d69f14/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Pluto TV VEVO 2K",
                "",
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5fd7bca3e0a4ee0007a38e8c/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        linkList.add(
            Triple(
                "Pluto TV VEVO 70's",
                "",
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5f32f26bcd8aea00071240e5/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        linkList.add(
            Triple(
                "Pluto TV VEVO 90's",
                "",
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5fd7bb1f86d94a000796e2c2/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        linkList.add(
            Triple(
                "Pluto TV VEVO Country",
                "",
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5da0d75e84830900098a1ea0/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        linkList.add(
            Triple(
                "Pluto TV VEVO R&B",
                "",
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5da0d83f66c9700009b96d0e/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        linkList.add(
            Triple(
                "Pluto TV VEVO Reggeaton & Trap",
                "",
                "https://service-stitcher.clusters.pluto.tv/v1/stitch/embed/hls/channel/5f32f397795b750007706448/master.m3u8?advertisingId=channel&appName=rokuchannel&appVersion=1.0&bmodel=bm1&channel_id=channel&content=channel&content_rating=ROKU_ADS_CONTENT_RATING&content_type=livefeed&coppa=false&deviceDNT=1&deviceId=channel&deviceMake=rokuChannel&deviceModel=web&deviceType=rokuChannel&deviceVersion=1.0&embedPartner=rokuChannel&genre=ROKU_ADS_CONTENT_GENRE&is_lat=1&platform=web&rdid=channel&studio_id=viacom&tags=ROKU_CONTENT_TAGS"
            )
        )
        linkList.add(
            Triple(
                "PMC",
                "",
                "https://hls.pmchd.live/hls/stream.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Rotana Khalijia",
                "",
                "https://shls-rotanakhalijia-prod-dub.shahid.net/out/v1/a639fd49db684f1b8c063d398101a888/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Rotana Music",
                "",
                "https://rotanastudios-rotanamusic-1-eu.xiaomi.wurl.tv/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "RTV Vida",
                "",
                "https://vidartv2.todostreaming.es/live/radiovida-emisiontvhd.m3u8"
            )
        )
        linkList.add(
            Triple(
                "The Country Network 4K",
                "",
                "https://endpnt.com/hls/tcn4k/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "The Retro Channel",
                "",
                "https://5fd5567570c0e.streamlock.net/theretrochannel/stream/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Trace Urban (Australia)",
                "",
                "https://lightning-traceurban-samsungau.amagi.tv/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Vevo 80s",
                "",
                "https://dai2.xumo.com/amagi_hls_data_xumo1212A-redboxvevo80s/CDN/playlist.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Vevo Hip Hop",
                "",
                "https://5dcc6a54d90e8c5dc4345c16-s-4.ssai.zype.com/5dcc6a54d90e8c5dc4345c16-s-4/manifest.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Vevo Latino",
                "",
                "https://5dcc6a9f1621dc5dd511ca14-s-5.ssai.zype.com/5dcc6a9f1621dc5dd511ca14-s-5/manifest.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Vevo Pop Europe",
                "",
                "https://5f3491c50b093e00015a3c4c-samsung.eu.ssai.zype.com/5f3491c50b093e00015a3c4c_samsung_eu/manifest.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Wanasah",
                "",
                "https://shls-wanasah-prod-dub.shahid.net/out/v1/c84ef3128e564b74a6a796e8b6287de6/index.m3u8"
            )
        )
        linkList.add(
            Triple(
                "Матур ТВ",
                "",
                "https://public.streaming.matur-tv.ru/hls/h264_aac/stream.m3u8"
            )
        )
        linkList.add(
            Triple(
                "ТНТ Music",
                "",
                "http://83.222.205.65:8080/tntmusic/index.m3u8"
            )
        )

        filteredLinkList.addAll(linkList)
        customAdapter.notifyDataSetChanged()
    }

    private fun splitList(linkList: ArrayList<Triple<String, String, String>>): Triple<ArrayList<String>, ArrayList<String>, ArrayList<String>> {
        val stringList1 = ArrayList<String>()
        val intList = ArrayList<String>()
        val stringList2 = ArrayList<String>()

        for (pair in linkList) {
            stringList1.add(pair.first)
            intList.add(pair.second)
            stringList2.add(pair.third)
        }
        return Triple(stringList1, intList, stringList2)
    }

    private val linkList = ArrayList<Triple<String, String, String>>()

    private lateinit var customAdapter: ItemAdapter2
    private fun favorite(name: String, logo: String, url: String) {
        val db = Database(this, null)
        db.writeToDb(name, logo, url)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
