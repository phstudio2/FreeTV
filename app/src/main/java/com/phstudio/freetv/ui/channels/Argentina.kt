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

class Argentina : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_argentina)

        val btArgentina1 = findViewById<Button>(R.id.btArgentina1)
        val btArgentina2 = findViewById<Button>(R.id.btArgentina2)
        val btArgentina3 = findViewById<Button>(R.id.btArgentina3)
        val btArgentina4 = findViewById<Button>(R.id.btArgentina4)
        val btArgentina5 = findViewById<Button>(R.id.btArgentina5)
        val btArgentina6 = findViewById<Button>(R.id.btArgentina6)
        val btArgentina7 = findViewById<Button>(R.id.btArgentina7)
        val btArgentina8 = findViewById<Button>(R.id.btArgentina8)
        val btArgentina9 = findViewById<Button>(R.id.btArgentina9)
        val btArgentina10 = findViewById<Button>(R.id.btArgentina10)

        val m3u8 = resources.getStringArray(R.array.argentina_m3u8)
        val html = resources.getStringArray(R.array.argentina_html)

        btArgentina1.setOnClickListener {
            player(1, m3u8)
        }
        btArgentina2.setOnClickListener {
            player(2, m3u8)
        }
        btArgentina3.setOnClickListener {
            player(3, m3u8)
        }
        btArgentina4.setOnClickListener {
            player(4, m3u8)
        }
        btArgentina5.setOnClickListener {
            html(1, html)
        }
        btArgentina6.setOnClickListener {
            html(2, html)
        }
        btArgentina7.setOnClickListener {
            html(3, html)
        }
        btArgentina8.setOnClickListener {
            html(4, html)
        }
        btArgentina9.setOnClickListener {
            html(5, html)
        }
        btArgentina10.setOnClickListener {
            html(6, html)
        }

        btArgentina1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btArgentina2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btArgentina3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btArgentina4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btArgentina5.setOnLongClickListener {
            favorite2(1, 5)
            true
        }
        btArgentina6.setOnLongClickListener {
            favorite2(2, 6)
            true
        }
        btArgentina7.setOnLongClickListener {
            favorite2(3, 7)
            true
        }
        btArgentina8.setOnLongClickListener {
            favorite2(4, 8)
            true
        }
        btArgentina9.setOnLongClickListener {
            favorite2(5, 9)
            true
        }
        btArgentina10.setOnLongClickListener {
            favorite2(6, 10)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@Argentina, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun html(x: Int, name: Array<String>) {
        val intent = Intent(this@Argentina, HTMLActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Argentina", x.toString(), "m3u8", "argentina$y", "argentina$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }

    private fun favorite2(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Argentina", x.toString(), "html", "argentina$y", "argentina$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}