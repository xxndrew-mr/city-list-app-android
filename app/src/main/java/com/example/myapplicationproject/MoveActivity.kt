package com.example.myapplicationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MoveActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION ="extra_description"
        const val  EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val ivPhoto: ImageView = findViewById(R.id.imageView)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getStringExtra(EXTRA_PHOTO)

        Log.d("MoveActivity", "Name: $name")
        Log.d("MoveActivity", "Description: $description")
        Log.d("MoveActivity", "Photo: $photo")

        tvName.text = name
        tvDescription.text = description

        Glide.with(this)
            .load(photo)
            .into(ivPhoto)
       }
}

