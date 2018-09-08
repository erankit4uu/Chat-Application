package com.example.ankitchaturvedi.chatapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpActivity : AppCompatActivity() {
    lateinit var mname: EditText
    lateinit var memail: EditText
    lateinit var mpassword: EditText
    lateinit var mcreateAccount: Button

    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mname = findViewById(R.id.name)
        memail = findViewById(R.id.email)
        mpassword = findViewById(R.id.password)
        mcreateAccount = findViewById(R.id.createAccount)


        mAuth = FirebaseAuth.getInstance()

        mcreateAccount.setOnClickListener(View.OnClickListener { view ->
            registerUser(mname.text.toString(), memail.text.toString(), mpassword.text.toString())
        })

    }

    fun registerUser(name: String, email: String, password: String) {
            mAuth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener(
                    OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG)
                                    .show()
                            finish()
                        }
                    })
    }

}
