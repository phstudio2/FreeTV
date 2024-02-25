package com.phstudio.freetv.favorite

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Environment
import android.os.Environment.getExternalStoragePublicDirectory
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import com.phstudio.freetv.R
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter


class Database(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onOpen(db: SQLiteDatabase?) {
        onCreate(db!!)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "PH studio"
        private const val DATABASE_VERSION = 3
        const val TABLE_NAME = "Favorite"
        const val ID_COL = "id"
        const val COL1 = "name"
        const val COL2 = "logo"
        const val COL3 = "url"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE if not exists " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                COL1 + " TEXT," +
                COL2 + " TEXT," +
                COL3 + " TEXT" + ")")
        db.execSQL(query)
    }

    @SuppressLint("Recycle", "Range", "DiscouragedApi")
    fun getData(context: Context): ArrayList<HashMap<String, Any>> {
        val db = this.writableDatabase
        val userList: ArrayList<HashMap<String, Any>> = ArrayList()
        val cursor = db.rawQuery("SELECT name, logo, url FROM $TABLE_NAME", null)

        while (cursor.moveToNext()) {
            val user: HashMap<String, Any> = HashMap()
            user["name"] = cursor.getString(cursor.getColumnIndex(COL1))
            user["logo"] = cursor.getString(cursor.getColumnIndex(COL2))
            user["url"] = cursor.getString(cursor.getColumnIndex(COL3))
            userList.add(user)
        }
        cursor.close()
        db.close()
        return userList
    }

    fun writeToDb(
        name: String,
        logo: String,
        url: String,
    ) {
        val values = ContentValues()
        values.put(COL1, name)
        values.put(COL2, logo)
        values.put(COL3, url)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readFromDb(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun getSum(): Int {
        val countQuery = "SELECT  * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(countQuery, null)
        val count = cursor.count
        cursor.close()
        db.close()
        return count
    }

    fun deleteRec(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID = ?", arrayOf(id))
    }

    fun deleteAllRec() {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }

    @SuppressLint("Range")
    fun exportDb14(context: Context): Boolean {
        val exportDir =
            getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (!exportDir.exists()) {
            exportDir.mkdirs()
        }
        val file: File
        var printWriter: PrintWriter? = null
        try {
            file = File(exportDir, "Database_FREETV.csv")
            file.createNewFile()
            printWriter = PrintWriter(FileWriter(file))

            val db = this.readableDatabase
            var id: Int
            var name: String
            var logo: String
            var url: String

            val curCSV: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
            printWriter.println("id,name,logo,url")
            while (curCSV.moveToNext()) {
                id = curCSV.getInt(curCSV.getColumnIndex(ID_COL))
                name = curCSV.getString(curCSV.getColumnIndex("name"))
                logo = curCSV.getString(curCSV.getColumnIndex("logo"))
                url = curCSV.getString(curCSV.getColumnIndex("url"))

                val record = "$id,$name,$logo,$url"

                printWriter.println(record)
            }
            curCSV.close()
            db.close()
        } catch (e: IOException) {
            return false
        } finally {
            printWriter?.close()
        }
        return true
    }

    @SuppressLint("Range")
    fun exportDb(context: Context): Boolean {
        val state = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED != state) {
            return false
        } else {
            val fileDir = context.getExternalFilesDir(null)

            val file: File
            var printWriter: PrintWriter? = null
            try {
                file = File(fileDir, "Database_FREETV.csv")
                file.createNewFile()
                printWriter = PrintWriter(FileWriter(file))

                val db = this.readableDatabase
                var id: Int
                var name: String
                var logo: String
                var url: String

                val curCSV: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
                printWriter.println("id,name,logo,url")
                while (curCSV.moveToNext()) {
                    id = curCSV.getInt(curCSV.getColumnIndex(ID_COL))
                    name = curCSV.getString(curCSV.getColumnIndex("name"))
                    logo = curCSV.getString(curCSV.getColumnIndex("logo"))
                    url = curCSV.getString(curCSV.getColumnIndex("url"))

                    val record = "$id,$name,$logo,$url"

                    printWriter.println(record)
                }
                curCSV.close()
                db.close()
                Toast.makeText(context, context.getString(R.string.saveFolder), Toast.LENGTH_SHORT).show()
                Toast.makeText(context, file.absolutePath, Toast.LENGTH_LONG).show()

            } catch (e: IOException) {
                return false
            } finally {
                printWriter?.close()
            }
            return true
        }
    }
}
