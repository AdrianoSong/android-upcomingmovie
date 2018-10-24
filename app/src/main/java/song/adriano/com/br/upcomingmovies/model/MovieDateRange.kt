package song.adriano.com.br.upcomingmovies.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDateRange (

        @SerializedName("maximum")
        val maximum: String?,

        @SerializedName("minimum")
        val minimum: String?

): Serializable