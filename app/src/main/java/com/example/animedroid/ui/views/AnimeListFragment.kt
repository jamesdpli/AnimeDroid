package com.example.animedroid.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.animedroid.R
import com.example.animedroid.data.responses.Data
import com.example.animedroid.databinding.FragmentAnimeListBinding
import com.example.animedroid.ui.adapters.AnimeListAdapter
import com.example.animedroid.ui.viewmodels.AnimeListFragmentViewModel

class AnimeListFragment : Fragment() {

    private var _binding: FragmentAnimeListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimeListFragmentViewModel by lazy {
        ViewModelProvider(this)[AnimeListFragmentViewModel::class.java]
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
        viewModel.getAnimes()
        viewModel.animeLiveData.observe(viewLifecycleOwner) { response ->
            animeListAdapter.setAnimeList(response.data)
        }
    }

    private fun adapterOnClick(anime: Data) {
        val bundle: Bundle = Bundle()
        val animeDetailsFragment: AnimeDetailsFragment = AnimeDetailsFragment()
        bundle.putString("animeId", anime.id)
        animeDetailsFragment.arguments = bundle
        findNavController().navigate(R.id.action_animeListFragment_to_animeDetailsFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
