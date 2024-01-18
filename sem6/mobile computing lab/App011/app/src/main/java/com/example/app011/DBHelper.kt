package com.example.app011

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + "students" + " ("
                + "roll" + " TEXT PRIMARY KEY NOT NULL, " +
                "name" + " TEXT," +
                "mark" + " TEXT" + ")")

        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS students")
        onCreate(db)
    }

    fun addDetail(roll: String, name : String, mark: String){
        val values = ContentValues()
        values.put("roll",roll)
        values.put("name", name)
        values.put("mark", mark)
        val db = this.writableDatabase
        db.insert("students", null, values)
        db.close()
    }

    fun getDetail(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM students", null)
    }

    fun fetchDetail(roll: String): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM students WHERE roll = $roll", null)
    }

    fun updateDetail(roll: String, name : String, mark: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("roll",roll)
        values.put("name", name)
        values.put("mark", mark)
        db.update("students",values,"roll=?", arrayOf(roll))
    }

    fun deleteDetail(roll: String) {
        val db = this.writableDatabase
        db.delete("students","roll=?", arrayOf(roll))
    }

    companion object{
        private const val DATABASE_NAME = "root"
        private const val DATABASE_VERSION = 1
        const val ROLL_COL = "roll"
        const val NAME_COl = "name"
        const val MARK_COL = "mark"
    }
}
