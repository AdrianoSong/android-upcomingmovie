package song.adriano.com.br.upcomingmovies.service

import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import song.adriano.com.br.upcomingmovies.model.Movie
import song.adriano.com.br.upcomingmovies.model.MovieResult
import song.adriano.com.br.upcomingmovies.utils.Constants
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.SSLContext


class MyHttpRequester {


    companion object {

        fun getMovies(pageNumber: Int) {

            val url = URL(Constants.GET_MOVIES_URL + pageNumber)

            with(url.openConnection() as HttpURLConnection) {

                requestMethod = "GET"


                println("\nSending 'GET' request to URL : $url")

                Thread {

                    BufferedReader(InputStreamReader(inputStream)).use {

                        val response = StringBuffer()

                        var inputLine = it.readLine()
                        while (inputLine != null) {
                            response.append(inputLine)
                            inputLine = it.readLine()
                        }

                        parseRepositoryData(response.toString())

                    }
                }.start()

            }
        }

        fun getMoviesD0etail(movieId: Int) {


        }

        fun parseRepositoryData(response: String) {

            val myJsonObject = JSONObject(response)

            val itemParseado = Gson().fromJson(myJsonObject.toString(), MovieResult::class.java)
        }
    }
}