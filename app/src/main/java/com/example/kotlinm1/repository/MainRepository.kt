package com.example.kotlinm1.repository

import com.example.kotlinm1.di.DIApplication
import com.example.kotlinm1.entity.MemoDAO
import com.example.kotlinm1.entity.MemoDTO

import javax.inject.Inject

class MainRepository {

    @Inject lateinit var memoDAO: MemoDAO

    fun getLiveDataMemo(): List<MemoDTO> {

        return memoDAO.getAllNotes()

    }

    fun insertNote(memo: MemoDTO) {

        memoDAO.insert(memo)

    }

    init {

        DIApplication.getAppComponent()?.inject(this)

    }
}