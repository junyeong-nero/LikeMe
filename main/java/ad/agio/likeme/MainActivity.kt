package ad.agio.likeme

import ad.agio.likeme.databinding.ActivityMainBinding
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

        val ui = UI(this)

        for(i in 0..30) {
            val view = layoutInflater.inflate(R.layout.button_grid, binding.gridLayout, false)
            view.findViewById<Button>(R.id.button).text = i.toString()
            binding.gridLayout.addView(view, ui.dp(56), ui.dp(56))
        }
    }
}