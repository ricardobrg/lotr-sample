package com.example.lordoftherings.movie.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemTitle: TextView
    val itemFav: ImageView

    init {
        itemTitle = itemView.findViewById(R.id.item_title)
        itemFav = itemView.findViewById(R.id.item_fav)
    }
}