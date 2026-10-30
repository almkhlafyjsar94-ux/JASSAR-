package com.jassar.games

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jassar.games.databinding.ActivityNumberGameBinding
import kotlin.random.Random

class NumberGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNumberGameBinding
    private var score = 0
    private var firstNumber = 0
    private var secondNumber = 0
    private var answer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        generateQuestion()

        binding.submitButton.setOnClickListener {
            val input = binding.answerInput.text.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(this, "أدخل الإجابة أولاً", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userAnswer = input.toIntOrNull()
            if (userAnswer == null) {
                Toast.makeText(this, "يرجى إدخال رقم صحيح", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userAnswer == answer) {
                score += 10
                binding.feedbackText.text = "إجابة صحيحة!"
                binding.feedbackText.setTextColor(getColor(android.R.color.holo_green_dark))
            } else {
                binding.feedbackText.text = "إجابة خاطئة! الإجابة الصحيحة هي $answer"
                binding.feedbackText.setTextColor(getColor(android.R.color.holo_red_dark))
            }

            binding.scoreText.text = "النقاط: $score"
            binding.answerInput.text?.clear()
            generateQuestion()
        }

        binding.backButton.setOnClickListener { finish() }
    }

    private fun generateQuestion() {
        val operation = Random.nextInt(1, 4)
        firstNumber = Random.nextInt(2, 12)
        secondNumber = Random.nextInt(1, 10)

        when (operation) {
            1 -> {
                answer = firstNumber + secondNumber
                binding.questionText.text = "$firstNumber + $secondNumber = ?"
            }
            2 -> {
                answer = firstNumber - secondNumber
                binding.questionText.text = "$firstNumber - $secondNumber = ?"
            }
            else -> {
                answer = firstNumber * secondNumber
                binding.questionText.text = "$firstNumber × $secondNumber = ?"
            }
        }
    }
}
