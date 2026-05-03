package com.example.lifehackquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThankYouActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        val finalScoreText = findViewById<TextView>(R.id.txtFinalScore)
        val exitButton = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        finalScoreText.text = "Your final score is $score out of $total"

        exitButton.setOnClickListener {
            finishAffinity() // closes the app
        }
    }
}