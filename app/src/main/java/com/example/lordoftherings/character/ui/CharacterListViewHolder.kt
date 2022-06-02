package com.example.lordoftherings.character.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R

class CharacterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val view: TextView

    init {
        view = itemView.findViewById(R.id.item_title)
    }
}