package com.example.lordoftherings.character.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lordoftherings.R
import com.example.lordoftherings.databinding.FragmentCharacterBinding


class CharacterFragment(private val movieId: String) : Fragment() {

    private val showCharacterDetails: (position: Int) -> Unit = { position ->
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : FragmentCharacterBinding = FragmentCharacterBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel =
            ViewModelProvider(requireActivity(),
                CharacterViewModelProvFactory(requireContext(), movieId))[CharacterViewModel::class.java]
        setupRecyclerView(binding)
        return binding.root
    }

    /**
     * Creates the Recycler View and setup adapter listeners
     *
     * @param fragmentCharacterBinding FragmentCharacterBinding
     * @return Unit
     *
     */
    private fun setupRecyclerView(fragmentCharacterBinding: FragmentCharacterBinding) {
        val viewModel: CharacterViewModel = fragmentCharacterBinding.viewModel!!
        val characterListAdapter = CharacterListAdapter(viewModel, showCharacterDetails)
        val recyclerView: RecyclerView = fragmentCharacterBinding.root.findViewById(R.id.character_list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = characterListAdapter
        viewModel.characterList.observe(viewLifecycleOwner) {
            if (characterListAdapter.itemCount != it.size) {
                characterListAdapter.notifyItemRangeChanged(0, characterListAdapter.itemCount)
            }
        }
    }
}