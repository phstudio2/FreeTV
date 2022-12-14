package com.phstudio.freetv.favorite

import android.Manifest
import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.phstudio.freetv.R
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset


class FavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_favorite)

        val db = Database(this, null)
        val userList: ArrayList<HashMap<String, Any>> = db.getData(this)
        val lv = findViewById<View>(R.id.lvFavorite) as ListView
        db.close()
        val adapter: ListAdapter = SimpleAdapter(
            this,
            userList,
            R.layout.list_favorite,
            arrayOf("picture", "string"),
            intArrayOf(R.id.ivFavorite, R.id.tvFavorite)
        )
        lv.adapter = adapter

        lv.onItemClickListener = OnItemClickListener { _, _, pos, _ ->
            getPos(pos)
        }

        lv.onItemLongClickListener =
            OnItemLongClickListener { _, _, pos, _ ->
                dialogDeleteRec(pos)
                true
            }
        val btExport = findViewById<Button>(R.id.btExport)
        btExport.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                dialogExportDb()
            }
        }

        val btImport = findViewById<Button>(R.id.btImport)
        btImport.setOnClickListener {
            dialogImportDb()
        }

        val btDelete = findViewById<Button>(R.id.btDelete)
        btDelete.setOnClickListener {
            dialogDeleteDb()
        }

        val tvFavoriteEmpty = findViewById<TextView>(R.id.tvFavoriteEmpty)
        if (adapter.isEmpty) {
            tvFavoriteEmpty.visibility = View.VISIBLE
        } else {
            tvFavoriteEmpty.visibility = View.GONE
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val hereUrl: Uri = data!!.data!!
            val inputStream = this@FavoriteActivity.contentResolver.openInputStream(hereUrl)
            val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))
            try {
                reader.readLines().forEach {
                    val item = it.split(",")
                    if (item[1] != "source" && item[2] != "number" && item[3] != "playlist" && item[4] != "picture" && item[5] != "string") {
                        val db = Database(this, null)
                        db.writeToDb(item[1], item[2], item[3], item[4], item[5])
                    }
                }
            } catch (e: FileNotFoundException) {
                Toast.makeText(
                    this,
                    getString(R.string.error) + " " + e.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            } catch (e: IOException) {
                Toast.makeText(
                    this,
                    getString(R.string.error) + " " + e.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

            Toast.makeText(this, getString(R.string.okay), Toast.LENGTH_SHORT).show()
            restart()
        }
    }

    private fun dialogImportDb() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.importText))
        builder.setMessage(getString(R.string.really))
        builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
            val fileIntent = Intent(Intent.ACTION_GET_CONTENT)
            fileIntent.type = "*/*"
            try {
                startActivityForResult(fileIntent, 1)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    getString(R.string.error) + " " + e.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        builder.setNegativeButton(
            getString(R.string.no)
        ) { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    private fun dialogExportDb() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.exportText))
        builder.setMessage(getString(R.string.really))
        builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                saveDb()
            }
        }
        builder.setNegativeButton(
            getString(R.string.no)
        ) { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    private fun dialogDeleteDb() {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.deleteText))
        builder.setMessage(getString(R.string.really))
        builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
            val db = Database(this, null)
            db.deleteAllRec()
            db.close()
            restart()
        }
        builder.setNegativeButton(
            getString(R.string.no)
        ) { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    private fun dialogDeleteRec(pos: Int) {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.deleteRec))
        builder.setMessage(getString(R.string.really))
        builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
            getPos2(pos)
        }
        builder.setNegativeButton(
            getString(R.string.no)
        ) { dialog, _ -> dialog.cancel() }
        builder.show()
    }

    @SuppressLint("Range")
    private fun getPos(pos: Int) {
        val db = Database(this, null)
        val cursor = db.readFromDb()
        cursor!!.moveToPosition(pos)
        val send: String = cursor.getString(cursor.getColumnIndex(Database.COL3))
        val name: String = cursor.getString(cursor.getColumnIndex(Database.COL1))
        val x: Int = (cursor.getString(cursor.getColumnIndex(Database.COL2))).toInt()
        cursor.close()
        db.close()

        val help: Array<String>

        when {
            name == "News" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.news_m3u8)
                player(x, help)
            }
            name == "News" && send == "html" -> {
                help = resources.getStringArray(R.array.news_html)
                html(x, help)
            }
            name == "Movies" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.movies_m3u8)
                player(x, help)
            }
            name == "Music" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.music_m3u8)
                player(x, help)
            }
            name == "Adult" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.p_m3u8)
                player(x, help)
            }

            //CHANNELS
            name == "Argentina" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.argentina_m3u8)
                player(x, help)
            }
            name == "Argentina" && send == "html" -> {
                help = resources.getStringArray(R.array.argentina_html)
                html(x, help)
            }
            name == "Australia" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.australia_m3u8)
                player(x, help)
            }
            name == "Czech" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.cz_m3u8)
                player(x, help)
            }
            name == "Czech" && send == "html" -> {
                help = resources.getStringArray(R.array.cz_html)
                html(x, help)
            }
            name == "Germany" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.germany_m3u8)
                player(x, help)
            }
            name == "Slovakia" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.slovakia_m3u8)
                player(x, help)
            }
            name == "UK" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.uk_m3u8)
                player(x, help)
            }
            name == "USA" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.usa_m3u8)
                player(x, help)
            }
            name == "USA" && send == "html" -> {
                help = resources.getStringArray(R.array.usa_html)
                html(x, help)
            }
            name == "International" && send == "m3u8" -> {
                help = resources.getStringArray(R.array.international_m3u8)
                player(x, help)
            }
        }
    }

    @SuppressLint("Range")
    private fun getPos2(pos: Int) {
        val db = Database(this, null)
        val cursor = db.readFromDb()
        cursor!!.moveToPosition(pos)
        val id: String = cursor.getString(cursor.getColumnIndex(Database.ID_COL))
        cursor.close()
        db.deleteRec(id)
        Toast.makeText(
            this,
            getString(R.string.record) + id + getString(R.string.wasDeleted),
            Toast.LENGTH_SHORT
        ).show()
        db.close()
        restart()
    }

    private fun restart() {
        val intent = intent
        finish()
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, getString(R.string.permission_granted), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isStoragePermissionGranted(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
            ) {
                true
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    1
                )
                false
            }
        } else {
            true
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun saveDb() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (isStoragePermissionGranted()) {
                val export = Database(this@FavoriteActivity, null).exportDb()
                if (export) {
                    Toast.makeText(this, getString(R.string.saveOkay), Toast.LENGTH_SHORT).show()
                    restart()
                } else {
                    Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
                    restart()
                }
            }
        } else {
            Toast.makeText(this, getString(R.string.notSupported), Toast.LENGTH_SHORT).show()
            restart()
        }
    }

    private fun player(x: Int, name: Array<String>) {
        val intent = Intent(this@FavoriteActivity, PlayerActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }

    private fun html(x: Int, name: Array<String>) {
        val intent = Intent(this@FavoriteActivity, HTMLActivity::class.java)
        intent.putExtra("TV", x)
        intent.putExtra("Name", name)
        startActivity(intent)
    }
}