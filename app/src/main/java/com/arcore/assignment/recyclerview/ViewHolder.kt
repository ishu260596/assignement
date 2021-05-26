package com.arcore.assignment.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.arcore.assignment.R
import com.arcore.assignment.models.JokeResponse
import com.bumptech.glide.Glide

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView = itemView.findViewById<TextView>(R.id.tvJoke)
    val imageView = itemView.findViewById<ImageView>(R.id.imageJoke)
    val cardView = itemView.findViewById<LinearLayout>(R.id.cardView)
    fun setData(model: JokeResponse) {
        textView.text = model.value
        Glide.with(imageView).load(model.iconUrl).into(imageView)
    }

}