package my.edu.utem.randomjoke.data

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://official-joke-api.appspot.com"

    private val moshi = Moshi.Builder()
        // .add(KotlinJsonAdapterFactory()) // NOT needed when using codegen
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            // This converter turns JSON into our Data Classes automatically
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val service: RandomJokesApiService by lazy {
        retrofit.create(RandomJokesApiService::class.java)
    }
}