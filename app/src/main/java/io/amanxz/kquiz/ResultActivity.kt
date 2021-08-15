package io.amanxz.kquiz


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import io.amanxz.kquiz.databinding.ActivityResultBinding

class ResultActivity : BaseActivity() {
    private lateinit var binding: ActivityResultBinding
    private var backPressedTime: Long = 0
    lateinit var backToast: Toast

    private var mUsername: String? = null
    private var mScore: String? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUsername = intent.getStringExtra(Constants.KEY_USERNAME)
        mScore = intent.getStringExtra(Constants.KEY_SCORE)

        binding.tvUsername.text = "Congratulations, $mUsername!"
        binding.tvScore.text = "You Scored $mScore!"

        binding.btnQuit.setOnClickListener {
            finish();
        }

        binding.btnPlayAgain.setOnClickListener {
            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onBackPressed() {
        backToast = Toast.makeText(this, "Press back again to quit.", Toast.LENGTH_LONG)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            startActivity(Intent(applicationContext, SignInActivity::class.java))
            finish()
            return
        } else {
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}