package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreText = findViewById<TextView>(R.id.txtScore)
        val messageText = findViewById<TextView>(R.id.txtMessage)
        val finishButton = findViewById<Button>(R.id.btnFinish)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        scoreText.text = "You scored $score out of $total"

        messageText.text = if (score >= total / 2) {
            "Great job! You know your life hacks ✅"
        } else {
            "Be careful – not everything online is true ⚠️"
        }

        finishButton.setOnClickListener {
            val intent = Intent(this, ThankYouActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", total)
            startActivity(intent)
            finish()
        }
    }
}



