package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity

class Australia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_australia)

        val btAustralia1 = findViewById<Button>(R.id.btAustralia1)
        val btAustralia2 = findViewById<Button>(R.id.btAustralia2)
        val btAustralia3 = findViewById<Button>(R.id.btAustralia3)
        val btAustralia4 = findViewById<Button>(R.id.btAustralia4)
        val btAustralia5 = findViewById<Button>(R.id.btAustralia5)
        val btAustralia6 = findViewById<Button>(R.id.btAustralia6)
        val btAustralia7 = findViewById<Button>(R.id.btAustralia7)
        val btAustralia8 = findViewById<Button>(R.id.btAustralia8)
        val btAustralia9 = findViewById<Button>(R.id.btAustralia9)
        val btAustralia10 = findViewById<Button>(R.id.btAustralia10)
        val btAustralia11 = findViewById<Button>(R.id.btAustralia11)
        val btAustralia12 = findViewById<Button>(R.id.btAustralia12)
        val btAustralia13 = findViewById<Button>(R.id.btAustralia13)
        val btAustralia14 = findViewById<Button>(R.id.btAustralia14)
        val btAustralia15 = findViewById<Button>(R.id.btAustralia15)
        val btAustralia16 = findViewById<Button>(R.id.btAustralia16)
        val btAustralia17 = findViewById<Button>(R.id.btAustralia17)

        val m3u8 = resources.getStringArray(R.array.australia_m3u8)

        btAustralia1.setOnClickListener {
            player(1, m3u8)
        }
        btAustralia2.setOnClickListener {
            player(2, m3u8)
        }
        btAustralia3.setOnClickListener {
            player(3, m3u8)
        }
        btAustralia4.setOnClickListener {
            player(4, m3u8)
        }
        btAustralia5.setOnClickListener {
            player(5, m3u8)
        }
        btAustralia6.setOnClickListener {
            player(6, m3u8)
        }
        btAustralia7.setOnClickListener {
            player(7, m3u8)
        }
        btAustralia8.setOnClickListener {
            player(8, m3u8)
        }
        btAustralia9.setOnClickListener {
            player(9, m3u8)
        }
        btAustralia10.setOnClickListener {
            player(10, m3u8)
        }
        btAustralia11.setOnClickListener {
            player(11, m3u8)
        }
        btAustralia12.setOnClickListener {
            player(12, m3u8)
        }
        btAustralia13.setOnClickListener {
            player(13, m3u8)
        }
        btAustralia14.setOnClickListener {
            player(14, m3u8)
        }
        btAustralia15.setOnClickListener {
            player(15, m3u8)
        }
        btAustralia16.setOnClickListener {
            player(16, m3u8)
        }
        btAustralia17.setOnClickListener {
            player(17, m3u8)
        }

        btAustralia1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btAustralia2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btAustralia3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btAustralia4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btAustralia5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btAustralia6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btAustralia7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btAustralia8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btAustralia9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btAustralia10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btAustralia11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btAustralia12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btAustralia13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btAustralia14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btAustralia15.setOnLongClickListener {
            favorite(15, 15)
            true
        }
        btAustralia16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btAustralia17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@Australia, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Australia", x.toString(), "m3u8", "australia$y", "australia$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}