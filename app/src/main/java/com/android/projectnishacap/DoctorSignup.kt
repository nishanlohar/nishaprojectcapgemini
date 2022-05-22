package com.android.projectnishacap
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.ViewParent
import android.widget.*


class DoctorSignup:AppCompatActivity() {


    private lateinit var id: EditText
    private lateinit var name: EditText
    private lateinit var emailid: EditText
    private lateinit var doc_specialist: AutoCompleteTextView
    private lateinit var phone_num: EditText
    private lateinit var doc_experience: EditText
    private lateinit var passcode: EditText
    private lateinit var confirm_passcode: EditText
    private lateinit var tv_doc_login: TextView
    private lateinit var tv_doc_signup: TextView
    private lateinit var bt_signup: Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_signup)


        val specialist = resources.getStringArray(R.array.specialist_doctor)
        val autoCompleteTextView=findViewById<AutoCompleteTextView>(R.id.dropdown_field)
        val adapter=ArrayAdapter(applicationContext,R.layout.list_item,R.id.text_view,specialist)
        autoCompleteTextView.setAdapter(adapter)

        id=findViewById(R.id.full_id)
        name=findViewById(R.id.full_username)
        emailid=findViewById(R.id.d_eMail)
        doc_specialist=findViewById(R.id.dropdown_field)
        phone_num=findViewById(R.id.d_contact)
        doc_experience=findViewById(R.id.d_experience)
        passcode=findViewById(R.id.d_passwords)
        confirm_passcode=findViewById(R.id.d_confirmpasswords)
        tv_doc_login=findViewById(R.id.doc_logIn)
        tv_doc_signup=findViewById(R.id.d_singUp)
        bt_signup=findViewById(R.id.dbt_singup)


        tv_doc_login.setOnClickListener(View.OnClickListener {

            val intent:Intent= Intent(this,LoginActivity::class.java)

            startActivity(intent)
        })


        bt_signup.setOnClickListener {
            val enteredText =emailid.text.toString()
            val enteredText1 =passcode.text.toString()
            val enteredText2=confirm_passcode.text.toString()

            val enteredId = id.text.toString()
            val enteredname=name.text.toString()
            val enteredspecialist = doc_specialist.text.toString()
            val enteredphone = phone_num.text.toString()
            val enteredexperince =  doc_experience.text.toString()


            if (enteredId.isEmpty()) {
                id.setError("Doctor ID is required")
                id.requestFocus()
                return@setOnClickListener
            }
            if (enteredname.isEmpty()) {
                name.setError("Doctor Name  is required")
                name.requestFocus()
                return@setOnClickListener
            }
            if (enteredspecialist.isEmpty()) {
                doc_specialist.setError("Enter specialist ")
                doc_specialist.requestFocus()
                return@setOnClickListener
            }
            if (enteredphone.isEmpty()) {
                phone_num.setError("Doctor Phone number is required")
                phone_num.requestFocus()
                return@setOnClickListener
            }
            if (enteredexperince.isEmpty()) {
                doc_experience.setError("Please enter your experience")
                doc_experience.requestFocus()
                return@setOnClickListener
            }
            if (enteredText.isEmpty()) {
                emailid.setError("Email is required")
                emailid.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(enteredText).matches()) {
                emailid.setError("Please enter a valid email")
                emailid.requestFocus()
                return@setOnClickListener
            }
            if (enteredText1.isEmpty()) {
                passcode.setError("Password is required")
                passcode.requestFocus()
                confirm_passcode.setError("Password is required")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }

            if (enteredText1.length < 6 || enteredText1.length > 15) {
                passcode.setError("Password should be of 6-15 characters")
                passcode.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars = Regex("(.*[A-Z].*)")
            if (!enteredText1.matches(upperCaseChars)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                passcode.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars = Regex("(.*[a-z].*)")
            if (!enteredText1.matches(lowerCaseChars)) {
                passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                passcode.requestFocus()
                return@setOnClickListener
            }

            val numbers = Regex("(.*[0-9].*)")
            if (!enteredText1.matches(numbers)) {
                passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                passcode.requestFocus()
                return@setOnClickListener
            }

            val specialChars = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!enteredText1.matches(specialChars)) {
                passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                passcode.requestFocus()
                return@setOnClickListener
            }



            //confirm password condition code
            if (enteredText2.isEmpty()) {
                confirm_passcode.setError("Password is required")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }

            if (enteredText2.length < 6 || enteredText2.length > 15) {
                confirm_passcode.setError("Password should be of 6-15 characters")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars2= Regex("(.*[A-Z].*)")
            if (!enteredText2.matches(upperCaseChars2)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                confirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars2 = Regex("(.*[a-z].*)")
            if (!enteredText2.matches(lowerCaseChars2)) {
                confirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val numbers2 = Regex("(.*[0-9].*)")
            if (!enteredText2.matches(numbers2)) {
                confirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }

            val specialChars2 = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!enteredText2.matches(specialChars2)) {
                confirm_passcode.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                confirm_passcode.requestFocus()
                return@setOnClickListener
            }
        }

    }
}



