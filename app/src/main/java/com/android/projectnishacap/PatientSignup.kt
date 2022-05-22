package com.android.projectnishacap

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PatientSignup:AppCompatActivity() {
    private lateinit var patientname: EditText
    private lateinit var patientemailid: EditText
    private lateinit var patientage: EditText
    private lateinit var patientphone_num: EditText
    private lateinit var patientdisease: EditText
    private lateinit var patientpasscode: EditText
    private lateinit var patientconfirm_passcode: EditText
    private lateinit var patienttv_login: TextView
    private lateinit var patienttv_signup: TextView
    private lateinit var patientbt_signup: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_signup)

        patientname=findViewById(R.id.ptName)
        patientemailid=findViewById(R.id.ptEmail)
        patientage=findViewById(R.id.ptAge)
        patientphone_num=findViewById(R.id.ptContact)
        patientdisease=findViewById(R.id.ptDisease )
        patientpasscode=findViewById(R.id.ptPasswords)
        patientconfirm_passcode=findViewById(R.id.ptConfirmpassword )
        patienttv_login=findViewById(R.id.ptLogIn)
        patienttv_signup=findViewById(R.id.ptSingUp )
        patientbt_signup=findViewById(R.id.pBtnSingup)

        patienttv_login.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this,LoginActivity::class.java)

            startActivity(intent)
        })


        patientbt_signup.setOnClickListener {
            val penteredemail =patientemailid.text.toString()
            val penteredpasscode =patientpasscode.text.toString()
            val penteredcp=patientconfirm_passcode.text.toString()

            val penteredAge = patientage.text.toString()
            val penteredname=patientname.text.toString()
            val penteredphone = patientphone_num.text.toString()
            val pentereddisease = patientdisease.text.toString()



            if (penteredname.isEmpty()) {
                patientname.setError("patient Name  is required")
                patientname.requestFocus()
                return@setOnClickListener
            }
            if (penteredAge.isEmpty()) {
                patientage.setError("Enter patient's age ")
                patientage.requestFocus()
                return@setOnClickListener
            }
            if (penteredphone.isEmpty()) {
                patientphone_num.setError("patient Phone number is required")
                patientphone_num.requestFocus()
                return@setOnClickListener
            }
            if (pentereddisease.isEmpty()) {
                patientdisease.setError("Please write about disease")
                patientdisease.requestFocus()
                return@setOnClickListener
            }
            if (penteredemail.isEmpty()) {
                patientemailid.setError("Email is required")
                patientemailid.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(penteredemail).matches()) {
                patientemailid.setError("Please enter a valid email")
                patientemailid.requestFocus()
                return@setOnClickListener
            }
            if (penteredpasscode.isEmpty()) {
                patientpasscode.setError("Password is required")
                patientpasscode.requestFocus()
                return@setOnClickListener
            }

            if (penteredpasscode.length < 6 || penteredpasscode.length > 15) {
                patientpasscode.setError("Password should be of 6-15 characters")
                patientpasscode.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars = Regex("(.*[A-Z].*)")
            if (!penteredpasscode.matches(upperCaseChars)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                patientpasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientpasscode.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars = Regex("(.*[a-z].*)")
            if (!penteredpasscode.matches(lowerCaseChars)) {
                patientpasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientpasscode.requestFocus()
                return@setOnClickListener
            }

            val numbers = Regex("(.*[0-9].*)")
            if (!penteredpasscode.matches(numbers)) {
                patientpasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientpasscode.requestFocus()
                return@setOnClickListener
            }

            val specialChars = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!penteredpasscode.matches(specialChars)) {
                patientpasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientpasscode.requestFocus()
                return@setOnClickListener
            }



            //confirm password condition code
            if (penteredcp.isEmpty()) {
                patientconfirm_passcode.setError("Password is required")
                patientconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            if (penteredcp.length < 6 || penteredcp.length > 15) {
                patientconfirm_passcode.setError("Password should be of 6-15 characters")
                patientconfirm_passcode.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars2= Regex("(.*[A-Z].*)")
            if (!penteredcp.matches(upperCaseChars2)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                patientconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars2 = Regex("(.*[a-z].*)")
            if (!penteredcp.matches(lowerCaseChars2)) {
                patientconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val numbers2 = Regex("(.*[0-9].*)")
            if (!penteredcp.matches(numbers2)) {
                patientconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val specialChars2 = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!penteredcp.matches(specialChars2)) {
                patientconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                patientconfirm_passcode.requestFocus()
                return@setOnClickListener
            }
        }


    }

}