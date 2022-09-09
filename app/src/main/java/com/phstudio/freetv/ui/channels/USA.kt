package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity

class USA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_usa)

        val btUSA1 = findViewById<Button>(R.id.btUSA1)
        val btUSA2 = findViewById<Button>(R.id.btUSA2)
        val btUSA3 = findViewById<Button>(R.id.btUSA3)
        val btUSA4 = findViewById<Button>(R.id.btUSA4)
        val btUSA5 = findViewById<Button>(R.id.btUSA5)
        val btUSA6 = findViewById<Button>(R.id.btUSA6)
        val btUSA7 = findViewById<Button>(R.id.btUSA7)
        val btUSA8 = findViewById<Button>(R.id.btUSA8)
        val btUSA9 = findViewById<Button>(R.id.btUSA9)
        val btUSA10 = findViewById<Button>(R.id.btUSA10)
        val btUSA11 = findViewById<Button>(R.id.btUSA11)
        val btUSA12 = findViewById<Button>(R.id.btUSA12)
        val btUSA13 = findViewById<Button>(R.id.btUSA13)
        val btUSA14 = findViewById<Button>(R.id.btUSA14)
        val btUSA15 = findViewById<Button>(R.id.btUSA15)
        val btUSA16 = findViewById<Button>(R.id.btUSA16)
        val btUSA17 = findViewById<Button>(R.id.btUSA17)
        val btUSA18 = findViewById<Button>(R.id.btUSA18)
        val btUSA19 = findViewById<Button>(R.id.btUSA19)
        val btUSA20 = findViewById<Button>(R.id.btUSA20)
        val btUSA21 = findViewById<Button>(R.id.btUSA21)
        val btUSA22 = findViewById<Button>(R.id.btUSA22)
        val btUSA23 = findViewById<Button>(R.id.btUSA23)
        val btUSA24 = findViewById<Button>(R.id.btUSA24)
        val btUSA25 = findViewById<Button>(R.id.btUSA25)

        val m3u8 = resources.getStringArray(R.array.usa_m3u8)
        val html = resources.getStringArray(R.array.usa_html)

        btUSA1.setOnClickListener {
            player(1, m3u8)
        }
        btUSA2.setOnClickListener {
            player(2, m3u8)
        }
        btUSA3.setOnClickListener {
            player(3, m3u8)
        }
        btUSA4.setOnClickListener {
            player(4, m3u8)
        }
        btUSA5.setOnClickListener {
            player(5, m3u8)
        }
        btUSA6.setOnClickListener {
            player(6, m3u8)
        }
        btUSA7.setOnClickListener {
            player(7, m3u8)
        }
        btUSA8.setOnClickListener {
            player(8, m3u8)
        }
        btUSA9.setOnClickListener {
            player(9, m3u8)
        }
        btUSA10.setOnClickListener {
            player(10, m3u8)
        }
        btUSA11.setOnClickListener {
            player(11, m3u8)
        }
        btUSA12.setOnClickListener {
            player(12, m3u8)
        }
        btUSA13.setOnClickListener {
            player(13, m3u8)
        }
        btUSA14.setOnClickListener {
            player(14, m3u8)
        }
        btUSA15.setOnClickListener {
            player(15, m3u8)
        }
        btUSA16.setOnClickListener {
            player(16, m3u8)
        }
        btUSA17.setOnClickListener {
            player(17, m3u8)
        }
        btUSA18.setOnClickListener {
            player(18, m3u8)
        }
        btUSA19.setOnClickListener {
            player(19, m3u8)
        }
        btUSA20.setOnClickListener {
            player(20, m3u8)
        }
        btUSA21.setOnClickListener {
            player(21, m3u8)
        }
        btUSA22.setOnClickListener {
            player(22, m3u8)
        }
        btUSA23.setOnClickListener {
            html(1, html)
        }
        btUSA24.setOnClickListener {
            html(2, html)
        }
        btUSA25.setOnClickListener {
            html(3, html)
        }

        btUSA1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btUSA2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btUSA3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btUSA4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btUSA5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btUSA6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btUSA7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btUSA8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btUSA9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btUSA10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btUSA11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btUSA12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btUSA13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btUSA14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btUSA15.setOnLongClickListener {
            favorite(15, 14)
            true
        }
        btUSA16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btUSA17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
        btUSA18.setOnLongClickListener {
            favorite(18, 18)
            true
        }
        btUSA19.setOnLongClickListener {
            favorite(19, 19)
            true
        }
        btUSA20.setOnLongClickListener {
            favorite(20, 20)
            true
        }
        btUSA21.setOnLongClickListener {
            favorite(21, 21)
            true
        }
        btUSA22.setOnLongClickListener {
            favorite(22, 22)
            true
        }
        btUSA23.setOnLongClickListener {
            favorite2(1, 23)
            true
        }
        btUSA24.setOnLongClickListener {
            favorite2(2, 24)
            true
        }
        btUSA25.setOnLongClickListener {
            favorite2(3, 25)
            true
        }

    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@USA, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun html(x: Int, name: Array<String>) {
        val intent = Intent(this@USA, HTMLActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("USA", x.toString(), "m3u8", "usa$y", "usa$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }

    private fun favorite2(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("USA", x.toString(), "html", "usa$y", "usa$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}