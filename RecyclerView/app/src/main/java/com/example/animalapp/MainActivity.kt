package com.example.animalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AnimalApp)
        setContentView(R.layout.activity_main)

        var animalList = ArrayList<Animal>()
        var recyclerView = findViewById<RecyclerView>(R.id.recylce_view)

        animalList.add(Animal("Camel",R.drawable.camel))
        animalList.add(Animal("Deer",R.drawable.deer))
        animalList.add(Animal("Dog",R.drawable.dog))
        animalList.add(Animal("Elephant",R.drawable.elephant))
        animalList.add(Animal("Lion",R.drawable.lion))
        animalList.add(Animal("Monkey",R.drawable.monkey))
        animalList.add(Animal("Tiger",R.drawable.tiger))
        animalList.add(Animal("Tortoise",R.drawable.tortoise))

        recyclerView.layoutManager = LinearLayoutManager(this)
        var animalAdapter = AnimalAdapter(animalList,this)
        recyclerView.adapter = animalAdapter
    }
}