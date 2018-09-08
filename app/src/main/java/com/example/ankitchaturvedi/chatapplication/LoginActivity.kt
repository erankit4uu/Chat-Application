package com.example.ankitchaturvedi.chatapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var memail : EditText
    lateinit var mpassword : EditText
    lateinit var mbtn_login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        memail = findViewById(R.id.email)
        mpassword = findViewById(R.id.password)
        mbtn_login = findViewById(R.id.btn_login)
    }
}
