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
        val animeImage: ImageView

        init {
            animeName = view.findViewById(R.id.tvAnimeNameInRv)
            animeImage = view.findViewById(R.id.ivAnimeImageInRv)
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
            animeName.text = animeList[position].attributes.canonicalTitle
            animeImage.load(animeList[position].attributes.posterImage.medium)
        }
    }

    override fun getItemCount() = animeList.size

}
