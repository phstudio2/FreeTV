package com.phstudio.freetv.custom

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.phstudio.freetv.R
import com.phstudio.freetv.player.HTMLActivity
import com.phstudio.freetv.player.PlayerActivity
import com.squareup.picasso.Picasso
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.Charset

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_custom)

        val db = DatabaseHelper(this, null)
        val userList: ArrayList<HashMap<String, Any>> = db.getData(this)
        val lv = findViewById<View>(R.id.lvCustom) as ListView
        db.close()
        val adapter: SimpleAdapter = object : SimpleAdapter(
            this,
            userList,
            R.layout.list_favorite,
            arrayOf("name", "logo"),
            intArrayOf(R.id.tvFavorite, R.id.ivFavorite)
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val imageView = view.findViewById<ImageView>(R.id.ivFavorite)
                val logoUrl = userList[position]["logo"].toString()

                loadImage(logoUrl, this@CustomActivity) { drawable ->
                    imageView.setImageDrawable(drawable)
                }

                return view
            }
        }

        lv.adapter = adapter

        lv.onItemClickListener = OnItemClickListener { _, _, pos, _ ->
            getPos(pos)
        }

        lv.onItemLongClickListener =
            OnItemLongClickListener { _, _, pos, _ ->
                getPos3(pos)
                true
            }


        val btAdd = findViewById<Button>(R.id.btAdd)
        btAdd.setOnClickListener {
            showCustomDialog()
        }

        val btExport = findViewById<Button>(R.id.btExport)
        btExport.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                dialogExportDb()
            } else {
                Toast.makeText(this, getString(R.string.notSupported), Toast.LENGTH_SHORT).show()
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

        val tvFavoriteEmpty = findViewById<TextView>(R.id.tvCustomEmpty)
        val ivCustom = findViewById<ImageView>(R.id.ivCustom)

        if (adapter.isEmpty) {
            tvFavoriteEmpty.visibility = View.VISIBLE
            ivCustom.visibility = View.VISIBLE
        } else {
            tvFavoriteEmpty.visibility = View.GONE
            ivCustom.visibility = View.GONE
        }

        tvFavoriteEmpty.setOnClickListener {
            showCustomDialog()
        }
        ivCustom.setOnClickListener {
            showCustomDialog()
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun loadImage(url: String, context: Context, completion: (Drawable?) -> Unit) {
        try {
            if (url.isNotEmpty()) {
                Picasso.get().load(url)
                    .resize(200, 200)
                    .centerInside()
                    .into(object : com.squareup.picasso.Target {
                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                            bitmap?.let {
                                val drawable = BitmapDrawable(context.resources, it)
                                completion(drawable)
                            }
                        }

                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                            completion(errorDrawable)
                        }

                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                            completion(placeHolderDrawable)
                        }
                    })
            } else {
                completion(context.resources.getDrawable(R.drawable.image))
            }
        } catch (e: Exception) {
            e.printStackTrace()
            completion(null)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val hereUrl: Uri = data!!.data!!
            val inputStream = this@CustomActivity.contentResolver.openInputStream(hereUrl)
            val reader = BufferedReader(InputStreamReader(inputStream, Charset.forName("UTF-8")))
            try {
                reader.readLines().forEach {
                    val item = it.split(",")
                    if (item[1] != "name" && item[2] != "logo" && item[3] != "url") {
                        val db = DatabaseHelper(this, null)
                        db.writeToDb(item[1], item[2], item[3])
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

    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_custom)
        val window = dialog.window
        val layoutParams = window?.attributes
        layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = layoutParams

        val btOkay = dialog.findViewById<Button>(R.id.btOkay)

        val etName = dialog.findViewById<EditText>(R.id.etName)
        val etLogo = dialog.findViewById<EditText>(R.id.etLogo)
        val etLink = dialog.findViewById<EditText>(R.id.etLink)

        btOkay.setOnClickListener {
            val name = etName.text.toString()
            val logo = etLogo.text.toString()
            val url = etLink.text.toString()
            val db = DatabaseHelper(this, null)
            db.writeToDb(name, logo, url)
            db.close()
            dialog.dismiss()
            restart()
        }

        dialog.show()
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
            if (Build.VERSION.SDK_INT >= 33) {
                saveDb14()
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    saveDb()
                }
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
            val db = DatabaseHelper(this, null)
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
        val db = DatabaseHelper(this, null)
        val cursor = db.readFromDb()
        cursor!!.moveToPosition(pos)
        val url: String = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL3))
        cursor.close()
        db.close()

        if (url.contains("https://www.youtube.com") || url.contains("https://www.televizeseznam.cz/tv")) {
            val intent = Intent(this@CustomActivity, HTMLActivity::class.java)
            intent.putExtra("Name", url)
            startActivity(intent)
        } else {
            val intent = Intent(this@CustomActivity, PlayerActivity::class.java)
            intent.putExtra("Name", url)
            startActivity(intent)
        }
    }

    @SuppressLint("Range")
    private fun getPos2(pos: Int) {
        val db = DatabaseHelper(this, null)
        val cursor = db.readFromDb()
        cursor!!.moveToPosition(pos)
        val id: String = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ID_COL))
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

    @SuppressLint("Range")
    private fun getPos3(pos: Int) {
        val db = DatabaseHelper(this, null)
        val cursor = db.readFromDb()
        cursor!!.moveToPosition(pos)
        val id: Int = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.ID_COL))
        var name: String = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL1))
        var logo: String = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL2))
        var url: String = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL3))
        cursor.close()
        db.close()

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_custom)
        val window = dialog.window
        val layoutParams = window?.attributes
        layoutParams?.width = WindowManager.LayoutParams.MATCH_PARENT
        window?.attributes = layoutParams

        val btDelete = dialog.findViewById<Button>(R.id.btDelete)
        btDelete.visibility = View.VISIBLE

        val btOkay = dialog.findViewById<Button>(R.id.btOkay)

        val etName = dialog.findViewById<EditText>(R.id.etName)
        val etLogo = dialog.findViewById<EditText>(R.id.etLogo)
        val etLink = dialog.findViewById<EditText>(R.id.etLink)

        etName.setText(name)
        etLogo.setText(logo)
        etLink.setText(url)

        btOkay.setOnClickListener {
            name = etName.text.toString()
            logo = etLogo.text.toString()
            url = etLink.text.toString()

            db.editToDb(name, logo, url, id)

            db.close()
            dialog.dismiss()
            restart()
        }

        btDelete.setOnClickListener {
            db.close()
            dialog.dismiss()
            dialogDeleteRec(pos)
        }

        dialog.show()
    }

    private fun restart() {
        val intent = intent
        finish()
        startActivity(intent)
    }

    private fun saveDb14() {
        val export = DatabaseHelper(this@CustomActivity, null).exportDb14(this@CustomActivity)

        if (export) {
            Toast.makeText(this, getString(R.string.saveOkay), Toast.LENGTH_SHORT).show()
            restart()
        } else {
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
            restart()
        }
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
        if (isStoragePermissionGranted()) {
            val export = DatabaseHelper(this@CustomActivity, null).exportDb(this@CustomActivity)

            if (export) {
                restart()
            } else {
                Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
                restart()
            }
        }
    }
}