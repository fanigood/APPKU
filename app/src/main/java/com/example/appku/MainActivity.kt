package com.example.appku

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.rownotif.*

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                loadfragmanpost(FragmentPost())
            }
            R.id.navigation_dashboard -> {
            }
            R.id.navigation_notifications -> {


            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)



        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

      loadfragmanpost(FragmentPost())

    }

    private  fun loadfragmanpost(frag1:FragmentPost){
        val ft= supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame,frag1)
        ft.commit()



    }

    private fun loadfragmantNotif(fragmentNotif: FragmentNotif)
    {
     val fn= supportFragmentManager.beginTransaction()
        fn.replace(R.id.frame,fragmentNotif)
        fn.commit()
    }



}
