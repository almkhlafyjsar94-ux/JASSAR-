package com.jassar.games

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jassar.games.databinding.ItemGameBinding

class GameAdapter(
    private val items: List<Game>,
    private val onItemClick: (Game) -> Unit
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = items[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int = items.size

    inner class GameViewHolder(
        private val binding: ItemGameBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(game: Game) {
            binding.gameTitle.text = game.title
            binding.gameDescription.text = game.description
            binding.gameIcon.setBackgroundColor(Color.parseColor(game.colorHex))

            binding.root.setOnClickListener {
                onItemClick(game)
            }
        }
    }
}
