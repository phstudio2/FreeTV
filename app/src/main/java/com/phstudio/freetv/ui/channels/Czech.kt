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

class Czech : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_czech)

        val btCz1 = findViewById<Button>(R.id.btCz1)
        val btCz2 = findViewById<Button>(R.id.btCz2)
        val btCz3 = findViewById<Button>(R.id.btCz3)
        val btCz4 = findViewById<Button>(R.id.btCz4)
        val btCz5 = findViewById<Button>(R.id.btCz5)
        val btCz6 = findViewById<Button>(R.id.btCz6)
        val btCz7 = findViewById<Button>(R.id.btCz7)
        val btCz8 = findViewById<Button>(R.id.btCz8)
        val btCz9 = findViewById<Button>(R.id.btCz9)
        val btCz10 = findViewById<Button>(R.id.btCz10)
        val btCz11 = findViewById<Button>(R.id.btCz11)
        val btCz12 = findViewById<Button>(R.id.btCz12)
        val btCz13 = findViewById<Button>(R.id.btCz13)
        val btCz14 = findViewById<Button>(R.id.btCz14)
        val btCz15 = findViewById<Button>(R.id.btCz15)
        val btCz16 = findViewById<Button>(R.id.btCz16)
        val btCz17 = findViewById<Button>(R.id.btCz17)
        val btCz18 = findViewById<Button>(R.id.btCz18)
        val btCz19 = findViewById<Button>(R.id.btCz19)
        val btCz20 = findViewById<Button>(R.id.btCz20)
        val btCz21 = findViewById<Button>(R.id.btCz21)
        val btCz22 = findViewById<Button>(R.id.btCz22)
        val btCz23 = findViewById<Button>(R.id.btCz23)
        val btCz24 = findViewById<Button>(R.id.btCz24)
        val btCz25 = findViewById<Button>(R.id.btCz25)

        val m3u8 = resources.getStringArray(R.array.cz_m3u8)
        val html = resources.getStringArray(R.array.cz_html)

        btCz1.setOnClickListener {
            player(1, m3u8)
        }
        btCz2.setOnClickListener {
            player(2, m3u8)
        }
        btCz3.setOnClickListener {
            player(3, m3u8)
        }
        btCz4.setOnClickListener {
            player(4, m3u8)
        }
        btCz5.setOnClickListener {
            player(5, m3u8)
        }
        btCz6.setOnClickListener {
            player(6, m3u8)
        }
        btCz7.setOnClickListener {
            player(7, m3u8)
        }
        btCz8.setOnClickListener {
            player(8, m3u8)
        }
        btCz9.setOnClickListener {
            player(9, m3u8)
        }
        btCz10.setOnClickListener {
            player(10, m3u8)
        }
        btCz11.setOnClickListener {
            player(11, m3u8)
        }
        btCz12.setOnClickListener {
            player(12, m3u8)
        }

        btCz13.setOnClickListener {
            html(1, html)
        }
        btCz14.setOnClickListener {
            html(2, html)
        }
        btCz15.setOnClickListener {
            html(3, html)
        }
        btCz16.setOnClickListener {
            html(4, html)
        }
        btCz17.setOnClickListener {
            html(5, html)
        }
        btCz18.setOnClickListener {
            html(6, html)
        }
        btCz19.setOnClickListener {
            html(7, html)
        }
        btCz20.setOnClickListener {
            html(8, html)
        }

        btCz21.setOnClickListener {
            player(13, m3u8)
        }
        btCz22.setOnClickListener {
            player(14, m3u8)
        }
        btCz23.setOnClickListener {
            player(15, m3u8)
        }
        btCz24.setOnClickListener {
            player(16, m3u8)
        }
        btCz25.setOnClickListener {
            player(17, m3u8)
        }

        btCz1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btCz2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btCz3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btCz4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btCz5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btCz6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btCz7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btCz8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btCz9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btCz10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btCz11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btCz12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btCz13.setOnLongClickListener {
            favorite2(1, 13)
            true
        }
        btCz14.setOnLongClickListener {
            favorite2(2, 14)
            true
        }
        btCz15.setOnLongClickListener {
            favorite2(3, 15)
            true
        }
        btCz16.setOnLongClickListener {
            favorite2(4, 16)
            true
        }
        btCz17.setOnLongClickListener {
            favorite2(5, 17)
            true
        }
        btCz18.setOnLongClickListener {
            favorite2(6, 18)
            true
        }
        btCz19.setOnLongClickListener {
            favorite2(7, 19)
            true
        }
        btCz20.setOnLongClickListener {
            favorite2(8, 20)
            true
        }

        btCz21.setOnLongClickListener {
            favorite(13, 21)
            true
        }
        btCz22.setOnLongClickListener {
            favorite(14, 22)
            true
        }
        btCz23.setOnLongClickListener {
            favorite(15, 23)
            true
        }
        btCz24.setOnLongClickListener {
            favorite(16, 24)
            true
        }
        btCz25.setOnLongClickListener {
            favorite(17, 25)
            true
        }

    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@Czech, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun html(x: Int, name: Array<String>) {
        val intent = Intent(this@Czech, HTMLActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Czech", x.toString(), "m3u8", "cz$y", "cz$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }

    private fun favorite2(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Czech", x.toString(), "html", "cz$y", "cz$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}