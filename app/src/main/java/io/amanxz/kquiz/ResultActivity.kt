package io.amanxz.kquiz


import android.os.Bundle
import io.amanxz.kquiz.databinding.ActivityResultBinding

class ResultActivity : BaseActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}