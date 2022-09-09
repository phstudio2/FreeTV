package com.phstudio.freetv.favorite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
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
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Favorite"
        const val ID_COL = "id"
        const val COL1 = "source"
        const val COL2 = "number"
        const val COL3 = "playlist"
        const val COL4 = "picture"
        const val COL5 = "string"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE if not exists " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                COL1 + " TEXT," +
                COL2 + " TEXT," +
                COL3 + " TEXT," +
                COL4 + " TEXT," +
                COL5 + " TEXT" + ")")
        db.execSQL(query)
    }

    @SuppressLint("Recycle", "Range", "DiscouragedApi")
    fun getData(context: Context): ArrayList<HashMap<String, Any>> {
        val db = this.writableDatabase
        val userList: ArrayList<HashMap<String, Any>> = ArrayList()
        val cursor = db.rawQuery("SELECT picture, string FROM $TABLE_NAME", null)

        while (cursor.moveToNext()) {
            val user: HashMap<String, Any> = HashMap()
            val picture = (cursor.getString(cursor.getColumnIndex(COL4)))
            user["picture"] =
                context.resources.getIdentifier(picture, "drawable", context.packageName)
            val text = cursor.getString(cursor.getColumnIndex(COL5))
            user["string"] = context.getString(
                context.resources.getIdentifier(
                    text,
                    "string",
                    context.packageName
                )
            )
            userList.add(user)
        }
        cursor.close()
        db.close()
        return userList
    }

    fun writeToDb(
        source: String,
        number: String,
        playlist: String,
        picture: String,
        string: String
    ) {
        val values = ContentValues()
        values.put(COL1, source)
        values.put(COL2, number)
        values.put(COL3, playlist)
        values.put(COL4, picture)
        values.put(COL5, string)

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
    fun exportDb(): Boolean {
        val state = Environment.getExternalStorageState()
        if (Environment.MEDIA_MOUNTED != state) {
            return false
        } else {
            val exportDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
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
                var source: String
                var number: String
                var playlist: String
                var picture: String
                var string: String

                val curCSV: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
                printWriter.println("id,source,number,playlist,picture,string")
                while (curCSV.moveToNext()) {
                    id = curCSV.getInt(curCSV.getColumnIndex(ID_COL))
                    source = curCSV.getString(curCSV.getColumnIndex("source"))
                    number = curCSV.getString(curCSV.getColumnIndex("number"))
                    playlist = curCSV.getString(curCSV.getColumnIndex("playlist"))
                    picture = curCSV.getString(curCSV.getColumnIndex("picture"))
                    string = curCSV.getString(curCSV.getColumnIndex("string"))

                    val record = "$id,$source,$number,$playlist,$picture,$string"
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
    }
}
