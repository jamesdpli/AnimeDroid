package com.example.animedroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animedroid.data.responses.Data
import com.example.animedroid.databinding.AnimeRecyclerViewItemBinding

class AnimeListAdapter(private val onClick: (Data) -> Unit) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    var animeListData = mutableListOf<Data>()

    fun setAnimeList(animeListData: List<Data>) {
        this.animeListData = animeListData.toMutableList()
        notifyDataSetChanged()
    }

    class AnimeViewHolder(
        val binding: AnimeRecyclerViewItemBinding,
        private val onClick: (Data) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        // Late init current anime for click listener
        private lateinit var currentAnime: Data

        // Bind members
        fun bind(animeData: Data) {
            currentAnime = animeData

            val animeAttributes = currentAnime.attributes

            with(binding) {
                mtvAnimeNameInRv.text = animeAttributes.canonicalTitle
                mivAnimeImageInRv.load(animeAttributes.posterImage.small)
                mtvStartDateInRv.text = "Start Date: ${animeAttributes.startDate}"
                mtvEndDateInRv.text = "End Date: ${animeAttributes.endDate}"
                mtvEpisodeCountInRv.text = "Episode Count: ${animeAttributes.episodeCount}"
                mtvAgeRatingInRv.text = "Rated: ${animeAttributes.ageRating}"
                root.setOnClickListener {
                    onClick(currentAnime)
                }
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AnimeViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = AnimeRecyclerViewItemBinding
            .inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return AnimeViewHolder(binding, onClick)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.bind(animeListData[position])
    }

    override fun getItemCount() = animeListData.size
}
