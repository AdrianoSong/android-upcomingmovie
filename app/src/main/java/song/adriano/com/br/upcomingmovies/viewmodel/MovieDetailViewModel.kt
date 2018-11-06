package song.adriano.com.br.upcomingmovies.viewmodel

import song.adriano.com.br.upcomingmovies.model.MovieDetail

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
        movieReleaseDate = movieDetail.releaseDate
    }

}