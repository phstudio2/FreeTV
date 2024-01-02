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

        val items = arrayOf(
            findViewById<TextView>(R.id.tvDeveloper),
            findViewById<TextView>(R.id.tvApplicationDevelopment),
            findViewById<ImageButton>(R.id.ibWebsite),
            findViewById<TextView>(R.id.tvWebsite),
            findViewById<ImageButton>(R.id.ibGitHub),
            findViewById<TextView>(R.id.tvGitHub),
            findViewById<Button>(R.id.btTelegram),
            findViewById<Button>(R.id.btLicense),
            findViewById<Button>(R.id.btReportBug),
            findViewById<Button>(R.id.btShare)
        )

        items.forEach { item ->
            item.setOnClickListener {
                when (item.id) {
                    R.id.tvDeveloper -> Toast.makeText(
                        this,
                        getString(R.string.developer),
                        Toast.LENGTH_SHORT
                    ).show()

                    R.id.tvApplicationDevelopment -> Toast.makeText(
                        this,
                        getString(R.string.app_version),
                        Toast.LENGTH_SHORT
                    ).show()

                    R.id.ibWebsite -> sendActivity(getString(R.string.about))
                    R.id.tvWebsite -> sendActivity(getString(R.string.about))
                    R.id.ibGitHub -> sendActivity(getString(R.string.github))
                    R.id.tvGitHub -> sendActivity(getString(R.string.github))
                    R.id.btTelegram -> sendActivity(getString(R.string.telegram))
                    R.id.btLicense -> sendActivity(getString(R.string.privacy))
                    R.id.btReportBug -> sendActivity(getString(R.string.report))
                    else -> {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.putExtra(
                            Intent.EXTRA_SUBJECT,
                            resources.getString(R.string.share_mail)
                        )
                        intent.putExtra(
                            Intent.EXTRA_TEXT,
                            (resources.getString(R.string.email_text) + "\n" + resources.getString(
                                R.string.email_text2
                            ) + "\n" + resources.getString(R.string.email_text3))
                        )
                        intent.type = "message/rfc822"
                        startActivity(
                            Intent.createChooser(
                                intent,
                                resources.getString(R.string.select_email)
                            )
                        )
                    }
                }
            }
        }
    }

    private fun sendActivity(url: String) {
        val browserIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        startActivity(browserIntent)
    }
}
