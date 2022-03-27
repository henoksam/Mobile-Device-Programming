package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        food.setOnClickListener {
            Toast.makeText(this, "You have selected Food Category", Toast.LENGTH_LONG).show()
        }

        clothing.setOnClickListener {
            Toast.makeText(this, "You have selected Clothing Category", Toast.LENGTH_LONG).show()
        }

        electronics.setOnClickListener {
            Toast.makeText(this, "You have selected Electronics Category", Toast.LENGTH_LONG).show()
            val intent = Intent(this, Electronics::class.java)

            startActivity(intent)
        }

        beauty.setOnClickListener {
            Toast.makeText(this, "You have selected Beauty Category", Toast.LENGTH_LONG).show()
        }


    }
}
