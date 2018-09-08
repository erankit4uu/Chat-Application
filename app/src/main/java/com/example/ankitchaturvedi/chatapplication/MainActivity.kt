package com.example.ankitchaturvedi.chatapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var mbtn_create_new : Button
    lateinit var mbtn_exsisting : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mbtn_create_new = findViewById(R.id.btn_create_new)
        mbtn_exsisting = findViewById(R.id.btn_exsisting)

        mbtn_create_new.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        })
        mbtn_exsisting.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
    }
}
