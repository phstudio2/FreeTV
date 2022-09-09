package com.phstudio.freetv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity


class AdultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_adult)

        val btAdult1 = findViewById<Button>(R.id.btAdult1)
        val btAdult2 = findViewById<Button>(R.id.btAdult2)
        val btAdult3 = findViewById<Button>(R.id.btAdult3)
        val btAdult4 = findViewById<Button>(R.id.btAdult4)
        val btAdult5 = findViewById<Button>(R.id.btAdult5)
        val btAdult6 = findViewById<Button>(R.id.btAdult6)
        val btAdult7 = findViewById<Button>(R.id.btAdult7)
        val btAdult8 = findViewById<Button>(R.id.btAdult8)
        val btAdult9 = findViewById<Button>(R.id.btAdult9)
        val btAdult10 = findViewById<Button>(R.id.btAdult10)
        val btAdult11 = findViewById<Button>(R.id.btAdult11)
        val btAdult12 = findViewById<Button>(R.id.btAdult12)
        val btAdult13 = findViewById<Button>(R.id.btAdult13)
        val btAdult14 = findViewById<Button>(R.id.btAdult14)
        val btAdult15 = findViewById<Button>(R.id.btAdult15)
        val btAdult16 = findViewById<Button>(R.id.btAdult16)
        val btAdult17 = findViewById<Button>(R.id.btAdult17)
        val btAdult18 = findViewById<Button>(R.id.btAdult18)
        val btAdult19 = findViewById<Button>(R.id.btAdult19)
        val btAdult20 = findViewById<Button>(R.id.btAdult20)
        val btAdult21 = findViewById<Button>(R.id.btAdult21)
        val btAdult22 = findViewById<Button>(R.id.btAdult22)
        val btAdult23 = findViewById<Button>(R.id.btAdult23)
        val btAdult24 = findViewById<Button>(R.id.btAdult24)
        val btAdult25 = findViewById<Button>(R.id.btAdult25)
        val btAdult26 = findViewById<Button>(R.id.btAdult26)
        val btAdult27 = findViewById<Button>(R.id.btAdult27)
        val btAdult28 = findViewById<Button>(R.id.btAdult28)
        val btAdult29 = findViewById<Button>(R.id.btAdult29)
        val btAdult30 = findViewById<Button>(R.id.btAdult30)
        val btAdult31 = findViewById<Button>(R.id.btAdult31)

        val m3u8 = resources.getStringArray(R.array.p_m3u8)

        btAdult1.setOnClickListener {
            player(1, m3u8)
        }
        btAdult2.setOnClickListener {
            player(2, m3u8)
        }
        btAdult3.setOnClickListener {
            player(3, m3u8)
        }
        btAdult4.setOnClickListener {
            player(4, m3u8)
        }
        btAdult5.setOnClickListener {
            player(5, m3u8)
        }
        btAdult6.setOnClickListener {
            player(6, m3u8)
        }
        btAdult7.setOnClickListener {
            player(7, m3u8)
        }
        btAdult8.setOnClickListener {
            player(8, m3u8)
        }
        btAdult9.setOnClickListener {
            player(9, m3u8)
        }
        btAdult10.setOnClickListener {
            player(10, m3u8)
        }
        btAdult11.setOnClickListener {
            player(11, m3u8)
        }
        btAdult12.setOnClickListener {
            player(12, m3u8)
        }
        btAdult13.setOnClickListener {
            player(13, m3u8)
        }
        btAdult14.setOnClickListener {
            player(14, m3u8)
        }
        btAdult15.setOnClickListener {
            player(15, m3u8)
        }
        btAdult16.setOnClickListener {
            player(16, m3u8)
        }
        btAdult17.setOnClickListener {
            player(17, m3u8)
        }
        btAdult18.setOnClickListener {
            player(18, m3u8)
        }
        btAdult19.setOnClickListener {
            player(19, m3u8)
        }
        btAdult20.setOnClickListener {
            player(20, m3u8)
        }
        btAdult21.setOnClickListener {
            player(21, m3u8)
        }
        btAdult22.setOnClickListener {
            player(22, m3u8)
        }
        btAdult23.setOnClickListener {
            player(23, m3u8)
        }
        btAdult24.setOnClickListener {
            player(24, m3u8)
        }
        btAdult25.setOnClickListener {
            player(25, m3u8)
        }
        btAdult26.setOnClickListener {
            player(26, m3u8)
        }
        btAdult27.setOnClickListener {
            player(27, m3u8)
        }
        btAdult28.setOnClickListener {
            player(28, m3u8)
        }
        btAdult29.setOnClickListener {
            player(29, m3u8)
        }
        btAdult30.setOnClickListener {
            player(30, m3u8)
        }
        btAdult31.setOnClickListener {
            player(31, m3u8)
        }

        btAdult1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btAdult2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btAdult3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btAdult4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btAdult5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btAdult6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btAdult7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btAdult8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btAdult9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btAdult10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btAdult11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btAdult12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btAdult13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btAdult14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btAdult15.setOnLongClickListener {
            favorite(15, 15)
            true
        }
        btAdult16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btAdult17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
        btAdult18.setOnLongClickListener {
            favorite(18, 18)
            true
        }
        btAdult19.setOnLongClickListener {
            favorite(19, 19)
            true
        }
        btAdult20.setOnLongClickListener {
            favorite(20, 20)
            true
        }
        btAdult21.setOnLongClickListener {
            favorite(21, 21)
            true
        }
        btAdult22.setOnLongClickListener {
            favorite(22, 22)
            true
        }
        btAdult23.setOnLongClickListener {
            favorite(23, 23)
            true
        }
        btAdult24.setOnLongClickListener {
            favorite(24, 24)
            true
        }
        btAdult25.setOnLongClickListener {
            favorite(25, 25)
            true
        }
        btAdult26.setOnLongClickListener {
            favorite(26, 26)
            true
        }
        btAdult27.setOnLongClickListener {
            favorite(27, 27)
            true
        }
        btAdult28.setOnLongClickListener {
            favorite(28, 28)
            true
        }
        btAdult29.setOnLongClickListener {
            favorite(29, 29)
            true
        }
        btAdult30.setOnLongClickListener {
            favorite(30, 30)
            true
        }
        btAdult31.setOnLongClickListener {
            favorite(31, 31)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@AdultActivity, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Adult", x.toString(), "m3u8", "p$y", "p$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
