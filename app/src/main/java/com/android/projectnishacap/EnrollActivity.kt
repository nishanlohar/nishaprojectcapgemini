package com.android.projectnishacap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EnrollActivity :AppCompatActivity(){
    private lateinit var p_btn:Button
    private lateinit var d_btn:Button
    private lateinit var n_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll)
        p_btn = findViewById(R.id.Pbtn)
        d_btn = findViewById(R.id.Dbtn)
        n_btn = findViewById(R.id.Nbtn)


        p_btn.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this, PatientSignup::class.java)

            startActivity(intent)
        })


        d_btn.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this,DoctorSignup::class.java)

            startActivity(intent)
        })


        n_btn.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this,NurseSignup::class.java)

            startActivity(intent)
        })
    }
}