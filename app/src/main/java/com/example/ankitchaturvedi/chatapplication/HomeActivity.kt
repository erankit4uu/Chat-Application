package com.example.ankitchaturvedi.chatapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.example.ankitchaturvedi.chatapplication.Adapter.TabPagerAdapter
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {
    lateinit var mmain_tabs : TabLayout
    lateinit var mpager : ViewPager

    lateinit var mTabPagerAdapter : TabPagerAdapter

    var mAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mmain_tabs = findViewById(R.id.main_tabs)
        mpager = findViewById(R.id.pager)

        mTabPagerAdapter = TabPagerAdapter(supportFragmentManager)
        mpager.adapter = mTabPagerAdapter
        mmain_tabs.setupWithViewPager(mpager)
    }

    override fun onStart() {
        super.onStart()

        val user = mAuth.currentUser
        if(user==null){
            LogoutUser()
        }
    }

    private fun LogoutUser() {

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         super.onOptionsItemSelected(item)

        if (item?.itemId == R.id.logout){
            mAuth.signOut()
        }
        return true
    }
}
