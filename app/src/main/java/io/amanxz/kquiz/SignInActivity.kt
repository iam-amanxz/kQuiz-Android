package io.amanxz.kquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.amanxz.kquiz.databinding.ActivitySignInBinding
import io.amanxz.kquiz.databinding.ActivitySplashBinding

class SignInActivity : BaseActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusBar()

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}