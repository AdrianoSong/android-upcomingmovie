package song.adriano.com.br.upcomingmovies.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Date {

    companion object {

        @SuppressLint("SimpleDateFormat")
        fun convertDateToSimpleDateFormat(date: String?): String? {

            val pattern = "yyyy-MM-dd"
            val simpleDateFormat = SimpleDateFormat(pattern, Locale("en", "US"))

            date?.let {
                val formattedDate = simpleDateFormat.parse(date)
                return formattedDate.toString().substring(0, 10)

            } ?: return ""
        }
    }
}