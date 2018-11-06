package song.adriano.com.br.upcomingmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_detail.*
import song.adriano.com.br.upcomingmovies.presenter.MovieDetailPresenter
import song.adriano.com.br.upcomingmovies.viewmodel.MovieViewModel

class MovieDetailActivity : AppCompatActivity() {

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

        movieDetailPresenter = MovieDetailPresenter(myMovie?.movieId)

        movieDetailPresenter?.fetchMovieDetail()
    }
}
