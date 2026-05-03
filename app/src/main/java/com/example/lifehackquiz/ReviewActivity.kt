package com.example.lifehackquiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val reviewText = findViewById<TextView>(R.id.txtReview)

        val questions = listOf(
            Question(
                "Putting a wooden spoon over a boiling pot stops it from boiling over.",
                true,
                "The spoon disrupts bubbles and helps prevent overflow."
            ),
            Question(
                "Charging your phone overnight damages the battery.",
                false,
                "Modern phones stop charging once full."
            ),
            Question(
                "Rice can fix a water-damaged phone.",
                false,
                "Rice absorbs moisture poorly and is a common myth."
            ),
            Question(
                "Turning off Wi‑Fi and Bluetooth saves battery.",
                true,
                "Background scanning uses battery power."
            )
        )

        val builder = StringBuilder()

        for (q in questions) {
            builder.append("Statement: ${q.statement}\n")
            builder.append("Correct Answer: ${if (q.isHack) "Hack" else "Myth"}\n")
            builder.append("Explanation: ${q.explanation}\n\n")
        }

        reviewText.text = builder.toString()
    }
}