package song.adriano.com.br.upcomingmovies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import song.adriano.com.br.upcomingmovies.R
import song.adriano.com.br.upcomingmovies.utils.Constants
import song.adriano.com.br.upcomingmovies.viewmodel.MovieViewModel

interface MovieAdapterItemListener {
    fun onMovieItemClicked(myMovie: MovieViewModel)
}

class MovieAdapter(private val myMovies: MutableList<MovieViewModel>,
                   private val movieAdapterListener: MovieAdapterItemListener):
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return myMovies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtMovieTitle.text = myMovies[position].movieTitle
        holder.txtMovieReleaseDate.text = myMovies[position].movieReleaseDate
        Glide.with(holder.itemView)
                .load( "${Constants.BASE_IMG_URL}${myMovies[position].moviePosterPath}")
                .into(holder.imageMoviePoster)

        holder.movieCardView.setOnClickListener {
            movieAdapterListener.onMovieItemClicked(myMovies[position])
        }
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val movieCardView = itemView.movieCardView
        val txtMovieTitle = itemView.textViewMovieTitle
        val txtMovieReleaseDate = itemView.textViewMovieReleaseDate
        val imageMoviePoster = itemView.imageViewMoviePoster
    }
}