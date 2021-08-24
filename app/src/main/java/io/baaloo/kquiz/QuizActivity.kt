package io.baaloo.kquiz

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import io.baaloo.kquiz.databinding.ActivityQuizBinding

class QuizActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizBinding
    private var backPressedTime: Long = 0
    lateinit var backToast: Toast

    private var mUsername: String? = null
    private var mSelectedCategory: String? = null

    private var mCurrentPosition = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition = 0
    private var mScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUsername = intent.getStringExtra(Constants.KEY_USERNAME)
        mSelectedCategory = intent.getStringExtra(Constants.KEY_SELECTED_CATEGORY)

        // get questions list based on the selected category
        mQuestionsList = ArrayList(getQuestions()!!.shuffled())

        // set question for the first time
        setQuestion()

        binding.btnOptionOne.setOnClickListener(this)
        binding.btnOptionTwo.setOnClickListener(this)
        binding.btnOptionThree.setOnClickListener(this)

    }

    private fun setQuestion() {
        // reset button states
        enableOptionButtons()
        resetOptionButtonsColor()

        if (mCurrentPosition > mQuestionsList!!.size) {
            // game over
            val intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra(Constants.KEY_USERNAME, mUsername.toString())
            intent.putExtra(Constants.KEY_SCORE, mScore.toString())

            startActivity(intent)
            finish()
        } else {
            // get question based on mCurrentPosition
            val question =
                mQuestionsList!![mCurrentPosition - 1]

            binding.tvQuestionCounter.text = "$mCurrentPosition / ${mQuestionsList!!.size}"

            when (mSelectedCategory) {
                Constants.CATEGORY_FLAGS -> binding.tvQuestion.text =
                    getString(R.string.question_flags)
                Constants.CATEGORY_BIRDS -> binding.tvQuestion.text =
                    getString(R.string.question_birds)
                Constants.CATEGORY_FRUITS -> binding.tvQuestion.text =
                    getString(R.string.question_fruits)
                Constants.CATEGORY_MIXED -> binding.tvQuestion.text =
                    getString(R.string.question_mixed)
            }

            binding.ivQuizImage.setImageResource(question.image)
            binding.btnOptionOne.text = question.optionOne
            binding.btnOptionTwo.text = question.optionTwo
            binding.btnOptionThree.text = question.optionThree
            binding.tvScore.text = "${mScore.toString()}"

        }

    }

    private fun getQuestions(): ArrayList<Question>? {
        when (mSelectedCategory) {
            Constants.CATEGORY_FLAGS -> return Data.getQuestionsForCatFlags()
            Constants.CATEGORY_BIRDS -> return Data.getQuestionsForCatBirds()
            Constants.CATEGORY_FRUITS -> return Data.getQuestionsForCatFruits()
            Constants.CATEGORY_MIXED -> return ArrayList(
                Data.getQuestionsForCatMixed().shuffled().take(10).toList()
            )
        }
        return null
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnOptionOne -> submitAnswer(binding.btnOptionOne, 1)
            binding.btnOptionTwo -> submitAnswer(binding.btnOptionTwo, 2)
            binding.btnOptionThree -> submitAnswer(binding.btnOptionThree, 3)
        }
    }

    private fun submitAnswer(btn: MaterialButton, selectedOption: Int) {
        // disable all buttons when clicked
        disableOptionButtons()

        // set selected answer position
        mSelectedOptionPosition = selectedOption

        // get current question
        val question = mQuestionsList?.get(mCurrentPosition - 1)

        // if answer wrong
        if (question!!.correctAnswer != mSelectedOptionPosition) {
            highlightCorrectAnswerSuccess(question.correctAnswer)
            highlightWrongAnswerDanger(btn)
        }
        // if answer correct
        else {
            highlightCorrectAnswerSuccess(question.correctAnswer)
            // increase score
            mScore += 500
        }

        // reset selected answer position
        mSelectedOptionPosition = 0

        // increase current question position
        mCurrentPosition++

        // wait 1 sec and go to next question
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            setQuestion()
        }, 1000)

    }

    private fun highlightCorrectAnswerSuccess(correctAnswer: Int) {
        val colorSuccess = ColorStateList.valueOf(resources.getColor(R.color.success))

        when (correctAnswer) {
            1 -> {
                binding.btnOptionOne.strokeColor = colorSuccess
                binding.btnOptionOne.setTextColor(colorSuccess)
            }
            2 -> {
                binding.btnOptionTwo.strokeColor = colorSuccess
                binding.btnOptionTwo.setTextColor(colorSuccess)
            }
            3 -> {
                binding.btnOptionThree.strokeColor = colorSuccess
                binding.btnOptionThree.setTextColor(colorSuccess)
            }
        }
    }

    private fun highlightWrongAnswerDanger(btn: MaterialButton) {
        val colorDanger = ColorStateList.valueOf(resources.getColor(R.color.danger))
        btn.strokeColor = colorDanger
        btn.setTextColor(colorDanger)
    }

    private fun disableOptionButtons() {
        val buttons = ArrayList<MaterialButton>()
        buttons.add(binding.btnOptionOne)
        buttons.add(binding.btnOptionTwo)
        buttons.add(binding.btnOptionThree)

        for (button in buttons) {
            button.isClickable = false
        }
    }

    private fun enableOptionButtons() {
        val buttons = ArrayList<MaterialButton>()
        buttons.add(binding.btnOptionOne)
        buttons.add(binding.btnOptionTwo)
        buttons.add(binding.btnOptionThree)

        for (button in buttons) {
            button.isClickable = true
        }
    }

    private fun resetOptionButtonsColor() {
        val buttons = ArrayList<MaterialButton>()
        buttons.add(binding.btnOptionOne)
        buttons.add(binding.btnOptionTwo)
        buttons.add(binding.btnOptionThree)

        val colorWhite = ColorStateList.valueOf(resources.getColor(R.color.white))

        for (button in buttons) {
            button.strokeColor = colorWhite
            button.setTextColor(colorWhite)
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