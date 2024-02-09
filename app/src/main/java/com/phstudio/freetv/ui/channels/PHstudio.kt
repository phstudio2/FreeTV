package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.ui.channels.Argentina
import com.phstudio.freetv.ui.channels.Australia
import com.phstudio.freetv.ui.channels.Czech
import com.phstudio.freetv.ui.channels.Germany
import com.phstudio.freetv.ui.channels.International
import com.phstudio.freetv.ui.channels.Slovakia
import com.phstudio.freetv.ui.channels.UK
import com.phstudio.freetv.ui.channels.USA

class PHstudio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_phstudio2)

        val items = arrayOf(
            findViewById<Button>(R.id.btChannel1),
            findViewById(R.id.btChannel2),
            findViewById(R.id.btChannel3),
            findViewById(R.id.btChannel4),
            findViewById(R.id.btChannel5),
            findViewById(R.id.btChannel6),
            findViewById(R.id.btChannel7),
            findViewById(R.id.btChannel8),
        )

        items.forEach { item ->
            item.setOnClickListener {
                when (item.id) {
                    R.id.btChannel1 -> sendActivity(Czech())
                    R.id.btChannel2 -> sendActivity(UK())
                    R.id.btChannel3 -> sendActivity(Slovakia())
                    R.id.btChannel4 -> sendActivity(Argentina())
                    R.id.btChannel5 -> sendActivity(Australia())
                    R.id.btChannel6 -> sendActivity(Germany())
                    R.id.btChannel7 -> sendActivity(USA())
                    R.id.btChannel8 -> sendActivity(International())
                }
            }
        }
    }

    private fun sendActivity(where: AppCompatActivity) {
        val intent = Intent(this, where::class.java)
        startActivity(intent)
    }
}
