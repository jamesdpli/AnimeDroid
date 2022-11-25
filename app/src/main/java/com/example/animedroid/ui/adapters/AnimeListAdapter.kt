import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animedroid.R
import com.example.animedroid.data.responses.Data

class AnimeListAdapter(private val onClickListener: OnClickListener) :
    androidx.recyclerview.widget.ListAdapter<Data, AnimeListAdapter.AnimeViewHolder>(MyDiffUtil) {

    companion object MyDiffUtil : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }


    }

    var animeListData = mutableListOf<Data>()

    fun setAnimeList(animeListData: List<Data>) {
        this.animeListData = animeListData.toMutableList()
    }

    inner class AnimeViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

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
        val data = getItem(position)
        viewHolder.itemView.setOnClickListener {
            onClickListener.onClick(data)
        }
        viewHolder.bind(animeListData[position])
    }

    override fun getItemCount() = animeListData.size

    class OnClickListener(val clickListener: (data: Data) -> Unit) {
        fun onClick(data: Data) = clickListener(data)
    }
}
