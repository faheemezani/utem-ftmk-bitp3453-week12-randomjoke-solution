package my.edu.utem.randomjoke.data

import retrofit2.http.GET

interface RandomJokesApiService {
    @GET("random_joke")
    suspend fun getRandomJoke(): RandomJokeRespDto
}