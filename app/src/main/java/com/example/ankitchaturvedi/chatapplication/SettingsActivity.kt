package com.example.ankitchaturvedi.chatapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import de.hdodenhof.circleimageview.CircleImageView
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import javax.xml.transform.Result


class SettingsActivity : AppCompatActivity() {
    lateinit var displayImage: CircleImageView
    lateinit var mbtn_change_img : Button
    lateinit var mbtn_change_status: Button
    lateinit var mname : TextView
    lateinit var mstatus : TextView

    lateinit var userDataReference: DatabaseReference
    lateinit var mAuth: FirebaseAuth
    var galleryAction =  1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        displayImage = findViewById(R.id.circleImageView)
        mbtn_change_img = findViewById(R.id.image_change)
        mbtn_change_status = findViewById(R.id.change_status)
        mname = findViewById(R.id.name)
        mstatus = findViewById(R.id.status)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser?.uid
        userDataReference = FirebaseDatabase.getInstance().reference.child("Users").child(currentUser.toString())

        userDataReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val name = snapshot.child("user_name").value.toString()
                val status = snapshot.child("user_status").value.toString()

                mname.text = name
                mstatus.text = status
            }

            override fun onCancelled(p0: DatabaseError) {
            }
        })

        mbtn_change_img.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, galleryAction)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
           if(requestCode== galleryAction && resultCode== Activity.RESULT_OK && data!=null){
               val image = data.data
               CropImage.activity(image)
                       .setGuidelines(CropImageView.Guidelines.ON)
                       .start(this)

           }
    }

}