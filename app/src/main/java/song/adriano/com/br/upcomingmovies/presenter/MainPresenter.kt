package song.adriano.com.br.upcomingmovies.presenter

import song.adriano.com.br.upcomingmovies.service.MyHttpRequester
import song.adriano.com.br.upcomingmovies.service.MyHttpRequesterListener
import song.adriano.com.br.upcomingmovies.viewmodel.MovieViewModel

interface MainPresenterListener {
    fun onFetchMoviesDone(movieViewModelList: MutableList<MovieViewModel>)
}

class MainPresenter (private var mainPresenterCallBack: MainPresenterListener): MyHttpRequesterListener {

    override fun onGetMoviesDone(movieViewModelList: MutableList<MovieViewModel>) {

        mainPresenterCallBack.onFetchMoviesDone(movieViewModelList)
    }

    var movieViewModel = mutableListOf<MovieViewModel>()
    var searchedMovies = mutableListOf<MovieViewModel>()

    var fetchMoreMovies = false

    fun fetchMovies(page: Int) {
        MyHttpRequester.getMovies(page, this)
    }
}
