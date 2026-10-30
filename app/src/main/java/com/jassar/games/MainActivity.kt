package com.jassar.games

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jassar.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val games = listOf(
            Game("لعبة الأرقام", "تحدي سريع للسرعة والتركيز", "#1F6FEB"),
            Game("لعبة الذاكرة", "اختبر ذاكرتك وانسخ الأنماط", "#14B8A6"),
            Game("لعبة الأسئلة", "اختبر معلوماتك في دقائق", "#F59E0B"),
            Game("لعبة الكلمات", "اكتب الكلمات بسرعة ودقة", "#8B5CF6"),
            Game("لعبة الصور", "اكتشف الاختلافات والأنماط", "#EF4444"),
            Game("لعبة التحدي", "أضف مستوى جديد من الإثارة", "#10B981")
        )

        binding.recyclerViewGames.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewGames.adapter = GameAdapter(games) { game ->
            when (game.title) {
                "لعبة الأرقام" -> {
                    startActivity(Intent(this, NumberGameActivity::class.java))
                }
                else -> {
                    val intent = Intent(this, GameDetailActivity::class.java)
                    intent.putExtra("game_title", game.title)
                    intent.putExtra("game_description", game.description)
                    startActivity(intent)
                }
            }
        }
    }
}
