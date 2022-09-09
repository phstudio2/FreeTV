package com.phstudio.freetv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity


class MusicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_music)

        val btMusic1 = findViewById<Button>(R.id.btMusic1)
        val btMusic2 = findViewById<Button>(R.id.btMusic2)
        val btMusic3 = findViewById<Button>(R.id.btMusic3)
        val btMusic4 = findViewById<Button>(R.id.btMusic4)
        val btMusic5 = findViewById<Button>(R.id.btMusic5)
        val btMusic6 = findViewById<Button>(R.id.btMusic6)
        val btMusic7 = findViewById<Button>(R.id.btMusic7)
        val btMusic8 = findViewById<Button>(R.id.btMusic8)
        val btMusic9 = findViewById<Button>(R.id.btMusic9)
        val btMusic10 = findViewById<Button>(R.id.btMusic10)
        val btMusic11 = findViewById<Button>(R.id.btMusic11)
        val btMusic12 = findViewById<Button>(R.id.btMusic12)
        val btMusic13 = findViewById<Button>(R.id.btMusic13)
        val btMusic14 = findViewById<Button>(R.id.btMusic14)
        val btMusic15 = findViewById<Button>(R.id.btMusic15)
        val btMusic16 = findViewById<Button>(R.id.btMusic16)
        val btMusic17 = findViewById<Button>(R.id.btMusic17)
        val btMusic18 = findViewById<Button>(R.id.btMusic18)
        val btMusic19 = findViewById<Button>(R.id.btMusic19)
        val btMusic20 = findViewById<Button>(R.id.btMusic20)
        val btMusic21 = findViewById<Button>(R.id.btMusic21)
        val btMusic22 = findViewById<Button>(R.id.btMusic22)
        val btMusic23 = findViewById<Button>(R.id.btMusic23)
        val btMusic24 = findViewById<Button>(R.id.btMusic24)
        val btMusic25 = findViewById<Button>(R.id.btMusic25)
        val btMusic26 = findViewById<Button>(R.id.btMusic26)
        val btMusic27 = findViewById<Button>(R.id.btMusic27)
        val btMusic28 = findViewById<Button>(R.id.btMusic28)
        val btMusic29 = findViewById<Button>(R.id.btMusic29)
        val btMusic30 = findViewById<Button>(R.id.btMusic30)
        val btMusic31 = findViewById<Button>(R.id.btMusic31)
        val btMusic32 = findViewById<Button>(R.id.btMusic32)
        val btMusic33 = findViewById<Button>(R.id.btMusic33)
        val btMusic34 = findViewById<Button>(R.id.btMusic34)
        val btMusic35 = findViewById<Button>(R.id.btMusic35)
        val btMusic36 = findViewById<Button>(R.id.btMusic36)
        val btMusic37 = findViewById<Button>(R.id.btMusic37)
        val btMusic38 = findViewById<Button>(R.id.btMusic38)
        val btMusic39 = findViewById<Button>(R.id.btMusic39)
        val btMusic40 = findViewById<Button>(R.id.btMusic40)
        val btMusic41 = findViewById<Button>(R.id.btMusic41)
        val btMusic42 = findViewById<Button>(R.id.btMusic42)
        val btMusic43 = findViewById<Button>(R.id.btMusic43)
        val btMusic44 = findViewById<Button>(R.id.btMusic44)
        val btMusic45 = findViewById<Button>(R.id.btMusic45)
        val btMusic46 = findViewById<Button>(R.id.btMusic46)
        val btMusic47 = findViewById<Button>(R.id.btMusic47)
        val btMusic48 = findViewById<Button>(R.id.btMusic48)
        val btMusic49 = findViewById<Button>(R.id.btMusic49)
        val btMusic50 = findViewById<Button>(R.id.btMusic50)
        val btMusic51 = findViewById<Button>(R.id.btMusic51)
        val btMusic52 = findViewById<Button>(R.id.btMusic52)
        val btMusic53 = findViewById<Button>(R.id.btMusic53)

        val m3u8 = resources.getStringArray(R.array.music_m3u8)

        btMusic1.setOnClickListener {
            player(1, m3u8)
        }
        btMusic2.setOnClickListener {
            player(2, m3u8)
        }
        btMusic3.setOnClickListener {
            player(3, m3u8)
        }
        btMusic4.setOnClickListener {
            player(4, m3u8)
        }
        btMusic5.setOnClickListener {
            player(5, m3u8)
        }
        btMusic6.setOnClickListener {
            player(6, m3u8)
        }
        btMusic7.setOnClickListener {
            player(7, m3u8)
        }
        btMusic8.setOnClickListener {
            player(8, m3u8)
        }
        btMusic9.setOnClickListener {
            player(9, m3u8)
        }
        btMusic10.setOnClickListener {
            player(10, m3u8)
        }
        btMusic11.setOnClickListener {
            player(11, m3u8)
        }
        btMusic12.setOnClickListener {
            player(12, m3u8)
        }
        btMusic13.setOnClickListener {
            player(13, m3u8)
        }
        btMusic14.setOnClickListener {
            player(14, m3u8)
        }
        btMusic15.setOnClickListener {
            player(15, m3u8)
        }
        btMusic16.setOnClickListener {
            player(16, m3u8)
        }
        btMusic17.setOnClickListener {
            player(17, m3u8)
        }
        btMusic18.setOnClickListener {
            player(18, m3u8)
        }
        btMusic19.setOnClickListener {
            player(19, m3u8)
        }
        btMusic20.setOnClickListener {
            player(20, m3u8)
        }
        btMusic21.setOnClickListener {
            player(21, m3u8)
        }
        btMusic22.setOnClickListener {
            player(22, m3u8)
        }
        btMusic23.setOnClickListener {
            player(23, m3u8)
        }
        btMusic24.setOnClickListener {
            player(24, m3u8)
        }
        btMusic25.setOnClickListener {
            player(25, m3u8)
        }
        btMusic26.setOnClickListener {
            player(26, m3u8)
        }
        btMusic27.setOnClickListener {
            player(27, m3u8)
        }
        btMusic28.setOnClickListener {
            player(28, m3u8)
        }
        btMusic29.setOnClickListener {
            player(29, m3u8)
        }
        btMusic30.setOnClickListener {
            player(30, m3u8)
        }
        btMusic31.setOnClickListener {
            player(31, m3u8)
        }
        btMusic32.setOnClickListener {
            player(32, m3u8)
        }
        btMusic33.setOnClickListener {
            player(33, m3u8)
        }
        btMusic34.setOnClickListener {
            player(34, m3u8)
        }
        btMusic35.setOnClickListener {
            player(35, m3u8)
        }
        btMusic36.setOnClickListener {
            player(36, m3u8)
        }
        btMusic37.setOnClickListener {
            player(37, m3u8)
        }
        btMusic38.setOnClickListener {
            player(38, m3u8)
        }
        btMusic39.setOnClickListener {
            player(39, m3u8)
        }
        btMusic40.setOnClickListener {
            player(40, m3u8)
        }
        btMusic41.setOnClickListener {
            player(41, m3u8)
        }
        btMusic42.setOnClickListener {
            player(42, m3u8)
        }
        btMusic43.setOnClickListener {
            player(43, m3u8)
        }
        btMusic44.setOnClickListener {
            player(44, m3u8)
        }
        btMusic45.setOnClickListener {
            player(45, m3u8)
        }
        btMusic46.setOnClickListener {
            player(46, m3u8)
        }
        btMusic47.setOnClickListener {
            player(47, m3u8)
        }
        btMusic48.setOnClickListener {
            player(48, m3u8)
        }
        btMusic49.setOnClickListener {
            player(49, m3u8)
        }
        btMusic50.setOnClickListener {
            player(50, m3u8)
        }
        btMusic51.setOnClickListener {
            player(51, m3u8)
        }
        btMusic52.setOnClickListener {
            player(52, m3u8)
        }
        btMusic53.setOnClickListener {
            player(53, m3u8)
        }

        btMusic1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btMusic2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btMusic3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btMusic4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btMusic5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btMusic6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btMusic7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btMusic8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btMusic9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btMusic10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btMusic11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btMusic12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btMusic13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btMusic14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btMusic15.setOnLongClickListener {
            favorite(15, 15)
            true
        }
        btMusic16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btMusic17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
        btMusic18.setOnLongClickListener {
            favorite(18, 18)
            true
        }
        btMusic19.setOnLongClickListener {
            favorite(19, 19)
            true
        }
        btMusic20.setOnLongClickListener {
            favorite(20, 20)
            true
        }
        btMusic21.setOnLongClickListener {
            favorite(21, 21)
            true
        }
        btMusic22.setOnLongClickListener {
            favorite(22, 22)
            true
        }
        btMusic23.setOnLongClickListener {
            favorite(23, 23)
            true
        }
        btMusic24.setOnLongClickListener {
            favorite(24, 24)
            true
        }
        btMusic25.setOnLongClickListener {
            favorite(25, 25)
            true
        }
        btMusic26.setOnLongClickListener {
            favorite(26, 26)
            true
        }
        btMusic27.setOnLongClickListener {
            favorite(27, 27)
            true
        }
        btMusic28.setOnLongClickListener {
            favorite(28, 28)
            true
        }
        btMusic29.setOnLongClickListener {
            favorite(29, 29)
            true
        }
        btMusic30.setOnLongClickListener {
            favorite(30, 30)
            true
        }
        btMusic31.setOnLongClickListener {
            favorite(31, 31)
            true
        }
        btMusic32.setOnLongClickListener {
            favorite(32, 32)
            true
        }
        btMusic33.setOnLongClickListener {
            favorite(33, 33)
            true
        }
        btMusic34.setOnLongClickListener {
            favorite(34, 34)
            true
        }
        btMusic35.setOnLongClickListener {
            favorite(35, 35)
            true
        }
        btMusic36.setOnLongClickListener {
            favorite(36, 36)
            true
        }
        btMusic37.setOnLongClickListener {
            favorite(37, 37)
            true
        }
        btMusic38.setOnLongClickListener {
            favorite(38, 38)
            true
        }
        btMusic39.setOnLongClickListener {
            favorite(39, 39)
            true
        }
        btMusic40.setOnLongClickListener {
            favorite(40, 40)
            true
        }
        btMusic41.setOnLongClickListener {
            favorite(41, 41)
            true
        }
        btMusic42.setOnLongClickListener {
            favorite(42, 42)
            true
        }
        btMusic43.setOnLongClickListener {
            favorite(43, 43)
            true
        }
        btMusic44.setOnLongClickListener {
            favorite(44, 44)
            true
        }
        btMusic45.setOnLongClickListener {
            favorite(45, 45)
            true
        }
        btMusic46.setOnLongClickListener {
            favorite(46, 46)
            true
        }
        btMusic47.setOnLongClickListener {
            favorite(47, 47)
            true
        }
        btMusic48.setOnLongClickListener {
            favorite(48, 48)
            true
        }
        btMusic49.setOnLongClickListener {
            favorite(49, 49)
            true
        }
        btMusic50.setOnLongClickListener {
            favorite(50, 50)
            true
        }
        btMusic51.setOnLongClickListener {
            favorite(51, 51)
            true
        }
        btMusic52.setOnLongClickListener {
            favorite(52, 52)
            true
        }
        btMusic53.setOnLongClickListener {
            favorite(53, 53)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@MusicActivity, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Music", x.toString(), "m3u8", "music$y", "music$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
