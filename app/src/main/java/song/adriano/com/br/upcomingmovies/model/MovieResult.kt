package song.adriano.com.br.upcomingmovies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResult (

        @SerializedName("results")
        val movies: MutableList<Movie>?,

        @SerializedName("page")
        val page: Int?,

        @SerializedName("total_results")
        val totalResults: Int?,

        @SerializedName("dates")
        val movieDateRange: MovieDateRange?,

        @SerializedName("total_pages")
        val totalPages: Int?

): Serializable