package com.example.myapplicationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val rvName :TextView = findViewById(R.id.textView)
        val rvEmail : TextView = findViewById(R.id.textView2)
        val rvPhoto : ImageView = findViewById(R.id.imageView)

        rvName.setText(R.string.my_name)
        rvEmail.setText(R.string.email)
        rvPhoto.setImageResource(R.drawable.saya)
    }

}





