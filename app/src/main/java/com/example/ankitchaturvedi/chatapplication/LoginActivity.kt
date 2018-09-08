package com.example.ankitchaturvedi.chatapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var memail : EditText
    lateinit var mpassword : EditText
    lateinit var mbtn_login : Button

    lateinit var email : String
    lateinit var password : String

    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        memail = findViewById(R.id.email)
        mpassword = findViewById(R.id.password)
        mbtn_login = findViewById(R.id.btn_login)

        mbtn_login.setOnClickListener(View.OnClickListener { view ->
           email = memail.text.toString()
            password = mpassword.text.toString()

            LoginUser(email, password)
        })

        mAuth = FirebaseAuth.getInstance()
    }

    private fun LoginUser(email: String, password: String) {

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_LONG).show()
        }
        else if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
        }else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }else
                {
                        Toast.makeText(this, "Email or password is incorrect", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
