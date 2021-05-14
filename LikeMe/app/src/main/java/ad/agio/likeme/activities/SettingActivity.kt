package ad.agio.likeme.activities


import ad.agio.likeme.databinding.ActivitySettingBinding
import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide


class SettingActivity : AppCompatActivity() {

    private var _binding: ActivitySettingBinding? = null
    private val binding get() = _binding!!
    private fun log(s: String) = Log.e(this.javaClass.simpleName, s)
    private val PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // internet permission request
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET), PERMISSION_REQUEST_CODE)
        binding.back.setOnClickListener { finish() }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    log("granted")
                    Glide.with(this)
                        .load("https://avatars.githubusercontent.com/u/77763121?s=400&amp;u=ac16cf365181e84929d89a60b19e3c5de6528d13&amp;v=4")
                        .into(binding.image)
                } else {
                    log("error")
                    // Explain to the user that the feature is unavailable because
                    // the features requires a permission that the user has denied.
                    // At the same time, respect the user's decision. Don't link to
                    // system settings in an effort to convince the user to change
                    // their decision.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
                finish()
            }
        }
    }
}