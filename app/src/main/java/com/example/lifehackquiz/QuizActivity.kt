package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val questions = listOf(
        Question(
            "Putting a wooden spoon over a boiling pot stops it from boiling over.",
            true,
            "The spoon disrupts bubbles and helps prevent overflow."
        ),
        Question(
            "Charging your phone overnight damages the battery.",
            false,
            "Modern phones stop charging when full."
        ),
        Question(
            "Rice can fix a water-damaged phone.",
            false,
            "Rice absorbs moisture poorly and this is a myth."
        ),
        Question(
            "Turning off Wi‑Fi and Bluetooth can save battery.",
            true,
            "Background scanning uses battery power."
        )
    )

    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questionText = findViewById<TextView>(R.id.txtQuestion)
        val feedbackText = findViewById<TextView>(R.id.txtFeedback)

        val hackButton = findViewById<Button>(R.id.btnHack)
        val mythButton = findViewById<Button>(R.id.btnMyth)
        val nextButton = findViewById<Button>(R.id.btnNext)

        nextButton.isEnabled = false
        loadQuestion(questionText, feedbackText, hackButton, mythButton, nextButton)

        hackButton.setOnClickListener {
            if (!answered) {
                checkAnswer(true, feedbackText)
                answered = true
                nextButton.isEnabled = true
                hackButton.isEnabled = false
                mythButton.isEnabled = false
            }
        }

        mythButton.setOnClickListener {
            if (!answered) {
                checkAnswer(false, feedbackText)
                answered = true
                nextButton.isEnabled = true
                hackButton.isEnabled = false
                mythButton.isEnabled = false
            }
        }

        nextButton.setOnClickListener {
            currentIndex++
            answered = false

            if (currentIndex < questions.size) {
                loadQuestion(questionText, feedbackText, hackButton, mythButton, nextButton)
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion(
        questionText: TextView,
        feedbackText: TextView,
        hackButton: Button,
        mythButton: Button,
        nextButton: Button
    ) {
        questionText.text = questions[currentIndex].statement
        feedbackText.text = ""
        hackButton.isEnabled = true
        mythButton.isEnabled = true
        nextButton.isEnabled = false
    }

    private fun checkAnswer(userAnswer: Boolean, feedbackText: TextView) {
        val correct = questions[currentIndex].isHack
        if (userAnswer == correct) {
            score++
            feedbackText.text = "Correct ✅"
        } else {
            feedbackText.text = "Wrong ❌\n${questions[currentIndex].explanation}"
        }
    }
}