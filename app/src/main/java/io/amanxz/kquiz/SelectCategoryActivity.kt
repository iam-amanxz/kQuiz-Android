package io.amanxz.kquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.amanxz.kquiz.databinding.ActivitySelectCategoryBinding
import io.amanxz.kquiz.databinding.ActivitySignInBinding

class SelectCategoryActivity : BaseActivity() {
    private lateinit var binding: ActivitySelectCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusBar()

        binding = ActivitySelectCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}