package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity

class Slovakia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_slovakia)

        val btSlovakia1 = findViewById<Button>(R.id.btSlovakia1)
        val btSlovakia2 = findViewById<Button>(R.id.btSlovakia2)
        val btSlovakia3 = findViewById<Button>(R.id.btSlovakia3)
        val btSlovakia4 = findViewById<Button>(R.id.btSlovakia4)
        val btSlovakia5 = findViewById<Button>(R.id.btSlovakia5)
        val btSlovakia6 = findViewById<Button>(R.id.btSlovakia6)
        val btSlovakia7 = findViewById<Button>(R.id.btSlovakia7)
        val btSlovakia8 = findViewById<Button>(R.id.btSlovakia8)
        val btSlovakia9 = findViewById<Button>(R.id.btSlovakia9)
        val btSlovakia10 = findViewById<Button>(R.id.btSlovakia10)
        val btSlovakia11 = findViewById<Button>(R.id.btSlovakia11)
        val btSlovakia12 = findViewById<Button>(R.id.btSlovakia12)
        val btSlovakia13 = findViewById<Button>(R.id.btSlovakia13)

        val m3u8 = resources.getStringArray(R.array.slovakia_m3u8)

        btSlovakia1.setOnClickListener {
            player(1, m3u8)
        }
        btSlovakia2.setOnClickListener {
            player(2, m3u8)
        }
        btSlovakia3.setOnClickListener {
            player(3, m3u8)
        }
        btSlovakia4.setOnClickListener {
            player(4, m3u8)
        }
        btSlovakia5.setOnClickListener {
            player(5, m3u8)
        }
        btSlovakia6.setOnClickListener {
            player(6, m3u8)
        }
        btSlovakia7.setOnClickListener {
            player(7, m3u8)
        }
        btSlovakia8.setOnClickListener {
            player(8, m3u8)
        }
        btSlovakia9.setOnClickListener {
            player(9, m3u8)
        }
        btSlovakia10.setOnClickListener {
            player(10, m3u8)
        }
        btSlovakia11.setOnClickListener {
            player(11, m3u8)
        }
        btSlovakia12.setOnClickListener {
            player(12, m3u8)
        }
        btSlovakia13.setOnClickListener {
            player(13, m3u8)
        }

        btSlovakia1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btSlovakia2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btSlovakia3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btSlovakia4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btSlovakia5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btSlovakia6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btSlovakia7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btSlovakia8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btSlovakia9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btSlovakia10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btSlovakia11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btSlovakia12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btSlovakia13.setOnLongClickListener {
            favorite(13, 13)
            true
        }

    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@Slovakia, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Slovakia", x.toString(), "m3u8", "slovakia$y", "slovakia$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
