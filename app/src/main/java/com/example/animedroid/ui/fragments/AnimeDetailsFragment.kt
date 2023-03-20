package com.example.animedroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.animedroid.databinding.FragmentAnimeDetailsBinding
import com.example.animedroid.ui.viewmodels.AnimeDetailFragmentViewModel
import com.example.animedroid.ui.viewmodels.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AnimeDetailsFragment : DaggerFragment() {

    private val safeArgs: AnimeDetailsFragmentArgs by navArgs()

    private var _binding: FragmentAnimeDetailsBinding? = null
    private val binding get() = _binding!!

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: AnimeDetailFragmentViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[AnimeDetailFragmentViewModel::class.java]
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
            binding.animeDetailsName.also { it.isGone = true }.text =
                response.data.attributes.canonicalTitle
            binding.animeDetailsDescription.also { it.isGone = true }.text =
                response.data.attributes.description
            binding.animeDetailsImage.load(response.data.attributes.posterImage.large) {
                listener { _, _ ->
                    binding.shimmerFragmentAnimeDetails.isGone = true
                    binding.animeDetailsName.isGone = false
                    binding.animeDetailsDescription.isGone = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}