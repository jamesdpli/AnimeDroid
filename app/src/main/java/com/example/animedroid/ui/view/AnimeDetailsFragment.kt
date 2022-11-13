package com.example.animedroid.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.animedroid.databinding.FragmentAnimeDetailsBinding
import com.example.animedroid.ui.viewmodel.AnimeDetailsViewModel
import com.example.animedroid.ui.viewmodel.AnimeListViewModel

class AnimeDetailsFragment : Fragment() {

    private val viewModel: AnimeDetailsViewModel by lazy {
        ViewModelProvider(this)[AnimeDetailsViewModel::class.java]
    }

    private var _binding: FragmentAnimeDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
