package io.amanxz.kquiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
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
            val splashAnimation = AnimationUtils.loadAnimation(applicationContext,R.anim.anim_splash)
            binding.btnStartFrame.visibility = View.VISIBLE
            binding.btnStartFrame.startAnimation(splashAnimation)
        }, 2000)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, SignInActivity::class.java))
            finish()
        }
    }


}