package song.adriano.com.br.upcomingmovies.presenter

import song.adriano.com.br.upcomingmovies.service.MyHttpRequester
import song.adriano.com.br.upcomingmovies.service.MyHttpRequesterMovieDetailListener
import song.adriano.com.br.upcomingmovies.viewmodel.MovieDetailViewModel


interface MovieDetailPresenterListener {

    fun onFetchMovieDetailDone(movieDetailViewModel: MovieDetailViewModel)
}

class MovieDetailPresenter (private val movieId: Int?,
                            private val movieDetailPresenterListener: MovieDetailPresenterListener):
        MyHttpRequesterMovieDetailListener {

    fun fetchMovieDetail() {

        if (movieId != null) {
            MyHttpRequester.getMoviesDetail(movieId, this)
        }
    }

    override fun onGetMovieDetailDone(movieDetailViewModel: MovieDetailViewModel) {

        movieDetailPresenterListener.onFetchMovieDetailDone(movieDetailViewModel)
    }
}