package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // To avoid application crash check intent has data or not
        if(intent.hasExtra("title")&& intent.hasExtra("color")){
            var t1 = intent.getStringExtra("title")
            var t2 = intent.getStringExtra("desc")
            var t3 = intent.getStringExtra("color")
            var t4 = intent.getStringExtra("price")
            item_name.text = t1.toString()
            item_description.text = t2.toString()
            item_color.text = t3.toString()
            item_price.text = t4.toString()
        }
    }
}