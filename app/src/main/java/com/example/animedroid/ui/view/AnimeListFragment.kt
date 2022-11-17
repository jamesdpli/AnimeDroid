package com.example.animedroid.ui.view

import AnimeListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.animedroid.R
import com.example.animedroid.data.response.Data
import com.example.animedroid.databinding.FragmentAnimeListBinding
import com.example.animedroid.ui.viewmodel.SharedAnimeViewModel

class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SharedAnimeViewModel by lazy {
        ViewModelProvider(this)[SharedAnimeViewModel::class.java]
    }

    private val animeListAdapter = AnimeListAdapter { position -> onListItemClick(position) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimeListBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        setUpUI()
        setUpObserver()
        return view
    }

    private fun setUpUI() {
        binding.rvAnimeList.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        binding.rvAnimeList.adapter = animeListAdapter
    }

    private fun setUpObserver() {
        viewModel.getAnimes()
        viewModel.animeLiveData.observe(viewLifecycleOwner) { response ->
            animeListAdapter.setAnimeList(response.data)
        }
    }

    private fun onListItemClick(position: Int) {
        Toast.makeText(context, "Hello ${position}", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
