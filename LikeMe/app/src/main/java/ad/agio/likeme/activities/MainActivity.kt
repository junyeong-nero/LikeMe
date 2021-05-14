package ad.agio.likeme.activities

import ad.agio.likeme.R
import ad.agio.likeme.UI
import ad.agio.likeme.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private fun log(s: String) = Log.e(this.javaClass.simpleName, s)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.setting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
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