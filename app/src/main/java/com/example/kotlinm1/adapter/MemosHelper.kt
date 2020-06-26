package com.example.kotlinm1.adapter

import android.content.Context
import androidx.room.Room
import com.example.kotlinm1.entity.MemoData

class MemosHelper(context: Context?) {

    companion object {

        private var dbHelper: MemosHelper? = null
        private lateinit var db: MemoData

        @Synchronized
        fun getDatabase(c: Context): MemoData {

            if (dbHelper == null)

                dbHelper = MemosHelper(c.applicationContext)

            return db
        }
    }

    init {
        db = context?.let {
            Room
                .databaseBuilder(it, MemoData::class.java, "memos.db")
                .allowMainThreadQueries()
                .build()
        }!!
    }
}