package com.example.kotlinm1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlinm1.entity.MemoDTO
import com.example.kotlinm1.repository.MainRepository

class MainViewModel : ViewModel() {

    private lateinit var mainRepository: MainRepository

    fun init(mainRepository: MainRepository) {

        this.mainRepository = mainRepository

    }

    fun getLiveDataMemo(): List<MemoDTO>? {

        return mainRepository.getLiveDataMemo()

    }

    fun insertNote(memo: MemoDTO) {

        mainRepository.insertNote(memo)

    }
}