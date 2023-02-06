package com.example.fit4mvvm


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fit4mvvm.data.SongRepository
import com.example.fit4mvvm.data.model.Song

class SongViewModel : ViewModel() {
    private val repository = SongRepository()

    val songs: LiveData<List<Song>> = repository.songs

    fun search(term: String) {
        repository.search(term)
    }


}
