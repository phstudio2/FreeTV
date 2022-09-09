package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity


class Germany : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_germany)

        val btGermany1 = findViewById<Button>(R.id.btGermany1)
        val btGermany2 = findViewById<Button>(R.id.btGermany2)
        val btGermany3 = findViewById<Button>(R.id.btGermany3)
        val btGermany4 = findViewById<Button>(R.id.btGermany4)
        val btGermany5 = findViewById<Button>(R.id.btGermany5)
        val btGermany6 = findViewById<Button>(R.id.btGermany6)
        val btGermany7 = findViewById<Button>(R.id.btGermany7)
        val btGermany8 = findViewById<Button>(R.id.btGermany8)
        val btGermany9 = findViewById<Button>(R.id.btGermany9)
        val btGermany10 = findViewById<Button>(R.id.btGermany10)
        val btGermany11 = findViewById<Button>(R.id.btGermany11)
        val btGermany12 = findViewById<Button>(R.id.btGermany12)
        val btGermany13 = findViewById<Button>(R.id.btGermany13)
        val btGermany14 = findViewById<Button>(R.id.btGermany14)
        val btGermany15 = findViewById<Button>(R.id.btGermany15)
        val btGermany16 = findViewById<Button>(R.id.btGermany16)
        val btGermany17 = findViewById<Button>(R.id.btGermany17)
        val btGermany18 = findViewById<Button>(R.id.btGermany18)
        val btGermany19 = findViewById<Button>(R.id.btGermany19)
        val btGermany20 = findViewById<Button>(R.id.btGermany20)
        val btGermany21 = findViewById<Button>(R.id.btGermany21)
        val btGermany22 = findViewById<Button>(R.id.btGermany22)
        val btGermany23 = findViewById<Button>(R.id.btGermany23)
        val btGermany24 = findViewById<Button>(R.id.btGermany24)
        val btGermany25 = findViewById<Button>(R.id.btGermany25)
        val btGermany26 = findViewById<Button>(R.id.btGermany26)
        val btGermany27 = findViewById<Button>(R.id.btGermany27)
        val btGermany28 = findViewById<Button>(R.id.btGermany28)
        val btGermany29 = findViewById<Button>(R.id.btGermany29)
        val btGermany30 = findViewById<Button>(R.id.btGermany30)
        val btGermany31 = findViewById<Button>(R.id.btGermany31)
        val btGermany32 = findViewById<Button>(R.id.btGermany32)
        val btGermany33 = findViewById<Button>(R.id.btGermany33)
        val btGermany34 = findViewById<Button>(R.id.btGermany34)
        val btGermany35 = findViewById<Button>(R.id.btGermany35)
        val btGermany36 = findViewById<Button>(R.id.btGermany36)
        val btGermany37 = findViewById<Button>(R.id.btGermany37)
        val btGermany38 = findViewById<Button>(R.id.btGermany38)
        val btGermany39 = findViewById<Button>(R.id.btGermany39)
        val btGermany40 = findViewById<Button>(R.id.btGermany40)
        val btGermany41 = findViewById<Button>(R.id.btGermany41)
        val btGermany42 = findViewById<Button>(R.id.btGermany42)
        val btGermany43 = findViewById<Button>(R.id.btGermany43)
        val btGermany44 = findViewById<Button>(R.id.btGermany44)
        val btGermany45 = findViewById<Button>(R.id.btGermany45)
        val btGermany46 = findViewById<Button>(R.id.btGermany46)
        val btGermany47 = findViewById<Button>(R.id.btGermany47)
        val btGermany48 = findViewById<Button>(R.id.btGermany48)
        val btGermany49 = findViewById<Button>(R.id.btGermany49)
        val btGermany50 = findViewById<Button>(R.id.btGermany50)
        val btGermany51 = findViewById<Button>(R.id.btGermany51)
        val btGermany52 = findViewById<Button>(R.id.btGermany52)
        val btGermany53 = findViewById<Button>(R.id.btGermany53)
        val btGermany54 = findViewById<Button>(R.id.btGermany54)
        val btGermany55 = findViewById<Button>(R.id.btGermany55)
        val btGermany56 = findViewById<Button>(R.id.btGermany56)
        val btGermany57 = findViewById<Button>(R.id.btGermany57)
        val btGermany58 = findViewById<Button>(R.id.btGermany58)
        val btGermany59 = findViewById<Button>(R.id.btGermany59)
        val btGermany60 = findViewById<Button>(R.id.btGermany60)
        val btGermany61 = findViewById<Button>(R.id.btGermany61)
        val btGermany62 = findViewById<Button>(R.id.btGermany62)
        val btGermany63 = findViewById<Button>(R.id.btGermany63)
        val btGermany64 = findViewById<Button>(R.id.btGermany64)
        val btGermany65 = findViewById<Button>(R.id.btGermany65)
        val btGermany66 = findViewById<Button>(R.id.btGermany66)
        val btGermany67 = findViewById<Button>(R.id.btGermany67)
        val btGermany68 = findViewById<Button>(R.id.btGermany68)
        val btGermany69 = findViewById<Button>(R.id.btGermany69)
        val btGermany70 = findViewById<Button>(R.id.btGermany70)
        val btGermany71 = findViewById<Button>(R.id.btGermany71)
        val btGermany72 = findViewById<Button>(R.id.btGermany72)

        val m3u8 = resources.getStringArray(R.array.germany_m3u8)

        btGermany1.setOnClickListener {
            player(1, m3u8)
        }
        btGermany2.setOnClickListener {
            player(2, m3u8)
        }
        btGermany3.setOnClickListener {
            player(3, m3u8)
        }
        btGermany4.setOnClickListener {
            player(4, m3u8)
        }
        btGermany5.setOnClickListener {
            player(5, m3u8)
        }
        btGermany6.setOnClickListener {
            player(6, m3u8)
        }
        btGermany7.setOnClickListener {
            player(7, m3u8)
        }
        btGermany8.setOnClickListener {
            player(8, m3u8)
        }
        btGermany9.setOnClickListener {
            player(9, m3u8)
        }
        btGermany10.setOnClickListener {
            player(10, m3u8)
        }
        btGermany11.setOnClickListener {
            player(11, m3u8)
        }
        btGermany12.setOnClickListener {
            player(12, m3u8)
        }
        btGermany13.setOnClickListener {
            player(13, m3u8)
        }
        btGermany14.setOnClickListener {
            player(14, m3u8)
        }
        btGermany15.setOnClickListener {
            player(15, m3u8)
        }
        btGermany16.setOnClickListener {
            player(16, m3u8)
        }
        btGermany17.setOnClickListener {
            player(17, m3u8)
        }
        btGermany18.setOnClickListener {
            player(18, m3u8)
        }
        btGermany19.setOnClickListener {
            player(19, m3u8)
        }
        btGermany20.setOnClickListener {
            player(20, m3u8)
        }
        btGermany21.setOnClickListener {
            player(21, m3u8)
        }
        btGermany22.setOnClickListener {
            player(22, m3u8)
        }
        btGermany23.setOnClickListener {
            player(23, m3u8)
        }
        btGermany24.setOnClickListener {
            player(24, m3u8)
        }
        btGermany25.setOnClickListener {
            player(25, m3u8)
        }
        btGermany26.setOnClickListener {
            player(26, m3u8)
        }
        btGermany27.setOnClickListener {
            player(27, m3u8)
        }
        btGermany28.setOnClickListener {
            player(28, m3u8)
        }
        btGermany29.setOnClickListener {
            player(29, m3u8)
        }
        btGermany30.setOnClickListener {
            player(30, m3u8)
        }
        btGermany31.setOnClickListener {
            player(31, m3u8)
        }
        btGermany32.setOnClickListener {
            player(32, m3u8)
        }
        btGermany33.setOnClickListener {
            player(33, m3u8)
        }
        btGermany34.setOnClickListener {
            player(34, m3u8)
        }
        btGermany35.setOnClickListener {
            player(35, m3u8)
        }
        btGermany36.setOnClickListener {
            player(36, m3u8)
        }
        btGermany37.setOnClickListener {
            player(37, m3u8)
        }
        btGermany38.setOnClickListener {
            player(38, m3u8)
        }
        btGermany39.setOnClickListener {
            player(39, m3u8)
        }
        btGermany40.setOnClickListener {
            player(40, m3u8)
        }
        btGermany41.setOnClickListener {
            player(41, m3u8)
        }
        btGermany42.setOnClickListener {
            player(42, m3u8)
        }
        btGermany43.setOnClickListener {
            player(43, m3u8)
        }
        btGermany44.setOnClickListener {
            player(44, m3u8)
        }
        btGermany45.setOnClickListener {
            player(45, m3u8)
        }
        btGermany46.setOnClickListener {
            player(46, m3u8)
        }
        btGermany47.setOnClickListener {
            player(47, m3u8)
        }
        btGermany48.setOnClickListener {
            player(48, m3u8)
        }
        btGermany49.setOnClickListener {
            player(49, m3u8)
        }
        btGermany50.setOnClickListener {
            player(50, m3u8)
        }
        btGermany51.setOnClickListener {
            player(51, m3u8)
        }
        btGermany52.setOnClickListener {
            player(52, m3u8)
        }
        btGermany53.setOnClickListener {
            player(53, m3u8)
        }
        btGermany54.setOnClickListener {
            player(54, m3u8)
        }
        btGermany55.setOnClickListener {
            player(55, m3u8)
        }
        btGermany56.setOnClickListener {
            player(56, m3u8)
        }
        btGermany57.setOnClickListener {
            player(57, m3u8)
        }
        btGermany58.setOnClickListener {
            player(58, m3u8)
        }
        btGermany59.setOnClickListener {
            player(59, m3u8)
        }
        btGermany60.setOnClickListener {
            player(60, m3u8)
        }
        btGermany61.setOnClickListener {
            player(61, m3u8)
        }
        btGermany62.setOnClickListener {
            player(62, m3u8)
        }
        btGermany63.setOnClickListener {
            player(63, m3u8)
        }
        btGermany64.setOnClickListener {
            player(64, m3u8)
        }
        btGermany65.setOnClickListener {
            player(65, m3u8)
        }
        btGermany66.setOnClickListener {
            player(66, m3u8)
        }
        btGermany67.setOnClickListener {
            player(67, m3u8)
        }
        btGermany68.setOnClickListener {
            player(68, m3u8)
        }
        btGermany69.setOnClickListener {
            player(69, m3u8)
        }
        btGermany70.setOnClickListener {
            player(70, m3u8)
        }
        btGermany71.setOnClickListener {
            player(71, m3u8)
        }
        btGermany72.setOnClickListener {
            player(72, m3u8)
        }

        btGermany1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btGermany2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btGermany3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btGermany4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btGermany5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btGermany6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btGermany7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btGermany8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btGermany9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btGermany10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btGermany11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btGermany12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btGermany13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btGermany14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btGermany15.setOnLongClickListener {
            favorite(15, 15)
            true
        }
        btGermany16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btGermany17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
        btGermany18.setOnLongClickListener {
            favorite(18, 18)
            true
        }
        btGermany19.setOnLongClickListener {
            favorite(19, 19)
            true
        }
        btGermany20.setOnLongClickListener {
            favorite(20, 20)
            true
        }
        btGermany21.setOnLongClickListener {
            favorite(21, 21)
            true
        }
        btGermany22.setOnLongClickListener {
            favorite(22, 22)
            true
        }
        btGermany23.setOnLongClickListener {
            favorite(23, 23)
            true
        }
        btGermany24.setOnLongClickListener {
            favorite(24, 24)
            true
        }
        btGermany25.setOnLongClickListener {
            favorite(25, 25)
            true
        }
        btGermany26.setOnLongClickListener {
            favorite(26, 26)
            true
        }
        btGermany27.setOnLongClickListener {
            favorite(27, 27)
            true
        }
        btGermany28.setOnLongClickListener {
            favorite(28, 28)
            true
        }
        btGermany29.setOnLongClickListener {
            favorite(29, 29)
            true
        }
        btGermany30.setOnLongClickListener {
            favorite(30, 30)
            true
        }
        btGermany31.setOnLongClickListener {
            favorite(31, 31)
            true
        }
        btGermany32.setOnLongClickListener {
            favorite(32, 32)
            true
        }
        btGermany33.setOnLongClickListener {
            favorite(33, 33)
            true
        }
        btGermany34.setOnLongClickListener {
            favorite(34, 34)
            true
        }
        btGermany35.setOnLongClickListener {
            favorite(35, 35)
            true
        }
        btGermany36.setOnLongClickListener {
            favorite(36, 36)
            true
        }
        btGermany37.setOnLongClickListener {
            favorite(37, 37)
            true
        }
        btGermany38.setOnLongClickListener {
            favorite(38, 38)
            true
        }
        btGermany39.setOnLongClickListener {
            favorite(39, 39)
            true
        }
        btGermany40.setOnLongClickListener {
            favorite(40, 40)
            true
        }
        btGermany41.setOnLongClickListener {
            favorite(41, 41)
            true
        }
        btGermany42.setOnLongClickListener {
            favorite(42, 42)
            true
        }
        btGermany43.setOnLongClickListener {
            favorite(43, 43)
            true
        }
        btGermany44.setOnLongClickListener {
            favorite(44, 44)
            true
        }
        btGermany45.setOnLongClickListener {
            favorite(45, 45)
            true
        }
        btGermany46.setOnLongClickListener {
            favorite(46, 46)
            true
        }
        btGermany47.setOnLongClickListener {
            favorite(47, 47)
            true
        }
        btGermany48.setOnLongClickListener {
            favorite(48, 48)
            true
        }
        btGermany49.setOnLongClickListener {
            favorite(49, 49)
            true
        }
        btGermany50.setOnLongClickListener {
            favorite(50, 50)
            true
        }
        btGermany51.setOnLongClickListener {
            favorite(51, 51)
            true
        }
        btGermany52.setOnLongClickListener {
            favorite(52, 52)
            true
        }
        btGermany53.setOnLongClickListener {
            favorite(53, 53)
            true
        }
        btGermany54.setOnLongClickListener {
            favorite(54, 54)
            true
        }
        btGermany55.setOnLongClickListener {
            favorite(55, 55)
            true
        }
        btGermany56.setOnLongClickListener {
            favorite(56, 56)
            true
        }
        btGermany57.setOnLongClickListener {
            favorite(57, 57)
            true
        }
        btGermany58.setOnLongClickListener {
            favorite(58, 58)
            true
        }
        btGermany59.setOnLongClickListener {
            favorite(59, 59)
            true
        }
        btGermany60.setOnLongClickListener {
            favorite(60, 60)
            true
        }
        btGermany61.setOnLongClickListener {
            favorite(61, 61)
            true
        }
        btGermany62.setOnLongClickListener {
            favorite(62, 62)
            true
        }
        btGermany63.setOnLongClickListener {
            favorite(63, 63)
            true
        }
        btGermany64.setOnLongClickListener {
            favorite(64, 64)
            true
        }
        btGermany65.setOnLongClickListener {
            favorite(65, 65)
            true
        }
        btGermany66.setOnLongClickListener {
            favorite(66, 66)
            true
        }
        btGermany67.setOnLongClickListener {
            favorite(67, 67)
            true
        }
        btGermany68.setOnLongClickListener {
            favorite(68, 68)
            true
        }
        btGermany69.setOnLongClickListener {
            favorite(69, 69)
            true
        }
        btGermany70.setOnLongClickListener {
            favorite(70, 70)
            true
        }
        btGermany71.setOnLongClickListener {
            favorite(71, 71)
            true
        }
        btGermany72.setOnLongClickListener {
            favorite(72, 72)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@Germany, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Germany", x.toString(), "m3u8", "image", "germany$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
