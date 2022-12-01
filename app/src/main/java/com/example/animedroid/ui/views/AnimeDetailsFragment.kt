package com.example.animedroid.ui.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.animedroid.databinding.FragmentAnimeDetailsBinding
import com.example.animedroid.ui.viewmodels.AnimeDetailFragmentViewModel

class AnimeDetailsFragment : Fragment() {

    private val safeArgs: AnimeDetailsFragmentArgs by navArgs()

    private var _binding: FragmentAnimeDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AnimeDetailFragmentViewModel by lazy {
        ViewModelProvider(this)[AnimeDetailFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        setUpUI()
        return binding.root
    }

    private fun setUpUI() {
        viewModel.getAnimeById(animeId = safeArgs.animeId)
        viewModel.animeDetailLiveData.observe(viewLifecycleOwner) { response ->
            binding.tvAnimeDescription.text = response.data.attributes.description
            binding.mtvAnimeNameInRv.text = response.data.attributes.canonicalTitle
            binding.mivAnimeImageInRv.load(response.data.attributes.posterImage.medium)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
