package com.phstudio.freetv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.ui.channels.PHstudio
import com.phstudio.freetv.ui.kodinerds.KodiNerdsActivity

class ChannelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_channels)

        val items = arrayOf(
            findViewById<Button>(R.id.btFreeTV),
            findViewById(R.id.btIpTVOrg),
            findViewById(R.id.btPHstudio2),
            findViewById(R.id.btKodiNerds)
        )

        items.forEach { item ->
            item.setOnClickListener {
                when (item.id) {
                    R.id.btFreeTV -> sendActivity(com.phstudio.freetv.ui.git1.CountryActivity())
                    R.id.btIpTVOrg -> sendActivity(com.phstudio.freetv.ui.git2.CountryActivity())
                    R.id.btPHstudio2 -> sendActivity(PHstudio())
                    R.id.btKodiNerds -> sendActivity(KodiNerdsActivity())
                }
            }
        }
    }

    private fun sendActivity(where: AppCompatActivity) {
        val intent = Intent(this, where::class.java)
        startActivity(intent)
    }
}
