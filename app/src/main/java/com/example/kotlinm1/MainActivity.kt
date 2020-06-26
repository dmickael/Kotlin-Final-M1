package com.example.kotlinm1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinm1.adapter.ItemCallback
import com.example.kotlinm1.adapter.MemoAdapter
import com.example.kotlinm1.entity.MemoDTO
import com.example.kotlinm1.repository.MainRepository
import com.example.kotlinm1.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var memoAdapter: MemoAdapter
    private var listMemos: MutableList<MemoDTO>? = ArrayList()
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.init(MainRepository())
        listMemos = mainViewModel.getLiveDataMemo()?.toMutableList()

        memoAdapter = MemoAdapter(listMemos!!, this)

        myrecyclerview.setHasFixedSize(true)
        myrecyclerview.layoutManager = LinearLayoutManager(this)
        itemTouchHelper = ItemTouchHelper(ItemCallback(memoAdapter))
        itemTouchHelper.attachToRecyclerView(myrecyclerview)
        myrecyclerview.adapter = memoAdapter

    }

    fun addMemo(v: View) {

        if (insertnote.text.toString().isNotEmpty()) {

            val n = MemoDTO(insertnote!!.text.toString())
            listMemos?.add(n)
            mainViewModel.insertNote(n)
            myrecyclerview.adapter?.notifyDataSetChanged()

        }

        insertnote.text.clear()

    }
}