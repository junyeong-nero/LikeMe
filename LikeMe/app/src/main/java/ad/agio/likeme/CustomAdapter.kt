package ad.agio.likeme

import ad.agio.likeme.controller.DataController
import ad.agio.likeme.controller.PreferenceController
import android.content.Context
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context, private val count: Int) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private fun log(s: String) = Log.e(this.javaClass.simpleName, s)

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val question: TextView
        val edit: EditText
        val hint: TextView

        init {
            title = view.findViewById(R.id.title)
            question = view.findViewById(R.id.question)
            hint = view.findViewById(R.id.hint)
            edit = view.findViewById(R.id.edit)
            // Define click listener for the ViewHolder's View.
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_question, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.question.text = String.format("Q. %d", position + 1);

        val controller = DataController()
        controller.getQuestion(position) {
            viewHolder.title.text = it
        }
        controller.getHint(position) {
            val temp = it
            viewHolder.hint.setOnClickListener {
                AlertDialog
                    .Builder(context)
                    .setTitle("힌트")
                    .setMessage(temp)
                    .show()
            }
        }

        val preferenceController = PreferenceController(context)
        viewHolder.edit.setText(preferenceController.readData("LikeMe:$position"))
        viewHolder.edit.addTextChangedListener {
            log("save!")
            preferenceController.saveData("LikeMe:$position", viewHolder.edit.text.toString())
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = count

}
