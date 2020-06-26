package com.example.kotlinm1.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemCallback(adapter: MemoAdapter) : ItemTouchHelper.Callback() {

    private val myAdapter: MemoAdapter = adapter

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {

        val dragFlagsRight = RIGHT

        return makeMovementFlags(

            dragFlagsRight,
            dragFlagsRight

        )

    }

    override fun onMove(

        recyclerView: RecyclerView,
        viewHolder: ViewHolder,
        target: ViewHolder

    ): Boolean {

        return false

    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {

        myAdapter.onItemDismiss(viewHolder)
        myAdapter.notifyDataSetChanged()

    }
}