package com.example.kotlinm1.entity

import androidx.room.*

@Entity(tableName = "notes")
class MemoDTO ( @PrimaryKey(autoGenerate = true) var noteId: Long = 0L, var title: String = "" ) {

    constructor(title: String) : this() {

        this.title = title

    }
}