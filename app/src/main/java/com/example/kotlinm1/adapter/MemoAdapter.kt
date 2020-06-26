package com.example.kotlinm1.adapter

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinm1.R
import com.example.kotlinm1.DetailActivity
import com.example.kotlinm1.entity.MemoDTO
import com.example.kotlinm1.ui.DetailFragment
import kotlinx.android.synthetic.main.item_note.view.*

class MemoAdapter(listeMemos: MutableList<MemoDTO>, main: AppCompatActivity) : RecyclerView.Adapter<MemoAdapter.NoteViewHolder?>() {

    private var listeMemos: MutableList<MemoDTO> = ArrayList()
    private val main: AppCompatActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewNote: View = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(viewNote)

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.bind(listeMemos[position])

    }

    override fun getItemCount(): Int {

        return listeMemos.size

    }

    fun onItemDismiss(view: RecyclerView.ViewHolder) {
        if (view.adapterPosition > -1) {

            MemosHelper.getDatabase(view.itemView.context).noteDAO().delete(listeMemos[view.adapterPosition])
            listeMemos.removeAt(view.adapterPosition)
            notifyItemRemoved(view.adapterPosition)

        }
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { view ->

                val memo: MemoDTO = listeMemos[adapterPosition]
                val preferences: SharedPreferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(view.context)
                val editor = preferences.edit()
                editor.putInt("last", adapterPosition)
                editor.apply()

                if (main.findViewById<View?>(R.id.large_detail) == null) {

                    val intent = Intent(view.context, DetailActivity::class.java)
                    intent.putExtra("detail", memo.title)
                    view.context.startActivity(intent)

                } else {

                    val fragment = DetailFragment()
                    val bundle = Bundle()
                    bundle.putString(DetailFragment.EXTRA_PARAM, memo.title)
                    fragment.arguments = bundle
                    val fragmentManager = main.supportFragmentManager
                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.large_detail, fragment, "exemple2")
                    fragmentTransaction.commit()

                }

            }
        }

        fun bind(memo:MemoDTO) = with(itemView){

            titlenote.text = memo.title

        }
    }

    init {

        this.listeMemos = listeMemos
        this.main = main

    }
}