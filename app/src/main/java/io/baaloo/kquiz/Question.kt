package io.baaloo.kquiz

data class Question(
    val id: Int,
    val image: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctAnswer: Int
)