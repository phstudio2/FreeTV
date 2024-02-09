package com.phstudio.freetv.ui.kodinerds

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R

class KodiNerdsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_kodinerds)

        val items = arrayOf(
            findViewById<Button>(R.id.btKodiNerdsMain),
            findViewById(R.id.btKodiNerdsRegional)
            )

        items.forEach { item ->
            item.setOnClickListener {
                when (item.id) {
                    R.id.btKodiNerdsMain -> sendActivity(KodiTvMain())
                    R.id.btKodiNerdsRegional -> sendActivity(KodiTvRegional())
                }
            }
        }
    }

    private fun sendActivity(where: AppCompatActivity) {
        val intent = Intent(this, where::class.java)
        startActivity(intent)
    }
}
