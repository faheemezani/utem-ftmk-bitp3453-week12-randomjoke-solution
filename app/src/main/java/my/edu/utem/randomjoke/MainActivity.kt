package my.edu.utem.randomjoke

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Observe data changes in joke variable
        viewModel.joke.observe(this) { joke ->
            // Update UI with the new joke data
            findViewById<TextView>(R.id.tv_type).text = "Type: " + joke.type
            findViewById<TextView>(R.id.tv_setup).text = "Joke: " + joke.setup
            findViewById<TextView>(R.id.tv_punchline).text = "Answer: " + joke.punchline
        }

        findViewById<Button>(R.id.btn_get_random_joke).setOnClickListener {
            viewModel.fetchRandomJoke()
        }

    }
}