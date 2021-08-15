package io.amanxz.kquiz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.amanxz.kquiz.databinding.ActivityMainBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // wait 2 seconds and display start playing button
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            // TODO: Animate from bottom
            binding.btnStart.visibility = View.VISIBLE
        }, 2000)

        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, SignInActivity::class.java))
            finish()
        }

    }
}