package com.example.kotlinm1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinm1.R
import com.example.kotlinm1.ui.DetailFragment
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val titleMemo = intent.getStringExtra("detail")
        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString(DetailFragment.EXTRA_PARAM, titleMemo)
        fragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.large_detail, fragment, "exemple2")
        fragmentTransaction.commit()

    }

}