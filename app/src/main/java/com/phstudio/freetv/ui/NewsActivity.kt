package com.phstudio.freetv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_news)

        val btNews1 = findViewById<Button>(R.id.btNews1)
        val btNews2 = findViewById<Button>(R.id.btNews2)
        val btNews3 = findViewById<Button>(R.id.btNews3)
        val btNews4 = findViewById<Button>(R.id.btNews4)
        val btNews5 = findViewById<Button>(R.id.btNews5)
        val btNews6 = findViewById<Button>(R.id.btNews6)
        val btNews7 = findViewById<Button>(R.id.btNews7)
        val btNews8 = findViewById<Button>(R.id.btNews8)
        val btNews9 = findViewById<Button>(R.id.btNews9)
        val btNews10 = findViewById<Button>(R.id.btNews10)
        val btNews11 = findViewById<Button>(R.id.btNews11)
        val btNews12 = findViewById<Button>(R.id.btNews12)
        val btNews13 = findViewById<Button>(R.id.btNews13)
        val btNews14 = findViewById<Button>(R.id.btNews14)
        val btNews15 = findViewById<Button>(R.id.btNews15)
        val btNews16 = findViewById<Button>(R.id.btNews16)
        val btNews17 = findViewById<Button>(R.id.btNews17)
        val btNews18 = findViewById<Button>(R.id.btNews18)
        val btNews19 = findViewById<Button>(R.id.btNews19)
        val btNews20 = findViewById<Button>(R.id.btNews20)
        val btNews21 = findViewById<Button>(R.id.btNews21)
        val btNews22 = findViewById<Button>(R.id.btNews22)
        val btNews23 = findViewById<Button>(R.id.btNews23)

        val m3u8 = resources.getStringArray(R.array.news_m3u8)
        val html = resources.getStringArray(R.array.news_html)

        btNews1.setOnClickListener {
            player(1, m3u8)
        }
        btNews2.setOnClickListener {
            player(2, m3u8)
        }
        btNews3.setOnClickListener {
            player(3, m3u8)
        }
        btNews4.setOnClickListener {
            player(4, m3u8)
        }
        btNews5.setOnClickListener {
            player(5, m3u8)
        }
        btNews6.setOnClickListener {
            player(6, m3u8)
        }
        btNews7.setOnClickListener {
            player(7, m3u8)
        }

        btNews8.setOnClickListener {
            html(1, html)
        }
        btNews9.setOnClickListener {
            html(2, html)
        }
        btNews10.setOnClickListener {
            html(3, html)
        }
        btNews11.setOnClickListener {
            html(4, html)
        }
        btNews12.setOnClickListener {
            html(5, html)
        }
        btNews13.setOnClickListener {
            html(6, html)
        }
        btNews14.setOnClickListener {
            html(7, html)
        }
        btNews15.setOnClickListener {
            html(8, html)
        }
        btNews16.setOnClickListener {
            html(9, html)
        }
        btNews17.setOnClickListener {
            html(10, html)
        }
        btNews18.setOnClickListener {
            html(11, html)
        }
        btNews19.setOnClickListener {
            html(12, html)
        }
        btNews20.setOnClickListener {
            html(13, html)
        }
        btNews21.setOnClickListener {
            html(14, html)
        }
        btNews22.setOnClickListener {
            html(15, html)
        }
        btNews23.setOnClickListener {
            html(16, html)
        }

        btNews1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btNews2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btNews3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btNews4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btNews5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btNews6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btNews7.setOnLongClickListener {
            favorite(7, 7)
            true
        }

        btNews8.setOnLongClickListener {
            favorite2(1, 8)
            true
        }
        btNews9.setOnLongClickListener {
            favorite2(2, 9)
            true
        }
        btNews10.setOnLongClickListener {
            favorite2(3, 10)
            true
        }
        btNews11.setOnLongClickListener {
            favorite2(4, 11)
            true
        }
        btNews12.setOnLongClickListener {
            favorite2(5, 12)
            true
        }
        btNews13.setOnLongClickListener {
            favorite2(6, 13)
            true
        }
        btNews14.setOnLongClickListener {
            favorite2(7, 14)
            true
        }
        btNews15.setOnLongClickListener {
            favorite2(8, 15)
            true
        }
        btNews16.setOnLongClickListener {
            favorite2(9, 16)
            true
        }
        btNews17.setOnLongClickListener {
            favorite2(10, 17)
            true
        }
        btNews18.setOnLongClickListener {
            favorite2(11, 18)
            true
        }
        btNews19.setOnLongClickListener {
            favorite2(12, 19)
            true
        }
        btNews20.setOnLongClickListener {
            favorite2(13, 20)
            true
        }
        btNews21.setOnLongClickListener {
            favorite2(14, 21)
            true
        }
        btNews22.setOnLongClickListener {
            favorite2(15, 22)
            true
        }
        btNews23.setOnLongClickListener {
            favorite2(16, 23)
            true
        }

    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@NewsActivity, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun html(x: Int, name: Array<String>) {
        val intent = Intent(this@NewsActivity, HTMLActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("News", x.toString(), "m3u8", "news$y", "news$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }

    private fun favorite2(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("News", x.toString(), "html", "news$y", "news$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
