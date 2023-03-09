package com.example.animedroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animedroid.data.responses.NetworkAnimeList.Data
import com.example.animedroid.databinding.AnimeRecyclerViewItemBinding

class AnimeListAdapter(private val onClick: (Data) -> Unit) :
    PagingDataAdapter<Data, AnimeListAdapter.AnimeViewHolder>(AnimeDiffCallback) {

    inner class AnimeViewHolder(
        val binding: AnimeRecyclerViewItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        // Bind members
        fun bind(animeData: Data) {
            val animeAttributes = animeData.attributes

            with(binding) {
                animeName.text = animeAttributes.canonicalTitle
                animeImage.load(animeAttributes.posterImage.small)
                animeStartDate.text = "Start Date: ${animeAttributes.startDate}"
                animeEndDate.text = "End Date: ${animeAttributes.endDate}"
                animeEpisodeCount.text = "Episode Count: ${animeAttributes.episodeCount}"
                animeAgeRating.text = "Rated: ${animeAttributes.ageRating}"
                root.setOnClickListener() {
                    onClick(animeData)
                }
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AnimeViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = AnimeRecyclerViewItemBinding
            .inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return AnimeViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        val anime = getItem(position)
        viewHolder.bind(anime!!)
    }

    object AnimeDiffCallback : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }
    }
}