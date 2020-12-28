package com.example.animalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        var imageView = findViewById<ImageView>(R.id.animal)
        var textView = findViewById<TextView>(R.id.text)

        var intent = intent
        imageView.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground))
        textView.text = intent.getStringExtra("name")
    }
}

