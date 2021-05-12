package ad.agio.likeme

import android.content.Context
import android.util.TypedValue

class UI(private val ctx: Context) {

    fun dp(dp: Int): Int {
        return dp(dp.toFloat())
    }

    private fun dp(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ctx.resources.displayMetrics).toInt()
    }
}