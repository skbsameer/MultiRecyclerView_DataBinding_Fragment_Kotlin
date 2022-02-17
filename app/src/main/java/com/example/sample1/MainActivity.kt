package com.example.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
       // fragmentTransaction.replace(R.id.frag, BlankFragment1()).commit()
//       fragmentTransaction.add(R.id.frag,BlankFragment1()).addToBackStack(null).commit()
       fragmentTransaction.add(R.id.frag,BlankFragment1()).commit()

    }



}