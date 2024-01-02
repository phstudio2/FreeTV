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

class MoviesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_movies)

        val recyclerView: RecyclerView = findViewById(R.id.rvMovies)
        customAdapter = ItemAdapter(moviesList, object : ItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val (_, _, stringList2) = splitList(moviesList)
                val url = stringList2[position]
                if (url.contains("https://www.youtube.com")) {
                    val intent = Intent(this@MoviesActivity, HTMLActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                } else {
                    val intent = Intent(this@MoviesActivity, PlayerActivity::class.java)
                    intent.putExtra("Name", url)
                    startActivity(intent)
                }

            }
        }, object : ItemAdapter.OnItemLongClickListener {
            override fun onItemLongClick(position: Int): Boolean {
                val (stringList1, _, stringList2) = splitList(moviesList)
                favorite(stringList1[position], position + 1, stringList2[position])

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

    private val moviesList = ArrayList<Triple<String, Int, String>>()

    private lateinit var customAdapter: ItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        moviesList.add(
            Triple(
                "FilmRise Movies",
                R.drawable.movies1,
                "https://corp.xumo.com/xumocdn/p=roku/amagi_hls_data_xumo1212A-filmrisefreemovies/CDN/playlist.m3u8"
            )
        )
        moviesList.add(
            Triple(
                "FilmRise Sci-Fi",
                R.drawable.movies2,
                "https://corp.xumo.com/xumocdn/p=roku/amagi_hls_data_xumo1212A-rokufilmrisesci-fi/CDN/master.m3u8"
            )
        )
        moviesList.add(
            Triple(
                "Film Detective",
                R.drawable.movies3,
                "https://dai.google.com/linear/hls/event/OYH9J7rZSK2fabKXWAYcfA/master.m3u8"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV 007",
                R.drawable.movies4,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5d4db961034718b2f52f9e52/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=50&deviceId=5d4db961034718b2f52f9e52&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Spotlight",
                R.drawable.movies5,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5ba3fb9c4b078e0f37ad34e8/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=51&deviceId=5ba3fb9c4b078e0f37ad34e8&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Action",
                R.drawable.movies6,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/561d7d484dc7c8770484914a/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=54&deviceId=561d7d484dc7c8770484914a&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Comedy",
                R.drawable.movies7,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5a4d3a00ad95e4718ae8d8db/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=57&deviceId=5a4d3a00ad95e4718ae8d8db&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Drama",
                R.drawable.movies8,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5b4e92e4694c027be6ecece1/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=60&deviceId=5b4e92e4694c027be6ecece1&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Fantastic",
                R.drawable.movies9,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5b64a245a202b3337f09e51d/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=66&deviceId=5b64a245a202b3337f09e51d&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Romance",
                R.drawable.movies10,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5a66795ef91fef2c7031c599/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=70&deviceId=5a66795ef91fef2c7031c599&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Crime Movies",
                R.drawable.movies11,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5f4d8594eb979c0007706de7/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=73&deviceId=5f4d8594eb979c0007706de7&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Thrillers",
                R.drawable.movies12,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5b4e69e08291147bd04a9fd7/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=74&deviceId=5b4e69e08291147bd04a9fd7&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Horror",
                R.drawable.movies13,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/569546031a619b8f07ce6e25/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=75&deviceId=569546031a619b8f07ce6e25&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Terror",
                R.drawable.movies14,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5c6dc88fcd232425a6e0f06e/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=76&deviceId=5c6dc88fcd232425a6e0f06e&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Black Cinema",
                R.drawable.movies15,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/58af4c093a41ca9d4ecabe96/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=80&deviceId=58af4c093a41ca9d4ecabe96&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Staff Picks",
                R.drawable.movies16,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5f4d863b98b41000076cd061/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=90&deviceId=5f4d863b98b41000076cd061&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Documentaries",
                R.drawable.movies17,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5b85a7582921777994caea63/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=91&deviceId=5b85a7582921777994caea63&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "90s Throwback",
                R.drawable.movies18,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5f4d86f519358a00072b978e/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=94&deviceId=5f4d86f519358a00072b978e&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "80s Rewind",
                R.drawable.movies19,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5ca525b650be2571e3943c63/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=95&deviceId=5ca525b650be2571e3943c63&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "70s Cinema",
                R.drawable.movies20,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5f4d878d3d19b30007d2e782/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=96&deviceId=5f4d878d3d19b30007d2e782&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Paramount Movie Channel",
                R.drawable.movies21,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5cb0cae7a461406ffe3f5213/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=100&deviceId=5cb0cae7a461406ffe3f5213&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Westerns",
                R.drawable.movies22,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5b4e94282d4ec87bdcbb87cd/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=103&deviceId=5b4e94282d4ec87bdcbb87cd&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Classic Movies",
                R.drawable.movies23,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/561c5b0dada51f8004c4d855/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=106&deviceId=561c5b0dada51f8004c4d855&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Pluto TV Cult Films",
                R.drawable.movies24,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/5c665db3e6c01b72c4977bc2/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=109&deviceId=5c665db3e6c01b72c4977bc2&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "Flicks of Fury",
                R.drawable.movies25,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/58e55b14ad8e9c364d55f717/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=112&deviceId=58e55b14ad8e9c364d55f717&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )
        moviesList.add(
            Triple(
                "The Asylum",
                R.drawable.movies26,
                "https://service-stitcher.clusters.pluto.tv/stitch/hls/channel/591105034c1806b47438342c/master.m3u8?terminate=false&deviceType=web&deviceMake=web&deviceModel=web&sid=115&deviceId=591105034c1806b47438342c&deviceVersion=DNT&appVersion=DNT&deviceDNT=0&userId=&advertisingId=&deviceLat=&deviceLon=&app_name=&appName=web&buildVersion=&appStoreUrl=&architecture=&includeExtendedEvents=false&marketingRegion=US&serverSideAds=false"
            )
        )

        customAdapter.notifyDataSetChanged()
    }

    private fun favorite(name: String, num: Int, url: String) {
        val db = Database(this, null)
        db.writeToDb("Movies", num.toString(), url, "movies$num", name)
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
