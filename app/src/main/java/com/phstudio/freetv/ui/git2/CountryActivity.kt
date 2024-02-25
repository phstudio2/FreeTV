package com.phstudio.freetv.ui.git2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.ui.git1.LinkActivity


class CountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_iptvorg)

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
                    R.id.btAlbania -> sendActivity("albania","al")
                    R.id.btAndorra -> sendActivity("andorra","ad")
                    R.id.btArgentina -> sendActivity("argentina","ar")
                    R.id.btAustralia -> sendActivity("australia","au")
                    R.id.btAustria -> sendActivity("austria","at")
                    R.id.btAzerbaijan -> sendActivity("azerbaijan","az")
                    R.id.btBelarus -> sendActivity("belarus","by")
                    R.id.btBelgium -> sendActivity("belgium","be")
                    R.id.btBosniaAndHerzegovina -> sendActivity("bosnia_and_herzegovina","ba")
                    R.id.btBrazil -> sendActivity("brazil","br")
                    R.id.btBulgaria -> sendActivity("bulgaria","bg")
                    R.id.btCanada -> sendActivity("canada","ca")
                    R.id.btChad -> sendActivity("chad","td")
                    R.id.btChile -> sendActivity("chile","cl")
                    R.id.btChina -> sendActivity("china","cn")
                    R.id.btCostaRica -> sendActivity("costa_rica","cr")
                    R.id.btCroatia -> sendActivity("croatia","hr")
                    R.id.btCyprus -> sendActivity("cyprus","cy")
                    R.id.btCzechRepublic -> sendActivity("czech_republic","cz")
                    R.id.btDenmark -> sendActivity("denmark","dk")
                    R.id.btDominicanRepublic -> sendActivity("dominican_republic","do")
                    R.id.btEstonia -> sendActivity("estonia","ee")
                    R.id.btFaroeIslands -> sendActivity("faroe_islands","fo")
                    R.id.btFinland -> sendActivity("finland","fi")
                    R.id.btFrance -> sendActivity("france","fr")
                    R.id.btGeorgia -> sendActivity("georgia","ge")
                    R.id.btGermany -> sendActivity("germany","de")
                    R.id.btGreece -> sendActivity("greece","gr")
                    R.id.btGreenland -> sendActivity("greenland","gl")
                    R.id.btHongKong -> sendActivity("hong_kong","hk")
                    R.id.btHungary -> sendActivity("hungary","hu")
                    R.id.btIceland -> sendActivity("iceland","is")
                    R.id.btIndia -> sendActivity("india","in")
                    R.id.btIran -> sendActivity("iran","ir")
                    R.id.btIraq -> sendActivity("iraq","iq")
                    R.id.btIreland -> sendActivity("ireland","ie")
                    R.id.btIsrael -> sendActivity("israel","il")
                    R.id.btItaly -> sendActivity("italy","it")
                    R.id.btJapan -> sendActivity("japan","jp")
                    R.id.btKorea -> sendActivity("korea","kp")
                    R.id.btKosovo -> sendActivity("kosovo","xk")
                    R.id.btLatvia -> sendActivity("latvia","lv")
                    R.id.btLithuania -> sendActivity("lithuania","lt")
                    R.id.btLuxembourg -> sendActivity("luxembourg","lu")
                    R.id.btMacau -> sendActivity("macau","mo")
                    R.id.btMalta -> sendActivity("malta","mt")
                    R.id.btMexico -> sendActivity("mexico","mx")
                    R.id.btMoldova -> sendActivity("moldova","md")
                    R.id.btMonaco -> sendActivity("monaco","mc")
                    R.id.btMontenegro -> sendActivity("montenegro","me")
                    R.id.btNetherlands -> sendActivity("netherlands","nl")
                    R.id.btNorthKorea -> sendActivity("north_korea","kp")
                    R.id.btNorthMacedonia -> sendActivity("north_macedonia","mk")
                    R.id.btNorway -> sendActivity("norway","no")
                    R.id.btParaguay -> sendActivity("paraguay","py")
                    R.id.btPeru -> sendActivity("peru","pe")
                    R.id.btPoland -> sendActivity("poland","pl")
                    R.id.btPortugal -> sendActivity("portugal","pt")
                    R.id.btQatar -> sendActivity("qatar","qa")
                    R.id.btRomania -> sendActivity("romania","ro")
                    R.id.btRussia -> sendActivity("russia","ru")
                    R.id.btSanMarino -> sendActivity("san_marino","sm")
                    R.id.btSaudiArabia -> sendActivity("saudi_arabia","sa")
                    R.id.btSerbia -> sendActivity("serbia","rs")
                    R.id.btSlovakia -> sendActivity("slovakia","sk")
                    R.id.btSlovenia -> sendActivity("slovenia","si")
                    R.id.btSomalia -> sendActivity("somalia","so")
                    R.id.btSpain -> sendActivity("spain","es")
                    R.id.btSweden -> sendActivity("sweden","se")
                    R.id.btSwitzerland -> sendActivity("switzerland","ch")
                    R.id.btTaiwan -> sendActivity("taiwan","tw")
                    R.id.btTrinidad -> sendActivity("trinidad","tt")
                    R.id.btTurkey -> sendActivity("turkey","tr")
                    R.id.btUk -> sendActivity("uk","uk")
                    R.id.btUkraine -> sendActivity("ukraine","ua")
                    R.id.btUnitedArabEmirates -> sendActivity("united_arab_emirates","ae")
                    R.id.btUsa -> sendActivity("usa","us")
                    R.id.btVenezuela -> sendActivity("venezuela","ve")
                }
            }
        }
    }

    @SuppressLint("DiscouragedApi")
    private fun sendActivity(country: String, stream: String) {
        val intent = Intent(this, LinkActivity::class.java)
        intent.putExtra("type", 2)
        intent.putExtra("tvPrimary", getString(resources.getIdentifier(country, "string", packageName)))
        intent.putExtra("ivDrawable", resources.getIdentifier(country, "drawable", packageName))
        intent.putExtra("stream", "https://iptv-org.github.io/iptv/countries/$stream.m3u")
        startActivity(intent)
    }
}
