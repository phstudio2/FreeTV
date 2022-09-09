package com.phstudio.freetv.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.phstudio.freetv.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_about)
        val tvDeveloper = findViewById<TextView>(R.id.tvDeveloper)
        val tvApplicationDevelopment = findViewById<TextView>(R.id.tvApplicationDevelopment)
        val ibWebsite = findViewById<ImageButton>(R.id.ibWebsite)
        val tvWebsite = findViewById<TextView>(R.id.tvWebsite)
        val ibGitHub = findViewById<ImageButton>(R.id.ibGitHub)
        val tvGitHub = findViewById<TextView>(R.id.tvGitHub)
        val btAbout1 = findViewById<Button>(R.id.btAbout1)
        val btAbout2 = findViewById<Button>(R.id.btAbout2)
        val btAbout3 = findViewById<Button>(R.id.btAbout3)
        val btAbout4 = findViewById<Button>(R.id.btAbout4)
        val btAbout5 = findViewById<Button>(R.id.btAbout5)
        val btAbout6 = findViewById<Button>(R.id.btAbout6)

        tvDeveloper.setOnClickListener {
            Toast.makeText(this, getString(R.string.developer), Toast.LENGTH_SHORT).show()
        }

        tvApplicationDevelopment.setOnClickListener {
            Toast.makeText(this, getString(R.string.app_version), Toast.LENGTH_SHORT).show()
        }

        ibWebsite.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.about))
            )
            startActivity(browserIntent)
        }

        tvWebsite.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.about))
            )
            startActivity(browserIntent)
        }

        ibGitHub.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.github))
            )
            startActivity(browserIntent)
        }

        tvGitHub.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.github))
            )
            startActivity(browserIntent)
        }

        btAbout1.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.googlePlay))
            )
            startActivity(browserIntent)
        }

        btAbout2.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.report))
            )
            startActivity(browserIntent)
        }

        btAbout2.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.report))
            )
            startActivity(browserIntent)
        }

        btAbout3.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.share_mail))
            intent.putExtra(
                Intent.EXTRA_TEXT,
                (resources.getString(R.string.email_text) + "\n" + resources.getString(
                    R.string.email_text2
                ) + "\n" + resources.getString(R.string.email_text3))
            )
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, resources.getString(R.string.select_email)))
        }

        btAbout4.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.telegram))
            )
            startActivity(browserIntent)
        }

        btAbout5.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.privacy))
            )
            startActivity(browserIntent)
        }

        btAbout6.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.terms))
            )
            startActivity(browserIntent)
        }
    }
}
