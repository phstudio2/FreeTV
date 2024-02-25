package com.phstudio.freetv.ui.git1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R


class CountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_freetv)

        val items = arrayOf(
            findViewById<Button>(R.id.btAlbania),
            findViewById(R.id.btAndorra),
            findViewById(R.id.btArgentina),
            findViewById(R.id.btAustralia),
            findViewById(R.id.btAustria),
            findViewById(R.id.btAzerbaijan),
            findViewById(R.id.btBelarus),
            findViewById(R.id.btBelgium),
            findViewById(R.id.btBosniaAndHerzegovina),
            findViewById(R.id.btBrazil),
            findViewById(R.id.btBulgaria),
            findViewById(R.id.btCanada),
            findViewById(R.id.btChad),
            findViewById(R.id.btChile),
            findViewById(R.id.btChina),
            findViewById(R.id.btCostaRica),
            findViewById(R.id.btCroatia),
            findViewById(R.id.btCyprus),
            findViewById(R.id.btCzechRepublic),
            findViewById(R.id.btDenmark),
            findViewById(R.id.btDominicanRepublic),
            findViewById(R.id.btEstonia),
            findViewById(R.id.btFaroeIslands),
            findViewById(R.id.btFinland),
            findViewById(R.id.btFrance),
            findViewById(R.id.btGeorgia),
            findViewById(R.id.btGermany),
            findViewById(R.id.btGreece),
            findViewById(R.id.btGreenland),
            findViewById(R.id.btHongKong),
            findViewById(R.id.btHungary),
            findViewById(R.id.btIceland),
            findViewById(R.id.btIndia),
            findViewById(R.id.btIran),
            findViewById(R.id.btIraq),
            findViewById(R.id.btIreland),
            findViewById(R.id.btIsrael),
            findViewById(R.id.btItaly),
            findViewById(R.id.btJapan),
            findViewById(R.id.btKorea),
            findViewById(R.id.btKosovo),
            findViewById(R.id.btLatvia),
            findViewById(R.id.btLithuania),
            findViewById(R.id.btLuxembourg),
            findViewById(R.id.btMacau),
            findViewById(R.id.btMalta),
            findViewById(R.id.btMexico),
            findViewById(R.id.btMoldova),
            findViewById(R.id.btMonaco),
            findViewById(R.id.btMontenegro),
            findViewById(R.id.btNetherlands),
            findViewById(R.id.btNorthKorea),
            findViewById(R.id.btNorthMacedonia),
            findViewById(R.id.btNorway),
            findViewById(R.id.btParaguay),
            findViewById(R.id.btPeru),
            findViewById(R.id.btPoland),
            findViewById(R.id.btPortugal),
            findViewById(R.id.btQatar),
            findViewById(R.id.btRomania),
            findViewById(R.id.btRussia),
            findViewById(R.id.btSanMarino),
            findViewById(R.id.btSaudiArabia),
            findViewById(R.id.btSerbia),
            findViewById(R.id.btSlovakia),
            findViewById(R.id.btSlovenia),
            findViewById(R.id.btSomalia),
            findViewById(R.id.btSpain),
            findViewById(R.id.btSweden),
            findViewById(R.id.btSwitzerland),
            findViewById(R.id.btTaiwan),
            findViewById(R.id.btTrinidad),
            findViewById(R.id.btTurkey),
            findViewById(R.id.btUk),
            findViewById(R.id.btUkraine),
            findViewById(R.id.btUnitedArabEmirates),
            findViewById(R.id.btUsa),
            findViewById(R.id.btVenezuela)
            )

        items.forEach { item ->
            item.setOnClickListener {
                when (item.id) {
                    R.id.btAlbania -> sendActivity("albania")
                    R.id.btAndorra -> sendActivity("andorra")
                    R.id.btArgentina -> sendActivity("argentina")
                    R.id.btAustralia -> sendActivity("australia")
                    R.id.btAustria -> sendActivity("austria")
                    R.id.btAzerbaijan -> sendActivity("azerbaijan")
                    R.id.btBelarus -> sendActivity("belarus")
                    R.id.btBelgium -> sendActivity("belgium")
                    R.id.btBosniaAndHerzegovina -> sendActivity("bosnia_and_herzegovina")
                    R.id.btBrazil -> sendActivity("brazil")
                    R.id.btBulgaria -> sendActivity("bulgaria")
                    R.id.btCanada -> sendActivity("canada")
                    R.id.btChad -> sendActivity("chad")
                    R.id.btChile -> sendActivity("chile")
                    R.id.btChina -> sendActivity("china")
                    R.id.btCostaRica -> sendActivity("costa_rica")
                    R.id.btCroatia -> sendActivity("croatia")
                    R.id.btCyprus -> sendActivity("cyprus")
                    R.id.btCzechRepublic -> sendActivity("czech_republic")
                    R.id.btDenmark -> sendActivity("denmark")
                    R.id.btDominicanRepublic -> sendActivity("dominican_republic")
                    R.id.btEstonia -> sendActivity("estonia")
                    R.id.btFaroeIslands -> sendActivity("faroe_islands")
                    R.id.btFinland -> sendActivity("finland")
                    R.id.btFrance -> sendActivity("france")
                    R.id.btGeorgia -> sendActivity("georgia")
                    R.id.btGermany -> sendActivity("germany")
                    R.id.btGreece -> sendActivity("greece")
                    R.id.btGreenland -> sendActivity("greenland")
                    R.id.btHongKong -> sendActivity("hong_kong")
                    R.id.btHungary -> sendActivity("hungary")
                    R.id.btIceland -> sendActivity("iceland")
                    R.id.btIndia -> sendActivity("india")
                    R.id.btIran -> sendActivity("iran")
                    R.id.btIraq -> sendActivity("iraq")
                    R.id.btIreland -> sendActivity("ireland")
                    R.id.btIsrael -> sendActivity("israel")
                    R.id.btItaly -> sendActivity("italy")
                    R.id.btJapan -> sendActivity("japan")
                    R.id.btKorea -> sendActivity("korea")
                    R.id.btKosovo -> sendActivity("kosovo")
                    R.id.btLatvia -> sendActivity("latvia")
                    R.id.btLithuania -> sendActivity("lithuania")
                    R.id.btLuxembourg -> sendActivity("luxembourg")
                    R.id.btMacau -> sendActivity("macau")
                    R.id.btMalta -> sendActivity("malta")
                    R.id.btMexico -> sendActivity("mexico")
                    R.id.btMoldova -> sendActivity("moldova")
                    R.id.btMonaco -> sendActivity("monaco")
                    R.id.btMontenegro -> sendActivity("montenegro")
                    R.id.btNetherlands -> sendActivity("netherlands")
                    R.id.btNorthKorea -> sendActivity("north_korea")
                    R.id.btNorthMacedonia -> sendActivity("north_macedonia")
                    R.id.btNorway -> sendActivity("norway")
                    R.id.btParaguay -> sendActivity("paraguay")
                    R.id.btPeru -> sendActivity("peru")
                    R.id.btPoland -> sendActivity("poland")
                    R.id.btPortugal -> sendActivity("portugal")
                    R.id.btQatar -> sendActivity("qatar")
                    R.id.btRomania -> sendActivity("romania")
                    R.id.btRussia -> sendActivity("russia")
                    R.id.btSanMarino -> sendActivity("san_marino")
                    R.id.btSaudiArabia -> sendActivity("saudi_arabia")
                    R.id.btSerbia -> sendActivity("serbia")
                    R.id.btSlovakia -> sendActivity("slovakia")
                    R.id.btSlovenia -> sendActivity("slovenia")
                    R.id.btSomalia -> sendActivity("somalia")
                    R.id.btSpain -> sendActivity("spain")
                    R.id.btSweden -> sendActivity("sweden")
                    R.id.btSwitzerland -> sendActivity("switzerland")
                    R.id.btTaiwan -> sendActivity("taiwan")
                    R.id.btTrinidad -> sendActivity("trinidad")
                    R.id.btTurkey -> sendActivity("turkey")
                    R.id.btUk -> sendActivity("uk")
                    R.id.btUkraine -> sendActivity("ukraine")
                    R.id.btUnitedArabEmirates -> sendActivity("united_arab_emirates")
                    R.id.btUsa -> sendActivity("usa")
                    R.id.btVenezuela -> sendActivity("venezuela")
                }
            }
        }
    }

    @SuppressLint("DiscouragedApi")
    private fun sendActivity(country: String) {
        val intent = Intent(this, LinkActivity::class.java)
        intent.putExtra("type", 1)
        intent.putExtra("tvPrimary", getString(resources.getIdentifier(country, "string", packageName)))
        intent.putExtra("ivDrawable", resources.getIdentifier(country, "drawable", packageName))
        intent.putExtra("stream", "https://raw.githubusercontent.com/Free-TV/IPTV/master/playlists/playlist_$country.m3u8")
        startActivity(intent)
    }
}
