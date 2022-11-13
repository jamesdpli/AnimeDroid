import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.animedroid.R
import com.example.animedroid.data.response.Data

class AnimeListAdapter(private val animeList: List<Data>) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val animeName: TextView
        val animeRating: TextView
        val animeEpisodeCount: TextView
        val animeStartDate: TextView
        val animeEndDate: TextView
        val animeImage: ImageView

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
        with(viewHolder) {
            animeImage.load(animeList[position].attributes.posterImage.small)
            animeName.text = animeList[position].attributes.canonicalTitle
            animeStartDate.text = "Start Date: ${animeList[position].attributes.startDate}"
            animeEndDate.text = "End Date: ${animeList[position].attributes.endDate}"
            animeEpisodeCount.text = "Episode Count: ${animeList[position].attributes.episodeCount}"
            animeRating.text = "Rated: ${animeList[position].attributes.ageRating}"
        }
    }

    override fun getItemCount() = animeList.size
}
