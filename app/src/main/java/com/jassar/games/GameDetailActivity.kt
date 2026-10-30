package com.jassar.games

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jassar.games.databinding.ActivityGameDetailBinding

class GameDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("game_title") ?: "لعبة"
        val description = intent.getStringExtra("game_description") ?: "تفضل باللعب الآن."

        binding.gameDetailTitle.text = title
        binding.gameDetailDescription.text = description
        binding.gameDetailTag.text = "مستوى جديد"

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.playButton.setOnClickListener {
            Toast.makeText(this, "تم فتح: $title", Toast.LENGTH_SHORT).show()
        }
    }
}
