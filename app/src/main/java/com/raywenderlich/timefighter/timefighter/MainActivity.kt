package com.raywenderlich.timefighter.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal lateinit var tapMeButton: Button
    internal lateinit var gameScoreTextView: TextView
    internal lateinit var timeLeftTextView: TextView
    internal var score = 0
    internal var gameStarted = false
    internal lateinit var countDownTimer: CountDownTimer
    internal val initialCountDown: Long = 60000
    internal val countDownInterval: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tapMeButton = findViewById(R.id.tap_me_button)
        gameScoreTextView = findViewById<TextView>(R.id.game_score_text_view)
        timeLeftTextView = findViewById<TextView>(R.id.time_left_text_view)

        resetGame()

        tapMeButton.setOnClickListener({ view ->
            incrementScore()
        })

    }

    private fun resetGame() {
        score = 0
        gameScoreTextView.text = getString(R.string.your_score_s, score.toString())
        val initialTimeLeft = initialCountDown / 1000
        timeLeftTextView.text = getString(R.string.time_left_s, initialTimeLeft.toString())

        countDownTimer = object: CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(p0: Long) {
                val timeLeft = p0 / 1000
                timeLeftTextView.text = getString(R.string.time_left_s, timeLeft.toString())
            }

            override fun onFinish() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        gameStarted = false
    }

    private fun incrementScore() {

        score += 1
        val newScore = getString(R.string.your_score_s, score.toString())
        gameScoreTextView.text = newScore

    }
}
