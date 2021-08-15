package io.amanxz.kquiz

object Data {
    fun getQuestionsForCatFlags(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val q1 =
            Question(1, R.drawable.ic_flag_of_argentina, "Argentina", "Australia", "Armenia", 1)
        val q2 = Question(
            2, R.drawable.ic_flag_of_australia, "Angola", "Austria", "Australia", 3
        )
        val q3 = Question(3, R.drawable.ic_flag_of_brazil, "Belarus", "Belize", "Brazil", 3)
        val q4 = Question(4, R.drawable.ic_flag_of_belgium, "Bahamas", "Belgium", "Barbados", 2)
        val q5 = Question(5, R.drawable.ic_flag_of_fiji, "Gabon", "France", "Fiji", 3)
        val q6 = Question(6, R.drawable.ic_flag_of_germany, "Germany", "Georgia", "Greece", 1)
        val q7 = Question(7, R.drawable.ic_flag_of_denmark, "Dominica", "Egypt", "Denmark", 3)
        val q8 = Question(8, R.drawable.ic_flag_of_india, "Ireland", "Iran", "India", 3)
        val q9 =
            Question(9, R.drawable.ic_flag_of_new_zealand, "Australia", "New Zealand", "Tuvalu", 2)
        val q10 = Question(10, R.drawable.ic_flag_of_kuwait, "Kuwait", "Jordan", "Palestine", 1)

        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        questionsList.add(q8)
        questionsList.add(q9)
        questionsList.add(q10)

        return questionsList
    }

    fun getQuestionsForCatBirds(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val q1 = Question(
            1,
            R.drawable.ic_bird_eagle,
            "Eagle",
            "Goose",
            "Greenfinch",
            1
        )
        val q2 = Question(
            2,
            R.drawable.ic_bird_goose,
            "Duck",
            "Flycatcher",
            "Goose",
            3
        )
        val q3 = Question(
            3,
            R.drawable.ic_bird_hummingbird,
            "Hawk",
            "Ostrich",
            "Hummingbird",
            3
        )
        val q4 = Question(
            4,
            R.drawable.ic_bird_kingfisher,
            "Toucan",
            "Kingfisher",
            "Macaw",
            2
        )
        val q5 = Question(
            5,
            R.drawable.ic_bird_parrot,
            "Crow",
            "Goose",
            "Parrot",
            3
        )
        val q6 = Question(
            6,
            R.drawable.ic_bird_peacock,
            "Peacock",
            "Penguin",
            "Pigeon",
            1
        )
        val q7 = Question(
            7,
            R.drawable.ic_bird_penguin,
            "Stork",
            "Kingfisher",
            "Penguin",
            3
        )
        val q8 = Question(
            8,
            R.drawable.ic_bird_rooster,
            "Gull",
            "Turkey",
            "Rooster",
            3
        )
        val q9 = Question(
            9,
            R.drawable.ic_bird_toucan,
            "Sparrow",
            "Toucan",
            "Swan",
            2
        )
        val q10 = Question(
            10,
            R.drawable.ic_bird_woodpecker,
            "Woodpecker",
            "Owl",
            "Robin",
            1
        )
        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        questionsList.add(q8)
        questionsList.add(q9)
        questionsList.add(q10)

        return questionsList
    }

    fun getQuestionsForCatFruits(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val q1 = Question(
            1,
            R.drawable.ic_fruit_apple,
            "Apple",
            "Apricots",
            "Blackberries",
            1
        )
        val q2 = Question(
            2,
            R.drawable.ic_fruit_avocado,
            "Banana",
            "Blueberry",
            "Avocado",
            3
        )
        val q3 = Question(
            3,
            R.drawable.ic_fruit_banana,
            "Breadfruit",
            "Blackcurrant",
            "Banana",
            3
        )
        val q4 = Question(
            4,
            R.drawable.ic_fruit_blueberry,
            "Date",
            "Blueberry",
            "Papaya",
            2
        )
        val q5 = Question(
            5,
            R.drawable.ic_fruit_cherry,
            "Grapefruit",
            "Strawberries",
            "Cherry",
            3
        )
        val q6 = Question(
            6,
            R.drawable.ic_fruit_grape,
            "Grape",
            "Watermelon",
            "Pineapple",
            1
        )
        val q7 = Question(
            7,
            R.drawable.ic_fruit_guava,
            "Olive",
            "Nectarine",
            "Guava",
            3
        )
        val q8 = Question(
            8,
            R.drawable.ic_fruit_king_coconut,
            "Coconut",
            "Tamarind",
            "King Coconut",
            3
        )
        val q9 = Question(
            9,
            R.drawable.ic_fruit_mango,
            "Grape",
            "Mango",
            "Guava",
            2
        )
        val q10 = Question(
            10,
            R.drawable.ic_fruit_orange,
            "Orange",
            "Lemon",
            "Olive",
            1
        )
        questionsList.add(q1)
        questionsList.add(q2)
        questionsList.add(q3)
        questionsList.add(q4)
        questionsList.add(q5)
        questionsList.add(q6)
        questionsList.add(q7)
        questionsList.add(q8)
        questionsList.add(q9)
        questionsList.add(q10)

        return questionsList
    }

    fun getQuestionsForCatMixed(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        questionsList.addAll(getQuestionsForCatFruits())
        questionsList.addAll(getQuestionsForCatBirds())
        questionsList.addAll(getQuestionsForCatFlags())

        return questionsList
    }
}