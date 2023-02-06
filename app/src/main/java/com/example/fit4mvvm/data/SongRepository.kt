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
            Song(1, "Come noi", "Tenth Sky", "3:23"),
            Song(2, "Capelli blu", "Tenth Sky", "2:45"),
            Song(3, "Avrei voluto dirti", "Ariette", "3:47"),
            Song(4, "Spliff in the Morning", "Walterwarm", "2:17"),
            Song(5, "Diploma", "Psicologi", "2:56"),
            Song(6, "Tumbling ligths", "The Acidy", "1:58"),
            Song(7, "Shadow Man", "Noname","4:02"),
            Song(8, "Le Code", "Myth Syzer","2:36"),
            Song(9, "Im Zweifel", "Tocotronic", "3:12"),
            Song(10, "Marinade", "Dope Lemon","3:09"),
            Song(11, "Underwater", "Porches", "4:47"),
            Song(12, "Bassackwards", "Kurt Vile", "2:27"),
            Song(13, "Check Baby", "Kurt Vile","2:34"),
            Song(14, "baby you know", "meringer","5:03"),
            Song(15, "sky so blue", "Michael Andros","1:46"),
            Song(16, "Skydance", "Nomame","2:07"),
            Song(17, "Nightexpress", "Noname","2:56")
        )
    }

}