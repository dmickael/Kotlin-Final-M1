package com.example.kotlinm1.entity

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MemoDTO::class], version = 1)
abstract class MemoData : RoomDatabase() {

    abstract fun noteDAO(): MemoDAO

}