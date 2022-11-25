package com.example.animedroid.ui.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.animedroid.databinding.FragmentAnimeDetailsBinding
import com.example.animedroid.ui.viewmodels.AnimeDetailFragmentViewModel
import com.example.animedroid.ui.viewmodels.AnimeListFragmentViewModel

class AnimeDetailsFragment : Fragment() {

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
        val view = binding.root
        setUpUi()
        return view
    }

    fun setUpUi() {
//        viewModel.getAnimeById()
//        viewModel.animeDetailLiveData.observe(viewLifecycleOwner) {
//            response ->
//            binding.mtvAnimeNameInRv.text = response.attributes.canonicalTitle
//            binding.tvAnimeDescription.text = response.attributes.description
//            binding.mivAnimeImageInRv.load(response.attributes.coverImage.original)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
