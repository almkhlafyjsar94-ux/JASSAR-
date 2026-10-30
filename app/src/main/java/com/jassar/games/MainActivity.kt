package com.jassar.games

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jassar.games.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.welcomeTitle.text = getString(R.string.app_name)
        binding.subtitle.text = getString(R.string.home_message)
    }
}
