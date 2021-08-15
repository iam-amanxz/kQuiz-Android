package io.amanxz.kquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import io.amanxz.kquiz.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusBar()

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SelectCategoryActivity::class.java)
                intent.putExtra(Constants.KEY_USERNAME, username)
                startActivity(intent)
                finish()
            }
        }
    }
}