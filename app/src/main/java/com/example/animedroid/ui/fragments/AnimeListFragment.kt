package com.example.animedroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.animedroid.data.responses.NetworkAnimeList.Data
import com.example.animedroid.databinding.FragmentAnimeListBinding
import com.example.animedroid.ui.adapters.AnimeListAdapter
import com.example.animedroid.ui.viewmodels.AnimeListFragmentViewModel
import com.example.animedroid.ui.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimeListFragment : DaggerFragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: AnimeListFragmentViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[AnimeListFragmentViewModel::class.java]
    }

    private val animeListAdapter = AnimeListAdapter { anime -> adapterOnClick(anime) }

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
        viewModel.pagedAnimeList.observe(viewLifecycleOwner) {
            pagedAnimeData ->
            lifecycleScope.launch {
                animeListAdapter.submitData(pagedAnimeData)
            }
        }
    }

    private fun adapterOnClick(anime: Data) {
        findNavController().navigate(
            AnimeListFragmentDirections.actionAnimeListFragmentToAnimeDetailsFragment(
                anime.id
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}