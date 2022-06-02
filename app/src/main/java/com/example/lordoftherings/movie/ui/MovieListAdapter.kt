package com.example.lordoftherings.movie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R
import com.example.lordoftherings.movie.data.MovieModel
import kotlin.Int
import android.R as androidR


class MovieListAdapter constructor(
    val viewModel: MovieViewModel,
    val showCharacters: (position: Int) -> Unit,
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item, parent, false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val movie: MovieModel = viewModel.movieList.value!![position]
        val viewHolder = holder as MovieListViewHolder
        viewHolder.itemTitle.setOnClickListener {
            showCharacters(position)
        }
        viewHolder.itemFav.setOnClickListener{
            viewModel.toggleFav(movie.id)
            setFavIcon(viewHolder, movie)
        }
        viewHolder.itemTitle.text = movie.name
    }

    private fun setFavIcon(viewHolder: MovieListViewHolder, movie: MovieModel) {
        viewHolder.itemFav.setImageDrawable(
            ResourcesCompat.getDrawable(
                viewHolder.itemView.context.resources,
                if(movie.favorite)
                    androidR.drawable.btn_star_big_on
                else androidR.drawable.btn_star_big_off,
                viewHolder.itemView.context.theme
            ))
    }

    override fun getItemCount(): Int {
        return viewModel.movieList.value?.size ?: 0
    }

}
