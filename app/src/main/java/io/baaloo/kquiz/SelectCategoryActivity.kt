package io.baaloo.kquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.baaloo.kquiz.databinding.ActivitySelectCategoryBinding

class SelectCategoryActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySelectCategoryBinding

    private var mUsername: String? = null
    private var mSelectedCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusBar()

        binding = ActivitySelectCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUsername = intent.getStringExtra(Constants.KEY_USERNAME)
        Toast.makeText(applicationContext, "Playing as $mUsername", Toast.LENGTH_SHORT).show()

        // binding event listener to all buttons
        binding.btnCatFlags.setOnClickListener(this)
        binding.btnCatBirds.setOnClickListener(this)
        binding.btnCatFruits.setOnClickListener(this)
        binding.btnCatMixed.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnCatFlags -> mSelectedCategory = Constants.CATEGORY_FLAGS
            binding.btnCatBirds -> mSelectedCategory = Constants.CATEGORY_BIRDS
            binding.btnCatFruits -> mSelectedCategory = Constants.CATEGORY_FRUITS
            binding.btnCatMixed -> mSelectedCategory = Constants.CATEGORY_MIXED
        }

        val intent = Intent(applicationContext, QuizActivity::class.java)

        intent.putExtra(Constants.KEY_USERNAME, mUsername)
        intent.putExtra(Constants.KEY_SELECTED_CATEGORY, mSelectedCategory)

        startActivity(intent)
        finish()
    }

    private var backPressedTime: Long = 0
    lateinit var backToast: Toast

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