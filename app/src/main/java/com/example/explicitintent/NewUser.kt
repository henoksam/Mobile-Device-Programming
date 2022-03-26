package com.example.explicitintent

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_user.*

class NewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)


        button.setOnClickListener {
            var fName = fName?.text.toString()
            var lName = lName?.text.toString()
            var newEmail = newEmail?.text.toString()
            var newPass = newPass?.text.toString()

            if (fName != "" && lName != "" && newEmail != "" && newPass != "")
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_LONG).show()
            val rintent = intent

            val user1 = fName + "&" + lName + "&" + newEmail + "&" + newPass
            rintent.data = Uri.parse(user1)
            setResult(Activity.RESULT_OK, rintent)
            finish()
        }

    }
}