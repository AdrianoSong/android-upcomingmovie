package song.adriano.com.br.upcomingmovies.presenter

import android.util.Log
import song.adriano.com.br.upcomingmovies.service.MyHttpRequester
import song.adriano.com.br.upcomingmovies.service.MyHttpRequesterMovieDetailListener
import song.adriano.com.br.upcomingmovies.viewmodel.MovieDetailViewModel

class MovieDetailPresenter (private val movieId: Int?): MyHttpRequesterMovieDetailListener {

    override fun onGetMovieDetailDone(movieDetailViewModel: MovieDetailViewModel) {
        Log.e("movieDetailPresenter", "return data $movieDetailViewModel")
    }

    fun fetchMovieDetail() {

        if (movieId != null) {
            MyHttpRequester.getMoviesDetail(movieId, this)
        }
    }

}