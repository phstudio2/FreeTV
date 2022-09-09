package com.phstudio.freetv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.ui.channels.*

class ChannelsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_channels)

        val btChannel1 = findViewById<Button>(R.id.btChannel1)
        val btChannel2 = findViewById<Button>(R.id.btChannel2)
        val btChannel3 = findViewById<Button>(R.id.btChannel3)
        val btChannel4 = findViewById<Button>(R.id.btChannel4)
        val btChannel5 = findViewById<Button>(R.id.btChannel5)
        val btChannel6 = findViewById<Button>(R.id.btChannel6)
        val btChannel7 = findViewById<Button>(R.id.btChannel7)
        val btChannel8 = findViewById<Button>(R.id.btChannel8)

        btChannel1.setOnClickListener {
            sendActivity(Czech())
        }
        btChannel2.setOnClickListener {
            sendActivity(UK())
        }
        btChannel3.setOnClickListener {
            sendActivity(Slovakia())
        }
        btChannel4.setOnClickListener {
            sendActivity(Argentina())
        }
        btChannel5.setOnClickListener {
            sendActivity(Australia())
        }
        btChannel6.setOnClickListener {
            sendActivity(Germany())
        }
        btChannel7.setOnClickListener {
            sendActivity(USA())
        }
        btChannel8.setOnClickListener {
            sendActivity(International())
        }
    }

    private fun sendActivity(where: AppCompatActivity) {
        val intent = Intent(this, where::class.java)
        startActivity(intent)
    }
}
