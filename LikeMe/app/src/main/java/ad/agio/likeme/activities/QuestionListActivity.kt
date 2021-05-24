package ad.agio.likeme.activities

import ad.agio.likeme.CustomAdapter
import ad.agio.likeme.databinding.ActivityQuestionListBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.size
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

        binding.nextQ.setOnClickListener { moveViewpager(1) }
        binding.previousQ.setOnClickListener { moveViewpager(-1) }
    }

    fun moveViewpager(change: Int) {
        var que = binding.viewpager.currentItem + change
        if(que < 0)
            que = 0
        else if(que >= binding.viewpager.size)
            que = binding.viewpager.size - 1
        binding.viewpager.setCurrentItem(que, true)
    }
}