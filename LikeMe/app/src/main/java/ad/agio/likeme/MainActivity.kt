package ad.agio.likeme

import ad.agio.likeme.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.GridLayout


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private fun log(s: String) = Log.e(this.javaClass.simpleName, s)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            startActivity(Intent(this, QuestionListActivity::class.java))
        }

        val ui = UI(this)
        binding.gridLayout.columnCount = 5
        val size = (ui.getScreenSize().first - ui.dp(64)) / 5

        for(i in 0..29) {
            val view = layoutInflater.inflate(R.layout.button_grid, binding.gridLayout, false)
            val button = view.findViewById<Button>(R.id.button)
            button.text = (i + 1).toString()
            button.setOnClickListener {
                val intent = Intent(this, QuestionListActivity::class.java)
                intent.putExtra("number", i)
                startActivity(intent)
            }

            binding.gridLayout.addView(view, size, size)
        }
    }
}