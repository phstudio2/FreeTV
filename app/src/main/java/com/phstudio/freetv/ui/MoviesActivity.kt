package com.phstudio.freetv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.player.PlayerActivity

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_movies)

        val btMovies1 = findViewById<Button>(R.id.btMovies1)
        val btMovies2 = findViewById<Button>(R.id.btMovies2)
        val btMovies3 = findViewById<Button>(R.id.btMovies3)
        val btMovies4 = findViewById<Button>(R.id.btMovies4)
        val btMovies5 = findViewById<Button>(R.id.btMovies5)
        val btMovies6 = findViewById<Button>(R.id.btMovies6)
        val btMovies7 = findViewById<Button>(R.id.btMovies7)
        val btMovies8 = findViewById<Button>(R.id.btMovies8)
        val btMovies9 = findViewById<Button>(R.id.btMovies9)
        val btMovies10 = findViewById<Button>(R.id.btMovies10)
        val btMovies11 = findViewById<Button>(R.id.btMovies11)
        val btMovies12 = findViewById<Button>(R.id.btMovies12)
        val btMovies13 = findViewById<Button>(R.id.btMovies13)
        val btMovies14 = findViewById<Button>(R.id.btMovies14)
        val btMovies15 = findViewById<Button>(R.id.btMovies15)
        val btMovies16 = findViewById<Button>(R.id.btMovies16)
        val btMovies17 = findViewById<Button>(R.id.btMovies17)
        val btMovies18 = findViewById<Button>(R.id.btMovies18)
        val btMovies19 = findViewById<Button>(R.id.btMovies19)
        val btMovies20 = findViewById<Button>(R.id.btMovies20)
        val btMovies21 = findViewById<Button>(R.id.btMovies21)
        val btMovies22 = findViewById<Button>(R.id.btMovies22)
        val btMovies23 = findViewById<Button>(R.id.btMovies23)
        val btMovies24 = findViewById<Button>(R.id.btMovies24)
        val btMovies25 = findViewById<Button>(R.id.btMovies25)
        val btMovies26 = findViewById<Button>(R.id.btMovies26)

        val m3u8 = resources.getStringArray(R.array.movies_m3u8)

        btMovies1.setOnClickListener {
            player(1, m3u8)
        }
        btMovies2.setOnClickListener {
            player(2, m3u8)
        }
        btMovies3.setOnClickListener {
            player(3, m3u8)
        }
        btMovies4.setOnClickListener {
            player(4, m3u8)
        }
        btMovies5.setOnClickListener {
            player(5, m3u8)
        }
        btMovies6.setOnClickListener {
            player(6, m3u8)
        }
        btMovies7.setOnClickListener {
            player(7, m3u8)
        }
        btMovies8.setOnClickListener {
            player(8, m3u8)
        }
        btMovies9.setOnClickListener {
            player(9, m3u8)
        }
        btMovies10.setOnClickListener {
            player(10, m3u8)
        }
        btMovies11.setOnClickListener {
            player(11, m3u8)
        }
        btMovies12.setOnClickListener {
            player(12, m3u8)
        }
        btMovies13.setOnClickListener {
            player(13, m3u8)
        }
        btMovies14.setOnClickListener {
            player(14, m3u8)
        }
        btMovies15.setOnClickListener {
            player(15, m3u8)
        }
        btMovies16.setOnClickListener {
            player(16, m3u8)
        }
        btMovies17.setOnClickListener {
            player(17, m3u8)
        }
        btMovies18.setOnClickListener {
            player(18, m3u8)
        }
        btMovies19.setOnClickListener {
            player(19, m3u8)
        }
        btMovies20.setOnClickListener {
            player(20, m3u8)
        }
        btMovies21.setOnClickListener {
            player(21, m3u8)
        }
        btMovies22.setOnClickListener {
            player(22, m3u8)
        }
        btMovies23.setOnClickListener {
            player(23, m3u8)
        }
        btMovies24.setOnClickListener {
            player(24, m3u8)
        }
        btMovies25.setOnClickListener {
            player(25, m3u8)
        }
        btMovies26.setOnClickListener {
            player(26, m3u8)
        }
        btMovies1.setOnLongClickListener {
            favorite(1, 1)
            true
        }
        btMovies2.setOnLongClickListener {
            favorite(2, 2)
            true
        }
        btMovies3.setOnLongClickListener {
            favorite(3, 3)
            true
        }
        btMovies4.setOnLongClickListener {
            favorite(4, 4)
            true
        }
        btMovies5.setOnLongClickListener {
            favorite(5, 5)
            true
        }
        btMovies6.setOnLongClickListener {
            favorite(6, 6)
            true
        }
        btMovies7.setOnLongClickListener {
            favorite(7, 7)
            true
        }
        btMovies8.setOnLongClickListener {
            favorite(8, 8)
            true
        }
        btMovies9.setOnLongClickListener {
            favorite(9, 9)
            true
        }
        btMovies10.setOnLongClickListener {
            favorite(10, 10)
            true
        }
        btMovies11.setOnLongClickListener {
            favorite(11, 11)
            true
        }
        btMovies12.setOnLongClickListener {
            favorite(12, 12)
            true
        }
        btMovies13.setOnLongClickListener {
            favorite(13, 13)
            true
        }
        btMovies14.setOnLongClickListener {
            favorite(14, 14)
            true
        }
        btMovies15.setOnLongClickListener {
            favorite(15, 15)
            true
        }
        btMovies16.setOnLongClickListener {
            favorite(16, 16)
            true
        }
        btMovies17.setOnLongClickListener {
            favorite(17, 17)
            true
        }
        btMovies18.setOnLongClickListener {
            favorite(18, 18)
            true
        }
        btMovies19.setOnLongClickListener {
            favorite(19, 19)
            true
        }
        btMovies20.setOnLongClickListener {
            favorite(20, 20)
            true
        }
        btMovies21.setOnLongClickListener {
            favorite(21, 21)
            true
        }
        btMovies22.setOnLongClickListener {
            favorite(22, 22)
            true
        }
        btMovies23.setOnLongClickListener {
            favorite(23, 23)
            true
        }
        btMovies24.setOnLongClickListener {
            favorite(24, 24)
            true
        }
        btMovies25.setOnLongClickListener {
            favorite(25, 25)
            true
        }
        btMovies26.setOnLongClickListener {
            favorite(26, 26)
            true
        }

    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@MoviesActivity, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun favorite(x: Int, y: Int) {
        val db = Database(this, null)
        db.writeToDb("Movies", x.toString(), "m3u8", "movies$y", "movies$y")
        Toast.makeText(this, getString(R.string.addedToFav), Toast.LENGTH_SHORT).show()
    }
}
