package song.adriano.com.br.upcomingmovies.viewmodel

import song.adriano.com.br.upcomingmovies.model.MovieDetail
import song.adriano.com.br.upcomingmovies.utils.Date

class MovieDetailViewModel (movieDetail: MovieDetail) {

    var movieOriginaltitle: String? = ""
    var movieReleaseDate: String? = ""
    var moviePosterPath: String? = ""
    var movieGenreArray: String? = ""
    var movieOverView: String? = ""

    init {

        movieOriginaltitle = movieDetail.originalTitle
        moviePosterPath = movieDetail.posterPath
        movieOverView = movieDetail.overview
        movieReleaseDate = Date.convertDateToSimpleDateFormat(movieDetail.releaseDate)

        val genreNameList = mutableListOf<String>()
        movieDetail.genres?.forEach { item ->
            item.name?.let { genreNameList.add(it) }
        }
        movieGenreArray = genreNameList.joinToString()
    }
}