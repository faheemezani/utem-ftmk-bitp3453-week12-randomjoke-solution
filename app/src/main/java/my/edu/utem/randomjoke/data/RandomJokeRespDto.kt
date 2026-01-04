package my.edu.utem.randomjoke.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomJokeRespDto (
    val type: String,
    val setup: String,
    val punchline: String,
    val id: Int
)