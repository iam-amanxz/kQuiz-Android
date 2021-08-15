package io.amanxz.kquiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import io.amanxz.kquiz.databinding.ActivitySplashBinding


class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusBar()

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // wait 2 seconds and display start playing button
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            // TODO: Animate from bottom
            binding.btnStartFrame.visibility = View.VISIBLE
        }, 2000)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, SignInActivity::class.java))
            finish()
        }
    }


}