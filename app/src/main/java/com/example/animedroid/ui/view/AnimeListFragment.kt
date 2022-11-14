package com.example.animedroid.ui.view

import AnimeListAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.animedroid.databinding.FragmentAnimeListBinding
import com.example.animedroid.ui.viewmodel.AnimeListViewModel

class AnimeListFragment : Fragment() {

    private val viewModel: AnimeListViewModel by lazy {
        ViewModelProvider(this)[AnimeListViewModel::class.java]
    }

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimeListBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        viewModel.getAnimes()
        viewModel.animeLiveData.observe(viewLifecycleOwner) {
                response ->
            // TO-DO pass in vm instead
            val adapter = AnimeListAdapter(response.data)
            val recyclerView = binding.rvAnimeList
            recyclerView?.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            recyclerView?.adapter = adapter
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
