package com.example.fit4mvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fit4mvvm.SongViewModel
import com.example.fit4mvvm.adapter.SongAdapter

import com.example.fit4mvvm.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: SongViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val songAdapter = SongAdapter()
        binding.homeSongRecycler.adapter = songAdapter

        viewModel.songs.observe(viewLifecycleOwner) {
            songAdapter.submitList(it)
        }

        binding.homeSearchButton.setOnClickListener {
            val term = binding.homeSearchEdit.text.toString()
            viewModel.search(term)
            binding.homeSearchEdit.setText("")
        }



    }
}
