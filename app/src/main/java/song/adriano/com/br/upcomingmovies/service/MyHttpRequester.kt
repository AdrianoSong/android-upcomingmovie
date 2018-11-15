package song.adriano.com.br.upcomingmovies.service

import com.google.gson.Gson
import org.json.JSONObject
import song.adriano.com.br.upcomingmovies.model.MovieDetail
import song.adriano.com.br.upcomingmovies.model.MovieResult
import song.adriano.com.br.upcomingmovies.utils.Constants
import song.adriano.com.br.upcomingmovies.viewmodel.MovieDetailViewModel
import song.adriano.com.br.upcomingmovies.viewmodel.MovieViewModel
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader
import java.net.HttpURLConnection
import java.net.URL

interface MyHttpRequesterListener {
    fun onGetMoviesDone(movieViewModelList: MutableList<MovieViewModel>)
}

interface MyHttpRequesterMovieDetailListener {
    fun onGetMovieDetailDone(movieDetailViewModel: MovieDetailViewModel)
}

class MyHttpRequester {

    companion object {

        fun getMovies(pageNumber: Int, myrequester: MyHttpRequesterListener) {

            val url = URL(Constants.GET_MOVIES_URL + pageNumber)

            with(url.openConnection() as HttpURLConnection) {

                requestMethod = "GET"


                println("\nSending 'GET' request to URL : $url")

                Thread {

                    BufferedReader(InputStreamReader(inputStream) as Reader?).use {

                        val response = StringBuffer()

                        var inputLine = it.readLine()
                        while (inputLine != null) {
                            response.append(inputLine)
                            inputLine = it.readLine()
                        }

                        myrequester.onGetMoviesDone(parseMoviesData(response.toString()))
                    }
                }.start()

            }
        }

        fun getMoviesDetail(movieId: Int, myRequester: MyHttpRequesterMovieDetailListener) {

            val url = URL("${Constants.BASE_MOVIE_URL}$movieId?api_key=${Constants.MY_API_KEY}&language=en-US")

            with(url.openConnection() as HttpURLConnection) {

                requestMethod = "GET"

                println("\nSending 'GET' request to URL : $url")

                Thread {

                    BufferedReader(InputStreamReader(inputStream) as Reader?).use {

                        val response = StringBuffer()

                        var inputLine = it.readLine()
                        while (inputLine != null) {
                            response.append(inputLine)
                            inputLine = it.readLine()
                        }

                        myRequester.onGetMovieDetailDone(parseMovieDetailData(response.toString()))
                    }
                }.start()
            }
        }

        fun parseMoviesData(response: String): MutableList<MovieViewModel> {

            val myJsonObject = JSONObject(response)

            val parsedData = Gson().fromJson(myJsonObject.toString(), MovieResult::class.java)

            val moviesVM = mutableListOf<MovieViewModel>()

            parsedData.movies?.forEach { it ->
                val movieVM = MovieViewModel(it)
                moviesVM.add(movieVM)
            }

            return moviesVM
        }

        fun parseMovieDetailData(response: String): MovieDetailViewModel {

            val myJsonObject = JSONObject(response)
            val parsedData = Gson().fromJson(myJsonObject.toString(), MovieDetail::class.java)

            return MovieDetailViewModel(parsedData)
        }
    }
}