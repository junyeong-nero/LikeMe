package ad.agio.likeme.controller

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.function.Consumer


class DataController {
    private val db: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun getQuestion(index: Int, consumer: Consumer<String>) {
        db
            .child("question")
            .child(index.toString())
            .get()
            .addOnSuccessListener {
                if(it.exists() && it != null)
                    it.getValue(String::class.java)?.let { res -> consumer.accept(res) }
            }
    }

    fun getHint(index: Int, consumer: Consumer<String>) {
        db
            .child("hint")
            .child(index.toString())
            .get()
            .addOnSuccessListener {
                if(it.exists() && it != null)
                    it.getValue(String::class.java)?.let { res -> consumer.accept(res) }
            }
    }
}