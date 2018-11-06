package song.adriano.com.br.upcomingmovies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BelongsToCollection (

        @SerializedName("id")
        val id: Int?,

        @SerializedName("name")
        val name: String?,

        @SerializedName("poster_path")
        val posterPath: String?,

        @SerializedName("backdrop_path")
        val backdropPath: String?

): Serializable