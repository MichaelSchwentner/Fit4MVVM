package com.example.fit4mvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fit4mvvm.data.model.Song

class SongRepository {

    private val _songs = MutableLiveData<List<Song>>(loadSongs())
    val songs: LiveData<List<Song>>
        get() = _songs

    fun search(term: String){
        _songs.value = loadSongs().filter {
            it.title.lowercase().contains(term.lowercase()) || it.artist.lowercase().contains(term.lowercase())
        }

    }

    private fun loadSongs(): List<Song>{
        return listOf(
            Song(1, "Come noi", "Tenth Sky"),
            Song(2, "Capelli blu", "Tenth Sky"),
            Song(3, "Avrei voluto dirti", "Ariette"),
            Song(4, "Spliff in the Morning", "Walterwarm"),
            Song(5, "Diploma", "Psicologi"),
            Song(6, "Tumbling ligths", "The Acidy"),
            Song(7, "Shadow Man", "Noname"),
            Song(8, "Le Code", "Myth Syzer"),
            Song(9, "Im Zweifel", "Tocotronic"),
            Song(10, "Marinade", "Dope Lemon"),
            Song(11, "Underwater", "Porches"),
            Song(12, "Bassackwards", "Kurt Vile"),
            Song(13, "Check Baby", "Kurt Vile"),
            Song(14, "baby you know", "meringer"),
            Song(15, "sky so blue", "Michael Andros"),
            Song(16, "Skydance", "Nomame"),
            Song(17, "Nightexpress", "Noname")
        )
    }

}