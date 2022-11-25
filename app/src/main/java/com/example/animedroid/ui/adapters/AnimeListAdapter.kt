package com.example.animedroid.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animedroid.R
import com.example.animedroid.data.responses.Data

class AnimeListAdapter() : RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    var animeListData = mutableListOf<Data>()

    fun setAnimeList(animeListData: List<Data>) {
        this.animeListData = animeListData.toMutableList()
        notifyDataSetChanged()
    }

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // List Members
        val animeName: TextView
        val animeRating: TextView
        val animeEpisodeCount: TextView
        val animeStartDate: TextView
        val animeEndDate: TextView
        val animeImage: ImageView

        // Initialise members
        init {
            with(view) {
                animeName = findViewById(R.id.mtvAnimeNameInRv)
                animeImage = findViewById(R.id.mivAnimeImageInRv)
                animeRating = findViewById(R.id.mtvAgeRatingInRv)
                animeEpisodeCount = findViewById(R.id.mtvEpisodeCountInRv)
                animeStartDate = findViewById(R.id.mtvStartDateInRv)
                animeEndDate = findViewById(R.id.mtvEndDateInRv)
            }
        }

        // Bind members
        fun bind(animeData: Data) {
            val animeAttributes = animeData.attributes
            animeImage.load(animeAttributes.posterImage.small)
            animeName.text = animeAttributes.canonicalTitle
            animeStartDate.text = "Start Date: ${animeAttributes.startDate}"
            animeEndDate.text = "End Date: ${animeAttributes.endDate}"
            animeEpisodeCount.text = "Episode Count: ${animeAttributes.episodeCount}"
            animeRating.text = "Rated: ${animeAttributes.ageRating}"
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AnimeViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.anime_recycler_view_item, viewGroup, false)
        return AnimeViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: AnimeViewHolder, position: Int) {
        viewHolder.bind(animeListData[position])
    }

    override fun getItemCount() = animeListData.size
}
