package com.example.kotlinm1.entity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
abstract class MemoDAO {
    @Query("SELECT * FROM notes")
    abstract fun getAllNotes(): MutableList<MemoDTO>

    @Query("SELECT COUNT(*) FROM notes WHERE title = :title")
    abstract fun countmemo(title: String?): Long

    @Insert
    abstract fun insert(vararg memos: MemoDTO?)

    @Update
    abstract fun update(vararg memos: MemoDTO?)

    @Delete
    abstract fun delete(vararg memos: MemoDTO?)
}