package ad.agio.likeme.activities

import ad.agio.likeme.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        startMainActivity(1000)
    }

    private fun startMainActivity(time: Long) {
        Thread {
            Thread.sleep(time)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }.start()
    }
}