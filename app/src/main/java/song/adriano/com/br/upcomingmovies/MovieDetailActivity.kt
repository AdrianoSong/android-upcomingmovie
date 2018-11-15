package song.adriano.com.br.upcomingmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.content_movie_detail.*
import song.adriano.com.br.upcomingmovies.presenter.MovieDetailPresenter
import song.adriano.com.br.upcomingmovies.presenter.MovieDetailPresenterListener
import song.adriano.com.br.upcomingmovies.utils.Constants
import song.adriano.com.br.upcomingmovies.viewmodel.MovieDetailViewModel
import song.adriano.com.br.upcomingmovies.viewmodel.MovieViewModel

class MovieDetailActivity : AppCompatActivity(), MovieDetailPresenterListener {

    private var myMovie: MovieViewModel? = null

    private var movieDetailPresenter: MovieDetailPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setSupportActionBar(toolbarMovieDetail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        toolbarMovieDetail.setNavigationOnClickListener {
            this.finish()
        }

        myMovie = intent.getSerializableExtra("myMovie") as MovieViewModel?

        toolbarMovieDetail.title = myMovie?.movieTitle

        movieDetailPresenter = MovieDetailPresenter(myMovie?.movieId, this)

        movieDetailPresenter?.fetchMovieDetail()
    }

    private fun setupMovieDetailActivityElements(movieDetailViewModel: MovieDetailViewModel) {

        runOnUiThread {

            textViewMovieDetailReleaseDate.text = getString(R.string.movie_detail_release_date,
                    movieDetailViewModel.movieReleaseDate)
            textViewMovieDetailTitle.text = movieDetailViewModel.movieOriginaltitle

            textViewGenres.text = getString(R.string.movie_detail_genre,
                    movieDetailViewModel.movieGenreArray)
            textViewMovieDescription.text = movieDetailViewModel.movieOverView

            Glide.with(this)
                    .load("${Constants.BASE_IMG_URL}${movieDetailViewModel.moviePosterPath}")
                    .into(imageViewMovieDetailPoster)

            hideLoadingShowContent()
        }
    }

    private fun hideLoadingShowContent() {

        detailContent.visibility = View.VISIBLE
        progressDetail.visibility = View.INVISIBLE

    }

    override fun onFetchMovieDetailDone(movieDetailViewModel: MovieDetailViewModel) {

        setupMovieDetailActivityElements(movieDetailViewModel)
    }
}
