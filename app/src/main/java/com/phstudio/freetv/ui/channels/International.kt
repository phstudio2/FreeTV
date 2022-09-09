package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity

class International : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_international)

        val btInternational1 = findViewById<Button>(R.id.btInternational1)
        val btInternational2 = findViewById<Button>(R.id.btInternational2)
        val btInternational3 = findViewById<Button>(R.id.btInternational3)
        val btInternational4 = findViewById<Button>(R.id.btInternational4)
        val btInternational5 = findViewById<Button>(R.id.btInternational5)

        val m3u8 = resources.getStringArray(R.array.international_m3u8)

        btInternational1.setOnClickListener {
            player(1, m3u8)
        }
        btInternational2.setOnClickListener {
            player(2, m3u8)
        }
        btInternational3.setOnClickListener {
            player(3, m3u8)
        }
        btInternational4.setOnClickListener {
            player(4, m3u8)
        }
        btInternational5.setOnClickListener {
            player(5, m3u8)
        }

        btInternational1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btInternational2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btInternational3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btInternational4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btInternational5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@International, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("International", x.toString(), "m3u8", "international$y", "international$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
