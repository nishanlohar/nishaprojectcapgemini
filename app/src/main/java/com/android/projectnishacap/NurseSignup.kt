package com.android.projectnishacap

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class NurseSignup:AppCompatActivity (){

    private lateinit var nurseid:EditText
    private lateinit var nursename:EditText
    private lateinit var nurseemailid:EditText
    private lateinit var nurseeducation:AutoCompleteTextView
    private lateinit var nursephone_num:EditText
    private lateinit var nurseexperience:EditText
    private lateinit var nursepasscode:EditText
    private lateinit var nurseconfirm_passcode:EditText
    private lateinit var nursetv_login:TextView
    private lateinit var nursetv_signup:TextView
    private lateinit var nursebt_signup:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nurse_signup)


        val education = resources.getStringArray(R.array.education_nurse)
        val autoCompleteTextView=findViewById<AutoCompleteTextView>(R.id.nEducation)
        val adapter= ArrayAdapter(applicationContext,R.layout.list_item,R.id.text_view,education)
        autoCompleteTextView.setAdapter(adapter)

        nurseid=findViewById(R.id.nId)
        nursename=findViewById(R.id.nName)
        nurseemailid=findViewById(R.id.nEmail)
        nurseeducation=findViewById(R.id.nEducation)
        nursephone_num=findViewById(R.id.nContact)
        nurseexperience=findViewById(R.id.nExperience )
        nursepasscode=findViewById(R.id.nPasswords)
        nurseconfirm_passcode=findViewById(R.id.nConfirmpasswords)
        nursetv_login=findViewById(R.id.nLogIn)
        nursetv_signup=findViewById(R.id.nSingUp )
        nursebt_signup=findViewById(R.id.nBtnSingup)

        nursetv_login.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(this,LoginActivity::class.java)

            startActivity(intent)
        })

        nursebt_signup.setOnClickListener {
            val nurseenteredemail =nurseemailid.text.toString()
            val nurseenteredpasscode =nursepasscode.text.toString()
            val nurseenteredcp=nurseconfirm_passcode.text.toString()

            val nurseenteredId = nurseid.text.toString()
            val nurseenteredname=nursename.text.toString()
            val nurseenterededucation = nurseeducation.text.toString()
            val nurseenteredphone = nursephone_num.text.toString()
            val nurseenteredexperince = nurseexperience.text.toString()


            if (nurseenteredId.isEmpty()) {
                nurseid.setError("Nurse ID is required")
                nurseid.requestFocus()
                return@setOnClickListener
            }
            if (nurseenteredname.isEmpty()) {
                nursename.setError("Nurse Name  is required")
                nursename.requestFocus()
                return@setOnClickListener
            }
            if (nurseenterededucation.isEmpty()) {
                nurseeducation.setError("Enter Nurse's Education ")
                nurseeducation.requestFocus()
                return@setOnClickListener
            }
            if (nurseenteredphone.isEmpty()) {
                nursephone_num.setError("Nurse's Phone number is required")
                nursephone_num.requestFocus()
                return@setOnClickListener
            }
            if (nurseenteredexperince.isEmpty()) {
                nurseexperience.setError("Please enter your experience")
                nurseexperience.requestFocus()
                return@setOnClickListener
            }
            if (nurseenteredemail.isEmpty()) {
                nurseemailid.setError("Email is required")
                nurseemailid.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(nurseenteredemail).matches()) {
                nurseemailid.setError("Please enter a valid email")
                nurseemailid.requestFocus()
                return@setOnClickListener
            }
            if (nurseenteredpasscode.isEmpty()) {
                nursepasscode.setError("Password is required")
                nursepasscode.requestFocus()
                return@setOnClickListener
            }

            if (nurseenteredpasscode.length < 6 || nurseenteredpasscode.length > 15) {
                nursepasscode.setError("Password should be of 6-15 characters")
                nursepasscode.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars = Regex("(.*[A-Z].*)")
            if (!nurseenteredpasscode.matches(upperCaseChars)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                nursepasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nursepasscode.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars = Regex("(.*[a-z].*)")
            if (!nurseenteredpasscode.matches(lowerCaseChars)) {
                nursepasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nursepasscode.requestFocus()
                return@setOnClickListener
            }

            val numbers = Regex("(.*[0-9].*)")
            if (!nurseenteredpasscode.matches(numbers)) {
                nursepasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nursepasscode.requestFocus()
                return@setOnClickListener
            }

            val specialChars = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!nurseenteredpasscode.matches(specialChars)) {
                nursepasscode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nursepasscode.requestFocus()
                return@setOnClickListener
            }



            //confirm password condition code
            if (nurseenteredcp.isEmpty()) {
                nurseconfirm_passcode.setError("Password is required")
                nurseconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            if (nurseenteredcp.length < 6 || nurseenteredcp.length > 15) {
                nurseconfirm_passcode.setError("Password should be of 6-15 characters")
                nurseconfirm_passcode.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars2= Regex("(.*[A-Z].*)")
            if (!nurseenteredcp.matches(upperCaseChars2)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                nurseconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nurseconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars2 = Regex("(.*[a-z].*)")
            if (!nurseenteredcp.matches(lowerCaseChars2)) {
                nurseconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nurseconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val numbers2 = Regex("(.*[0-9].*)")
            if (!nurseenteredcp.matches(numbers2)) {
                nurseconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nurseconfirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val specialChars2 = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!nurseenteredcp.matches(specialChars2)) {
                nurseconfirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                nurseconfirm_passcode.requestFocus()
                return@setOnClickListener
            }
        }
    }
}