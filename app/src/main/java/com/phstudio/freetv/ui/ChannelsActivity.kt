package com.phstudio.freetv.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.phstudio.freetv.R

class ChannelsActivity : AppCompatActivity() {

    private val linkList = ArrayList<Triple<String, Int, String>>()
    private lateinit var customAdapter: ItemAdapter
    private val filteredLinkList = ArrayList<Triple<String, Int, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_country)

        val tvPrimary: TextView = findViewById(R.id.tvPrimary)
        tvPrimary.text = getString(R.string.channels)

        val ivDrawable: AppCompatImageView = findViewById(R.id.ivDrawable)
        ivDrawable.setImageResource(R.drawable.tv)

        val recyclerView: RecyclerView = findViewById(R.id.rvCountry)
        customAdapter =
            ItemAdapter(filteredLinkList, object : ItemAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {
                    val (_, _, stringList2) = splitList(filteredLinkList)
                    val text = stringList2[position]
                    val parts = text.split(";")
                    sendActivity(parts[0], parts[1])
                }
            }, object : ItemAdapter.OnItemLongClickListener {
                override fun onItemLongClick(position: Int): Boolean {
                    val (_, _, stringList2) = splitList(filteredLinkList)
                    val text = stringList2[position]
                    val parts = text.split(";")
                    sendActivity(parts[0], parts[1])

                    return true
                }
            })

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()

        val searchView: SearchView = findViewById(R.id.svCountry)

        val searchEditText =
            searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchEditText.setTextColor(ContextCompat.getColor(this, R.color.primary_text))
        searchView.setIconifiedByDefault(false)
        searchEditText.setHintTextColor(ContextCompat.getColor(this, R.color.primary_text))
        searchView.setQueryHint(getString(R.string.search_country))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

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

    @SuppressLint("NotifyDataSetChanged")
    private fun prepareItems() {
        linkList.add(
            Triple(
                getString(R.string.albania),
                R.drawable.albania,
                "albania;al"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.andorra),
                R.drawable.andorra,
                "andorra;ad"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.argentina),
                R.drawable.argentina,
                "argentina;ar"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.australia),
                R.drawable.australia,
                "australia;au"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.austria),
                R.drawable.austria,
                "austria;at"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.azerbaijan),
                R.drawable.azerbaijan,
                "azerbaijan;az"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.belarus),
                R.drawable.belarus,
                "belarus;by"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.belgium),
                R.drawable.belgium,
                "belgium;be"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.bosnia_and_herzegovina),
                R.drawable.bosnia_and_herzegovina,
                "bosnia_and_herzegovina;ba"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.brazil),
                R.drawable.brazil,
                "brazil;br"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.bulgaria),
                R.drawable.bulgaria,
                "bulgaria;bg"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.canada),
                R.drawable.canada,
                "canada;ca"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.chad),
                R.drawable.chad,
                "chad;td"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.chile),
                R.drawable.chile,
                "chile;cl"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.china),
                R.drawable.china,
                "china;cn"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.costa_rica),
                R.drawable.costa_rica,
                "costa_rica;cr"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.croatia),
                R.drawable.croatia,
                "croatia;hr"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.cyprus),
                R.drawable.cyprus,
                "cyprus;cy"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.czech_republic),
                R.drawable.czech_republic,
                "czech_republic;cz"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.denmark),
                R.drawable.denmark,
                "denmark;dk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.dominican_republic),
                R.drawable.dominican_republic,
                "dominican_republic;do"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.estonia),
                R.drawable.estonia,
                "estonia;ee"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.faroe_islands),
                R.drawable.faroe_islands,
                "faroe_islands;fo"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.finland),
                R.drawable.finland,
                "finland;fi"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.france),
                R.drawable.france,
                "france;fr"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.georgia),
                R.drawable.georgia,
                "georgia;ge"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.germany),
                R.drawable.germany,
                "germany;de"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.greece),
                R.drawable.greece,
                "greece;gr"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.greenland),
                R.drawable.greenland,
                "greenland;gl"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.hong_kong),
                R.drawable.hong_kong,
                "hong_kong;hk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.hungary),
                R.drawable.hungary,
                "hungary;hu"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.iceland),
                R.drawable.iceland,
                "iceland;is"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.india),
                R.drawable.india,
                "india;in"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.iran),
                R.drawable.iran,
                "iran;ir"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.iraq),
                R.drawable.iraq,
                "iraq;iq"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.ireland),
                R.drawable.ireland,
                "ireland;ie"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.israel),
                R.drawable.israel,
                "israel;il"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.italy),
                R.drawable.italy,
                "italy;it"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.japan),
                R.drawable.japan,
                "japan;jp"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.korea),
                R.drawable.korea,
                "korea;kp"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.kosovo),
                R.drawable.kosovo,
                "kosovo;xk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.latvia),
                R.drawable.latvia,
                "latvia;lv"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.lithuania),
                R.drawable.lithuania,
                "lithuania;lt"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.luxembourg),
                R.drawable.luxembourg,
                "luxembourg;lu"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.macau),
                R.drawable.macau,
                "macau;mo"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.malta),
                R.drawable.malta,
                "malta;mt"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.mexico),
                R.drawable.mexico,
                "mexico;mx"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.moldova),
                R.drawable.moldova,
                "moldova;md"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.monaco),
                R.drawable.monaco,
                "monaco;mc"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.montenegro),
                R.drawable.montenegro,
                "montenegro;me"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.netherlands),
                R.drawable.netherlands,
                "netherlands;nl"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.north_korea),
                R.drawable.north_korea,
                "north_korea;kp"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.north_macedonia),
                R.drawable.north_macedonia,
                "north_macedonia;mk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.norway),
                R.drawable.norway,
                "norway;no"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.paraguay),
                R.drawable.paraguay,
                "paraguay;py"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.pakistan),
                R.drawable.pakistan,
                "pakistan;pk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.peru),
                R.drawable.peru,
                "peru;pe"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.poland),
                R.drawable.poland,
                "poland;pl"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.portugal),
                R.drawable.portugal,
                "portugal;pt"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.qatar),
                R.drawable.qatar,
                "qatar;qa"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.romania),
                R.drawable.romania,
                "romania;ro"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.russia),
                R.drawable.russia,
                "russia;ru"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.san_marino),
                R.drawable.san_marino,
                "san_marino;sm"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.saudi_arabia),
                R.drawable.saudi_arabia,
                "saudi_arabia;sa"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.serbia),
                R.drawable.serbia,
                "serbia;rs"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.slovakia),
                R.drawable.slovakia,
                "slovakia;sk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.slovenia),
                R.drawable.slovenia,
                "slovenia;si"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.somalia),
                R.drawable.somalia,
                "somalia;so"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.spain),
                R.drawable.spain,
                "spain;es"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.sweden),
                R.drawable.sweden,
                "sweden;se"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.switzerland),
                R.drawable.switzerland,
                "switzerland;ch"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.taiwan),
                R.drawable.taiwan,
                "taiwan;tw"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.trinidad),
                R.drawable.trinidad,
                "trinidad;tt"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.turkey),
                R.drawable.turkey,
                "turkey;tr"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.uk),
                R.drawable.uk,
                "uk;uk"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.ukraine),
                R.drawable.ukraine,
                "ukraine;ua"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.united_arab_emirates),
                R.drawable.united_arab_emirates,
                "united_arab_emirates;ae"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.usa),
                R.drawable.usa,
                "usa;us"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.uzbekistan),
                R.drawable.uzbekistan,
                "uzbekistan;uz"
            )
        )
        linkList.add(
            Triple(
                getString(R.string.venezuela),
                R.drawable.venezuela,
                "venezuela;ve"
            )
        )

        filteredLinkList.addAll(linkList)
        customAdapter.notifyDataSetChanged()
    }

    @SuppressLint("DiscouragedApi")
    private fun sendActivity(country: String, code: String) {
        val intent = Intent(this, LinkActivity::class.java)
        intent.putExtra("country", country)
        intent.putExtra("code", code)
        intent.putExtra(
            "tvPrimary",
            getString(resources.getIdentifier(country, "string", packageName))
        )
        intent.putExtra("ivDrawable", resources.getIdentifier(country, "drawable", packageName))
        startActivity(intent)
    }
}
