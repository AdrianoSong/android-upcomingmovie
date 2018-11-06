package song.adriano.com.br.upcomingmovies.viewmodel

import song.adriano.com.br.upcomingmovies.model.Movie
import java.io.Serializable

class MovieViewModel (movie: Movie) : Serializable {

    var movieId: Int? = 0
    var movieTitle: String? = ""
    var movieReleaseDate: String? = ""
    var moviePosterPath: String? = ""

    init {
        movieId = movie.id
        movieTitle = movie.title
        moviePosterPath = movie.posterPath
        movieReleaseDate = movie.releaseDate
    }
}