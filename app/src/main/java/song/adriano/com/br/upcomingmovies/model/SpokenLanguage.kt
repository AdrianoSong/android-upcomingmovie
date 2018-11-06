package song.adriano.com.br.upcomingmovies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpokenLanguage (

        @SerializedName("iso_639_1")
        val iso6391: String?,

        @SerializedName("name")
        val name: String?

): Serializable