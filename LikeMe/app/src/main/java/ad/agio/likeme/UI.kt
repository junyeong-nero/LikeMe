package ad.agio.likeme

import android.content.Context
import android.graphics.Point
import android.util.TypedValue
import android.view.WindowManager


class UI(private val ctx: Context) {

    fun dp(dp: Int): Int {
        return dp(dp.toFloat())
    }

    private fun dp(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, ctx.resources.displayMetrics).toInt()
    }

    fun getScreenSize(): Pair<Int, Int> {
        val wm = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val size = Point()
        wm.defaultDisplay.getSize(size)
        return Pair(size.x, size.y)
    }
}