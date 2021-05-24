package ad.agio.likeme.activities

import ad.agio.likeme.R
import ad.agio.likeme.UI
import ad.agio.likeme.controller.PreferenceController
import ad.agio.likeme.databinding.ActivityMainBinding
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog


class MainActivity() : AppCompatActivity() {

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

        val preferenceController = PreferenceController(this)
        for(i in 0..29) {
            val r = preferenceController.readData("LikeMe:$i")
            if(r.equals(""))
                preferenceController.saveData("LikeMe:$i", "")

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

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
            .setTitle("종료")
        builder.setPositiveButton("예") { _: DialogInterface, i: Int -> run {
            finish()
        }}
        super.onBackPressed()
    }
}