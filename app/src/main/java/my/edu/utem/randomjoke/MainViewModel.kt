package my.edu.utem.randomjoke

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.edu.utem.randomjoke.data.RandomJokeRespDto
import my.edu.utem.randomjoke.data.RetrofitClient

class MainViewModel : ViewModel() {
    private val _joke = MutableLiveData<RandomJokeRespDto>()
    val joke: LiveData<RandomJokeRespDto> = _joke

    fun fetchRandomJoke() {
        viewModelScope.launch {
            try {
                // Retrofit  instance call
                val response = RetrofitClient.service.getRandomJoke()
                _joke.value = response
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching random joke", e)
            }
        }
    }
}