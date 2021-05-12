package ad.agio.likeme

import ad.agio.likeme.controller.DataController
import ad.agio.likeme.databinding.ActivityQuestionBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog

class QuestionActivity : AppCompatActivity() {

    private var _binding: ActivityQuestionBinding? = null
    private val binding get() = _binding!!
    private fun log(s: String) = Log.e(this.javaClass.simpleName, s)
    private val controller = DataController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extra = intent.extras!!
        val index = extra.getInt("number")
        binding.question.text = String.format("Q. %d", index)
        binding.back.setOnClickListener {
            finish()
        }
        binding.hint.setOnClickListener {
            hint(index)
        }
        controller.getQuestion(index) {
            binding.title.text = it
        }
    }

    private fun hint(index: Int) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("힌트")
            .create()

        controller.getHint(index) {
            dialog.setMessage(it)
            dialog.show()
        }
    }
}