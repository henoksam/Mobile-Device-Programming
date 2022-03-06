package com.example.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
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

        btn2.setOnClickListener{

            val intent = Intent(this, NewUser::class.java)
            startActivity(intent)

        }

    }
//    fun onSendMessage(view:View){
//        var tst = Toast.makeText(applicationContext,"Top Toast", Toast.LENGTH_LONG);
//        // Can display the Toast in the Top, Default location is in the Bottom.
//       // tst.setGravity(Gravity.TOP, 0, 0)
//        tst.show()
//        val intent = Intent(this, SecondActivity::class.java)
//        intent.putExtra("message",input) // Here message is a key to retrieve the input text in the second activity
//        startActivity(intent)
//    }
}
