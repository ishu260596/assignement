package com.arcore.assignment.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arcore.assignment.R
import com.arcore.assignment.models.JokeResponse

class Adapter(
    private val jokeList: MutableList<JokeResponse>,
    val onLongClickLisenter: OnLongClickListener
) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.joke_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = jokeList[position]
        holder.setData(model)

        holder.cardView.setOnLongClickListener(View.OnLongClickListener {
            val layoutPosition: Int = holder.getLayoutPosition()
            if (onLongClickLisenter != null) {
                onLongClickLisenter.onLongClickListener(layoutPosition)
            }
            true
        })
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }
}