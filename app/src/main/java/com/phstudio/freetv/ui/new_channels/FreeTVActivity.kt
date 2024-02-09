package com.phstudio.freetv.ui.new_channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R


class FreeTVActivity : AppCompatActivity() {

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
            findViewById(R.id.btEstonia)
        )

        items.forEach { item ->
            item.setOnClickListener {
                when (item.id) {
                    R.id.btAlbania -> sendActivity(Albania())
                    R.id.btAndorra -> sendActivity(Andorra())
                    R.id.btArgentina -> sendActivity(Argentina())
                    R.id.btAustralia -> sendActivity(Australia())
                    R.id.btAustria -> sendActivity(Austria())
                    R.id.btAzerbaijan -> sendActivity(Azerbaijan())
                    R.id.btBelarus -> sendActivity(Belarus())
                    R.id.btBelgium -> sendActivity(Belgium())
                    R.id.btBosniaAndHerzegovina -> sendActivity(BosniaAndHerzegovina())
                    R.id.btBrazil -> sendActivity(Brazil())
                    R.id.btBulgaria -> sendActivity(Bulgaria())
                    R.id.btCanada -> sendActivity(Canada())
                    R.id.btChad -> sendActivity(Chad())
                    R.id.btChile -> sendActivity(Chile())
                    R.id.btChina -> sendActivity(China())
                    R.id.btCostaRica -> sendActivity(CostaRica())
                    R.id.btCroatia -> sendActivity(Croatia())
                    R.id.btCyprus -> sendActivity(Cyprus())
                    R.id.btCzechRepublic -> sendActivity(CzechRepublic())
                    R.id.btDenmark -> sendActivity(Denmark())
                    R.id.btDominicanRepublic -> sendActivity(DominicanRepublic())
                    R.id.btEstonia -> sendActivity(Estonia())
                }
            }
        }
    }

    private fun sendActivity(where: AppCompatActivity) {
        val intent = Intent(this, where::class.java)
        startActivity(intent)
    }
}
