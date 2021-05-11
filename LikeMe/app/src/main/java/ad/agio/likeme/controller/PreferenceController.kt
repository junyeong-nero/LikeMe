package ad.agio.likeme.controller

import android.content.Context
import android.util.Log


class PreferenceController(private val ctx: Context) {
    fun log(text: String?) = Log.d(TAG, text!!)
    fun saveData(tag: String?, data: String?) {
        val pre = ctx.getSharedPreferences(tag, Context.MODE_PRIVATE)
        pre.edit().putString(tag, data).apply()
    }

    fun readData(tag: String?): String? {
        val pre = ctx.getSharedPreferences(tag, Context.MODE_PRIVATE)
        return pre.getString(tag, "")
    }

    fun deleteData(tag: String?) {
        val pre = ctx.getSharedPreferences(tag, Context.MODE_PRIVATE)
        pre.edit().remove(tag).apply()
    }

    companion object {
        const val TAG = "DataController"
    }
}