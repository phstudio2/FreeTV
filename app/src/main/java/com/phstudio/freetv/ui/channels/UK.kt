package com.phstudio.freetv.ui.channels

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity


class UK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_uk)

        val btUK1 = findViewById<Button>(R.id.btUK1)
        val btUK2 = findViewById<Button>(R.id.btUK2)
        val btUK3 = findViewById<Button>(R.id.btUK3)
        val btUK4 = findViewById<Button>(R.id.btUK4)
        val btUK5 = findViewById<Button>(R.id.btUK5)
        val btUK6 = findViewById<Button>(R.id.btUK6)
        val btUK7 = findViewById<Button>(R.id.btUK7)
        val btUK8 = findViewById<Button>(R.id.btUK8)
        val btUK9 = findViewById<Button>(R.id.btUK9)
        val btUK10 = findViewById<Button>(R.id.btUK10)
        val btUK11 = findViewById<Button>(R.id.btUK11)
        val btUK12 = findViewById<Button>(R.id.btUK12)
        val btUK13 = findViewById<Button>(R.id.btUK13)
        val btUK14 = findViewById<Button>(R.id.btUK14)
        val btUK15 = findViewById<Button>(R.id.btUK15)
        val btUK16 = findViewById<Button>(R.id.btUK16)
        val btUK17 = findViewById<Button>(R.id.btUK17)
        val btUK18 = findViewById<Button>(R.id.btUK18)
        val btUK19 = findViewById<Button>(R.id.btUK19)
        val btUK20 = findViewById<Button>(R.id.btUK20)
        val btUK21 = findViewById<Button>(R.id.btUK21)
        val btUK22 = findViewById<Button>(R.id.btUK22)
        val btUK23 = findViewById<Button>(R.id.btUK23)
        val btUK24 = findViewById<Button>(R.id.btUK24)
        val btUK25 = findViewById<Button>(R.id.btUK25)
        val btUK26 = findViewById<Button>(R.id.btUK26)
        val btUK27 = findViewById<Button>(R.id.btUK27)
        val btUK28 = findViewById<Button>(R.id.btUK28)
        val btUK29 = findViewById<Button>(R.id.btUK29)
        val btUK30 = findViewById<Button>(R.id.btUK30)
        val btUK31 = findViewById<Button>(R.id.btUK31)
        val btUK32 = findViewById<Button>(R.id.btUK32)
        val btUK33 = findViewById<Button>(R.id.btUK33)
        val btUK34 = findViewById<Button>(R.id.btUK34)
        val btUK35 = findViewById<Button>(R.id.btUK35)
        val btUK36 = findViewById<Button>(R.id.btUK36)
        val btUK37 = findViewById<Button>(R.id.btUK37)
        val btUK38 = findViewById<Button>(R.id.btUK38)
        val btUK39 = findViewById<Button>(R.id.btUK39)
        val btUK40 = findViewById<Button>(R.id.btUK40)
        val btUK41 = findViewById<Button>(R.id.btUK41)
        val btUK42 = findViewById<Button>(R.id.btUK42)
        val btUK43 = findViewById<Button>(R.id.btUK43)
        val btUK44 = findViewById<Button>(R.id.btUK44)
        val btUK45 = findViewById<Button>(R.id.btUK45)
        val btUK46 = findViewById<Button>(R.id.btUK46)
        val btUK47 = findViewById<Button>(R.id.btUK47)
        val btUK48 = findViewById<Button>(R.id.btUK48)
        val btUK49 = findViewById<Button>(R.id.btUK49)
        val btUK50 = findViewById<Button>(R.id.btUK50)
        val btUK51 = findViewById<Button>(R.id.btUK51)
        val btUK52 = findViewById<Button>(R.id.btUK52)
        val btUK53 = findViewById<Button>(R.id.btUK53)
        val btUK54 = findViewById<Button>(R.id.btUK54)
        val btUK55 = findViewById<Button>(R.id.btUK55)
        val btUK56 = findViewById<Button>(R.id.btUK56)
        val btUK57 = findViewById<Button>(R.id.btUK57)
        val btUK58 = findViewById<Button>(R.id.btUK58)
        val btUK59 = findViewById<Button>(R.id.btUK59)

        val m3u8 = resources.getStringArray(R.array.uk_m3u8)

        btUK1.setOnClickListener {
            player(1, m3u8)
        }
        btUK2.setOnClickListener {
            player(2, m3u8)
        }
        btUK3.setOnClickListener {
            player(3, m3u8)
        }
        btUK4.setOnClickListener {
            player(4, m3u8)
        }
        btUK5.setOnClickListener {
            player(5, m3u8)
        }
        btUK6.setOnClickListener {
            player(6, m3u8)
        }
        btUK7.setOnClickListener {
            player(7, m3u8)
        }
        btUK8.setOnClickListener {
            player(8, m3u8)
        }
        btUK9.setOnClickListener {
            player(9, m3u8)
        }
        btUK10.setOnClickListener {
            player(10, m3u8)
        }
        btUK11.setOnClickListener {
            player(11, m3u8)
        }
        btUK12.setOnClickListener {
            player(12, m3u8)
        }
        btUK13.setOnClickListener {
            player(13, m3u8)
        }
        btUK14.setOnClickListener {
            player(14, m3u8)
        }
        btUK15.setOnClickListener {
            player(15, m3u8)
        }
        btUK16.setOnClickListener {
            player(16, m3u8)
        }
        btUK17.setOnClickListener {
            player(17, m3u8)
        }
        btUK18.setOnClickListener {
            player(18, m3u8)
        }
        btUK19.setOnClickListener {
            player(19, m3u8)
        }
        btUK20.setOnClickListener {
            player(20, m3u8)
        }
        btUK21.setOnClickListener {
            player(21, m3u8)
        }
        btUK22.setOnClickListener {
            player(22, m3u8)
        }
        btUK23.setOnClickListener {
            player(23, m3u8)
        }
        btUK24.setOnClickListener {
            player(24, m3u8)
        }
        btUK25.setOnClickListener {
            player(25, m3u8)
        }
        btUK26.setOnClickListener {
            player(26, m3u8)
        }
        btUK27.setOnClickListener {
            player(27, m3u8)
        }
        btUK28.setOnClickListener {
            player(28, m3u8)
        }
        btUK29.setOnClickListener {
            player(29, m3u8)
        }
        btUK30.setOnClickListener {
            player(30, m3u8)
        }
        btUK31.setOnClickListener {
            player(31, m3u8)
        }
        btUK32.setOnClickListener {
            player(32, m3u8)
        }
        btUK33.setOnClickListener {
            player(33, m3u8)
        }
        btUK34.setOnClickListener {
            player(34, m3u8)
        }
        btUK35.setOnClickListener {
            player(35, m3u8)
        }
        btUK36.setOnClickListener {
            player(36, m3u8)
        }
        btUK37.setOnClickListener {
            player(37, m3u8)
        }
        btUK38.setOnClickListener {
            player(38, m3u8)
        }
        btUK39.setOnClickListener {
            player(39, m3u8)
        }
        btUK40.setOnClickListener {
            player(40, m3u8)
        }
        btUK41.setOnClickListener {
            player(41, m3u8)
        }
        btUK42.setOnClickListener {
            player(42, m3u8)
        }
        btUK43.setOnClickListener {
            player(43, m3u8)
        }
        btUK44.setOnClickListener {
            player(44, m3u8)
        }
        btUK45.setOnClickListener {
            player(45, m3u8)
        }
        btUK46.setOnClickListener {
            player(46, m3u8)
        }
        btUK47.setOnClickListener {
            player(47, m3u8)
        }
        btUK48.setOnClickListener {
            player(48, m3u8)
        }
        btUK49.setOnClickListener {
            player(49, m3u8)
        }
        btUK50.setOnClickListener {
            player(50, m3u8)
        }
        btUK51.setOnClickListener {
            player(51, m3u8)
        }
        btUK52.setOnClickListener {
            player(52, m3u8)
        }
        btUK53.setOnClickListener {
            player(53, m3u8)
        }
        btUK54.setOnClickListener {
            player(54, m3u8)
        }
        btUK55.setOnClickListener {
            player(55, m3u8)
        }
        btUK56.setOnClickListener {
            player(56, m3u8)
        }
        btUK57.setOnClickListener {
            player(57, m3u8)
        }
        btUK58.setOnClickListener {
            player(58, m3u8)
        }
        btUK59.setOnClickListener {
            player(59, m3u8)
        }

        btUK1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btUK2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btUK3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btUK4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btUK5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btUK6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btUK7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btUK8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btUK9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btUK10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btUK11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btUK12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btUK13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btUK14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btUK15.setOnLongClickListener {
            favorite(15, 15)
            true
        }
        btUK16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btUK17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
        btUK18.setOnLongClickListener {
            favorite(18, 18)
            true
        }
        btUK19.setOnLongClickListener {
            favorite(19, 19)
            true
        }
        btUK20.setOnLongClickListener {
            favorite(20, 20)
            true
        }
        btUK21.setOnLongClickListener {
            favorite(21, 21)
            true
        }
        btUK22.setOnLongClickListener {
            favorite(22, 22)
            true
        }
        btUK23.setOnLongClickListener {
            favorite(23, 23)
            true
        }
        btUK24.setOnLongClickListener {
            favorite(24, 24)
            true
        }
        btUK25.setOnLongClickListener {
            favorite(25, 25)
            true
        }
        btUK26.setOnLongClickListener {
            favorite(26, 26)
            true
        }
        btUK27.setOnLongClickListener {
            favorite(27, 27)
            true
        }
        btUK28.setOnLongClickListener {
            favorite(28, 28)
            true
        }
        btUK29.setOnLongClickListener {
            favorite(29, 29)
            true
        }
        btUK30.setOnLongClickListener {
            favorite(30, 30)
            true
        }
        btUK31.setOnLongClickListener {
            favorite(31, 31)
            true
        }
        btUK32.setOnLongClickListener {
            favorite(32, 32)
            true
        }
        btUK33.setOnLongClickListener {
            favorite(33, 33)
            true
        }
        btUK34.setOnLongClickListener {
            favorite(34, 34)
            true
        }
        btUK35.setOnLongClickListener {
            favorite(35, 35)
            true
        }
        btUK36.setOnLongClickListener {
            favorite(36, 36)
            true
        }
        btUK37.setOnLongClickListener {
            favorite(37, 37)
            true
        }
        btUK38.setOnLongClickListener {
            favorite(38, 38)
            true
        }
        btUK39.setOnLongClickListener {
            favorite(39, 39)
            true
        }
        btUK40.setOnLongClickListener {
            favorite(40, 40)
            true
        }
        btUK41.setOnLongClickListener {
            favorite(41, 41)
            true
        }
        btUK42.setOnLongClickListener {
            favorite(42, 42)
            true
        }
        btUK43.setOnLongClickListener {
            favorite(43, 43)
            true
        }
        btUK44.setOnLongClickListener {
            favorite(44, 44)
            true
        }
        btUK45.setOnLongClickListener {
            favorite(45, 45)
            true
        }
        btUK46.setOnLongClickListener {
            favorite(46, 46)
            true
        }
        btUK47.setOnLongClickListener {
            favorite(47, 47)
            true
        }
        btUK48.setOnLongClickListener {
            favorite(48, 48)
            true
        }
        btUK49.setOnLongClickListener {
            favorite(49, 49)
            true
        }
        btUK50.setOnLongClickListener {
            favorite(50, 50)
            true
        }
        btUK51.setOnLongClickListener {
            favorite(51, 51)
            true
        }
        btUK52.setOnLongClickListener {
            favorite(52, 52)
            true
        }
        btUK53.setOnLongClickListener {
            favorite(53, 53)
            true
        }
        btUK54.setOnLongClickListener {
            favorite(54, 54)
            true
        }
        btUK55.setOnLongClickListener {
            favorite(55, 55)
            true
        }
        btUK56.setOnLongClickListener {
            favorite(56, 56)
            true
        }
        btUK57.setOnLongClickListener {
            favorite(57, 57)
            true
        }
        btUK58.setOnLongClickListener {
            favorite(58, 58)
            true
        }
        btUK59.setOnLongClickListener {
            favorite(59, 59)
            true
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@UK, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("UK", x.toString(), "m3u8", "image", "uk$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
