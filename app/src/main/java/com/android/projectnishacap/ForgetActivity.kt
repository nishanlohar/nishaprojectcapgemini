package com.android.projectnishacap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgetActivity :AppCompatActivity(){
    private lateinit var editText: EditText
    private lateinit var resbtn:Button
    private lateinit var backbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        editText=findViewById(R.id.eMail)
        resbtn=findViewById(R.id.resetBtn)
        backbtn=findViewById(R.id.BackButton)


        resbtn.setOnClickListener {
            val emailText =editText.text.toString()
            if (emailText.isEmpty())
            {
                Toast.makeText(this, "please enter valid email", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Password reset link sent to your email. Please check your email inbox.", Toast.LENGTH_LONG).show()
            }
        }


        backbtn.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this,LoginActivity::class.java)

            startActivity(intent)
        })


    }
}