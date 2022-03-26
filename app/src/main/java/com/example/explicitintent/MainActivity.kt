package com.example.explicitintent

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user1 = User("Henok", "Taddese", "hensam@gmail.com", "1234")
        val user2 = User("Kevin", "Debruyne", "kbru@gmail.com", "3456")
        val user3 = User("Thomas", "Louise", "tlouise@gmail.com", "4567")
        val user4 = User("John", "Wick", "jwick@gmail.com", "5678")
        val user5 = User("Mark", "Alonso", "malonso@gmail.com", "6789")

        var arr = arrayOf(user1, user2, user3, user4, user5)


        var resultContracts =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if(result.resultCode == Activity.RESULT_OK) {
                    var res = result.data?.data.toString()
                    var delimiter = "&"

                    val parts = res.split(delimiter)


                    val newUsr = User(parts[0], parts[1], parts[2], parts[3])
                    arr.plus(newUsr)

                    println(arr)
                }
                else
                    Toast.makeText(this, "Failed to get results", Toast.LENGTH_LONG).show()

            }






        btn.setOnClickListener {

            var e = email.text
            var p = password.text

            var k = false


            for (i in arr.indices) {
                if (arr[i].userName == e.toString() && arr[i].password == p.toString())
                    k = !k
            }

            val intent = Intent(this, SecondActivity::class.java)

            if (k)
                startActivity(intent)
        }

        btn2.setOnClickListener {

            val intent = Intent(this, NewUser::class.java)
            //startActivity(intent)
            resultContracts.launch(intent)

        }

        forgot.setOnClickListener{
            var email = email.text.toString()
            for (item in arr) {
                if(item.userName == email)
                    Toast.makeText(this, "Account Found. Password is " + item.password , Toast.LENGTH_LONG).show()
            }

        }

    }

}
