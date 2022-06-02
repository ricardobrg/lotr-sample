package com.example.lordoftherings.movie.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R
import com.example.lordoftherings.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private val showCharacters: (position: Int) -> Unit = {
        val bundle = bundleOf("movieId" to String)
        findNavController().navigate(R.id.character_list, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentMovieBinding = FragmentMovieBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val viewModel = ViewModelProvider(requireActivity(),
            MovieViewModelProvFactory(requireContext()))[MovieViewModel::class.java]
        binding.viewModel = viewModel;

        setupRecyclerView(binding)
        return binding.root
    }

    /**
     * Creates the Recycler View and setup adapter listeners
     *
     * The adapter is using [MovieListAdapter.notifyDataSetChanged] for any changes that are not
     * related to dataset size. The goal is to simplify the implementation rather than to improve
     * the code performance. If the dataset is too large with lots of individual items changes, not
     * the case here, it would be more efficient to hold the reference of the changed items and use
     * [MovieListAdapter.notifyItemChanged] to update just the specific items.
     *
     * @param fragmentMovieBinding FragmentMovieBinding
     * @return Unit
     *
     */
    @SuppressLint("NotifyDataSetChanged")
    private fun setupRecyclerView(fragmentMovieBinding: FragmentMovieBinding) {
        val viewModel: MovieViewModel = fragmentMovieBinding.viewModel!!
        val movieListAdapter = MovieListAdapter(viewModel, showCharacters)
        val recyclerView: RecyclerView = fragmentMovieBinding.root.findViewById(R.id.movie_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = movieListAdapter
        viewModel.movieList.observe(viewLifecycleOwner) {
            if (movieListAdapter.itemCount != it.size) {
                movieListAdapter.notifyItemRangeChanged(0, movieListAdapter.itemCount)
            }else{
                movieListAdapter.notifyDataSetChanged()
            }
        }
    }
}