package com.example.lordoftherings.quote.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lordoftherings.AppDatabase
import com.example.lordoftherings.databinding.FragmentQuoteBinding
import com.example.lordoftherings.quote.data.*


class QuoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quoteDao : QuoteDao = AppDatabase.getInstance(requireContext()).quoteDao()
        val quoteApiService : QuoteApiService  = QuoteApi.retrofitService
        val repository = QuoteRepository(
            quoteDao, quoteApiService
        )
        val quoteViewModelProvFactory = QuoteViewModelProvFactory(repository)
        val viewModel: QuoteViewModel = ViewModelProvider(requireActivity(), quoteViewModelProvFactory)[QuoteViewModel::class.java]

        val binding = FragmentQuoteBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

}