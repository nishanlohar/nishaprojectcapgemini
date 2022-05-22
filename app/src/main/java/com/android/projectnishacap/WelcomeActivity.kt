package com.android.projectnishacap

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity:AppCompatActivity() {
    val SPLASH_SCREEN=2000

    private lateinit var imageView: ImageView
    private lateinit var title_txt1:TextView
    private lateinit var title_txt2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.screen_welcome)
        imageView=findViewById(R.id.splash_img)
        title_txt1=findViewById(R.id.splash_txt1)
        title_txt2=findViewById(R.id.splash_txt2)
        Handler().postDelayed({
            val LoginIntent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(LoginIntent)
            finish()
        },SPLASH_SCREEN.toLong())
    }
}
