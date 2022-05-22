package com.android.projectnishacap

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var user_n:EditText
    private lateinit var pass_word:EditText
    private lateinit var login:Button
    private lateinit var forget:TextView
    private lateinit var tv_sign:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_login)
        user_n =findViewById(R.id.logineMail)
        pass_word=findViewById(R.id.password)
        login=findViewById(R.id.bt_LogIn)
        forget=findViewById(R.id.forgot)
        tv_sign=findViewById(R.id.tv_singUp)


        forget.setOnClickListener(View.OnClickListener {

            val intent:Intent= Intent(this,ForgetActivity::class.java)

            startActivity(intent)

        })


        tv_sign.setOnClickListener(View.OnClickListener {

            val intent:Intent= Intent(this,EnrollActivity ::class.java)

            startActivity(intent)

        })


        login.setOnClickListener {
            val enteredText =user_n.text.toString()
            val enteredText1 =pass_word.text.toString()
            if (enteredText.isEmpty()) {
                user_n.setError("Email is required")
                user_n.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(enteredText).matches()) {
                user_n.setError("Please enter a valid email")
                user_n.requestFocus()
                return@setOnClickListener
            }
            if (enteredText1.isEmpty()) {
                pass_word.setError("Password is required")
                pass_word.requestFocus()
                return@setOnClickListener
            }

            if (enteredText1.length < 6 || enteredText1.length > 15) {
                pass_word.setError("Password should be of 6-15 characters")
                pass_word.requestFocus()
                return@setOnClickListener
            }
            val upperCaseChars = Regex("(.*[A-Z].*)")
            if (!enteredText1.matches(upperCaseChars)) {
                //editTextPassword.setError("Password should contain atleast one upper case alphabet");
                pass_word.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                pass_word.requestFocus()
                return@setOnClickListener
            }

            val lowerCaseChars = Regex("(.*[a-z].*)")
            if (!enteredText1.matches(lowerCaseChars)) {
                pass_word.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                pass_word.requestFocus()
                return@setOnClickListener
            }

            val numbers = Regex("(.*[0-9].*)")
            if (!enteredText1.matches(numbers)) {
                pass_word.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                pass_word.requestFocus()
                return@setOnClickListener
            }

            val specialChars = Regex("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
            if (!enteredText1.matches(specialChars)) {
                pass_word.setError("Password should contain at least one number, one lowercase letter, one uppercase letter, and one special character.")
                pass_word.requestFocus()
                return@setOnClickListener
            }
        }
    }
}