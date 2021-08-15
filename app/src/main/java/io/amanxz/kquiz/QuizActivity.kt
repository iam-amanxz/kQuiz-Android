package io.amanxz.kquiz

import android.os.Bundle
import io.amanxz.kquiz.databinding.ActivityQuizBinding

class QuizActivity : BaseActivity() {
    private lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}