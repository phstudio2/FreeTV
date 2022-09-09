package com.phstudio.freetv

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.phstudio.freetv.R.*
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.favorite.FavoriteActivity
import com.phstudio.freetv.player.LinkActivity
import com.phstudio.freetv.ui.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val clNews = findViewById<ConstraintLayout>(id.clNews)
        val clMovies = findViewById<ConstraintLayout>(id.clMovies)
        val clChannels = findViewById<ConstraintLayout>(id.clChannels)
        val clMusic = findViewById<ConstraintLayout>(id.clMusic)
        val clLink = findViewById<ConstraintLayout>(id.clLink)
        val ivAbout = findViewById<AppCompatImageView>(id.ivAbout)
        val llCountries = findViewById<LinearLayout>(id.llCountries)
        val llStreams = findViewById<LinearLayout>(id.llStreams)
        val llFavorites = findViewById<LinearLayout>(id.llFavorites)

        llCountries.setOnClickListener {
            sendActivity(ChannelsActivity())
        }

        llStreams.setOnClickListener {
            showDialog()
        }

        llFavorites.setOnClickListener {
            sendActivity(FavoriteActivity())
        }

        ivAbout.setOnClickListener {
            sendActivity(AboutActivity())
        }

        clNews.setOnClickListener {
            sendActivity(NewsActivity())
        }

        clMovies.setOnClickListener {
            sendActivity(MoviesActivity())
        }

        clMovies.setOnLongClickListener {
            warningDialog()
            true
        }

        clChannels.setOnClickListener {
            sendActivity(ChannelsActivity())
        }
        clMusic.setOnClickListener {
            sendActivity(MusicActivity())
        }

        clLink.setOnClickListener {
            showDialog()
        }
    }

    private fun sendActivity(where: AppCompatActivity) {
        val intent = Intent(this, where::class.java)
        startActivity(intent)
    }

    private fun warningDialog() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(getString(string.adultWarning))
        builder.setMessage(getString(string.really))
        builder.setPositiveButton(getString(string.yes)) { _, _ ->
            val intent = Intent(this, AdultActivity::class.java)
            startActivity(intent)
        }
        builder.setNegativeButton(
            getString(string.no)
        ) { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    private fun showDialog() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(getString(string.enterLink))
        val input = EditText(this)
        input.hint = getString(string.hint)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)
        builder.setPositiveButton(getString(string.start)) { _, _ ->
            val text = input.text.toString()
            if (text.isNotEmpty()) {
                val intent = Intent(this, LinkActivity::class.java)
                intent.putExtra("Link", text)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, getString(string.empty), Toast.LENGTH_SHORT)
                    .show()
            }
        }
        builder.setNegativeButton(
            getString(string.cancel)
        ) { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    override fun onResume() {
        super.onResume()
        val tvFavoriteSum = findViewById<TextView>(id.tvFavoriteSum)
        val db = Database(this, null)
        val sum = db.getSum()
        tvFavoriteSum.text = sum.toString()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val dialogBuilder = android.app.AlertDialog.Builder(this)
        dialogBuilder.setIcon(mipmap.ic_launcher_round)
        dialogBuilder.setMessage(getString(string.closeApp))
            .setCancelable(false)
            .setPositiveButton(getString(string.yes)) { _, _ ->
                finishAffinity()
            }
            .setNegativeButton(getString(string.no)) { dialog, _ ->
                dialog.cancel()
            }
        val alert = dialogBuilder.create()
        alert.setTitle(getString(string.exitApp))
        alert.show()
    }
}