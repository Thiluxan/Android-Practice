package com.example.animalapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalData: ArrayList<Animal>,private val context: Context):RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalAdapter.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalData.size
    }

    override fun onBindViewHolder(holder: AnimalAdapter.ViewHolder, position: Int) {
        holder.textView.text = animalData[position].name
        holder.imageView.setImageResource(animalData[position].image)
        holder.itemView.setOnClickListener {
            //Toast.makeText(context,"${holder.textView.text}",Toast.LENGTH_SHORT).show()
            var intent = Intent(context,AnimalInfo::class.java)
            intent.putExtra("image",animalData[position].image)
            intent.putExtra("name",animalData[position].name)
            context.startActivity(intent)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.animal_text)
            imageView = view.findViewById(R.id.animal_image)
        }

    }
}