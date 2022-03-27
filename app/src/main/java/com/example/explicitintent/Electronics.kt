package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_electronics.*

class Electronics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics)


        val products = ArrayList<Product>()
        products.add(Product("iPhone",499.99, "Black", "14323", "A brand new phone for the year 2022"))
        products.add(Product("Mac Book",999.99, "Silver", "14875", "A brand new Computer for the year 2022 with all the latest upgrades for the processors"))
        products.add(Product("Monitor",249.99, "white", "14323", "A brand new phone for the year 2022"))
        products.add(Product("Keyboard",154.99, "silver", "87455", "A brand new phone for the year 2022"))
        products.add(Product("Projector",844.99, "white", "33874", "A brand new phone for the year 2022"))
        products.add(Product("Tablet",424.99, "Black", "457458", "A brand new phone for the year 2022"))




        recyclerView1.layoutManager = LinearLayoutManager(this)
        // Create an object for the MyAdapter
        val adapter = MyAdapter(this, products)
        // Set adapter to your RecyclerView
        recyclerView1.adapter = adapter
    }
}