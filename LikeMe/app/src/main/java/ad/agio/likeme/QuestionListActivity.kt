package ad.agio.likeme

import ad.agio.likeme.databinding.ActivityMainBinding
import ad.agio.likeme.databinding.ActivityQuestionListBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class QuestionListActivity : AppCompatActivity() {

    private var _binding: ActivityQuestionListBinding? = null
    private val binding get() = _binding!!
    private fun log(s: String) = Log.e(this.javaClass.simpleName, s)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log("start")
        _binding = ActivityQuestionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extra = intent.extras!!
        val index = extra.getInt("number")
        binding.back.setOnClickListener { finish() }

        val adapter = CustomAdapter(this, 30)
        binding.viewpager.adapter = adapter
        binding.viewpager.setCurrentItem(index, false)
    }
}