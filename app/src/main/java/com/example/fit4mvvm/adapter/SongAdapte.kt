package com.example.fit4mvvm.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.fit4mvvm.R
import com.example.fit4mvvm.data.model.Song

class SongAdapter() : RecyclerView.Adapter<SongAdapter.ItemViewHolder>() {

    private var dataset = listOf<Song>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.song_title_text)
        val artists: TextView = view.findViewById(R.id.song_artist_text)
        val layout: ConstraintLayout = view.findViewById(R.id.song_layout)
        val time: TextView = view.findViewById(R.id.song_time_text)

    }

    fun submitList(list: List<Song>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val song = dataset[position]

        holder.title.text = song.title
        holder.artists.text = song.artist
        holder.time.text = song.time.toString()


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}