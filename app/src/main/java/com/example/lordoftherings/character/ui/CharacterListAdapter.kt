package com.example.lordoftherings.character.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R
import kotlin.Int


class CharacterListAdapter constructor(val viewModel: CharacterViewModel, val onClickListener: (position: Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.character_item, parent, false)
        return CharacterListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as CharacterListViewHolder
        viewHolder.view.setOnClickListener {
            onClickListener(position)
        }
        viewHolder.view.text = viewModel.characterList.value!![position].name
    }

    override fun getItemCount(): Int {
        return viewModel.characterList.value?.size ?: 0
    }

}
