package com.phstudio.freetv

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.phstudio.freetv.R.id
import com.phstudio.freetv.R.layout
import com.phstudio.freetv.R.mipmap
import com.phstudio.freetv.R.string
import com.phstudio.freetv.custom.CustomActivity
import com.phstudio.freetv.favorite.Database
import com.phstudio.freetv.favorite.FavoriteActivity
import com.phstudio.freetv.ui.AboutActivity
import com.phstudio.freetv.ui.AdultActivity
import com.phstudio.freetv.ui.ChannelsActivity


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
            sendActivity(CustomActivity())
        }

        llFavorites.setOnClickListener {
            sendActivity(FavoriteActivity())
        }

        ivAbout.setOnClickListener {
            sendActivity(AboutActivity())
        }

        clNews.setOnClickListener {
            sendActivity("zz_news_en", "news")
        }

        clMovies.setOnClickListener {
            sendActivity("zz_movies", "movies")
        }

        clMovies.setOnLongClickListener {
            warningDialog()
            true
        }

        clChannels.setOnClickListener {
            sendActivity(ChannelsActivity())
        }
        clMusic.setOnClickListener {
            sendActivity("music", "music")
        }

        clLink.setOnClickListener {
            sendActivity(CustomActivity())
        }
    }

    @SuppressLint("DiscouragedApi")
    private fun sendActivity(country: String, code: String) {
        val intent = Intent(this, com.phstudio.freetv.ui.LinkActivity::class.java)
        intent.putExtra("country", country)
        intent.putExtra("code", code)
        intent.putExtra(
            "tvPrimary",
            getString(resources.getIdentifier(code, "string", packageName))
        )
        intent.putExtra("ivDrawable", resources.getIdentifier(code, "drawable", packageName))
        startActivity(intent)
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