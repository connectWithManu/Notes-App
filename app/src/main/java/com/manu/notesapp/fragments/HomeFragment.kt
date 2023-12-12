package com.manu.notesapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.manu.notesapp.R
import com.manu.notesapp.adapter.NotesAdapter
import com.manu.notesapp.databinding.FragmentHomeBinding
import com.manu.notesapp.viewmodel.NotesViewModel

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    val notesViewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        binding.low.setOnClickListener {
            notesViewModel.getLowNotes().observe(viewLifecycleOwner) {noteList ->
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = NotesAdapter(requireContext(), noteList)

            }
        }

        binding.high.setOnClickListener {
            notesViewModel.getHighNotes().observe(viewLifecycleOwner) {noteList ->
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = NotesAdapter(requireContext(), noteList)

            }
        }

        binding.medium.setOnClickListener {
            notesViewModel.getMediumNotes().observe(viewLifecycleOwner) {noteList ->
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = NotesAdapter(requireContext(), noteList)

            }
        }

        binding.getall.setOnClickListener {
            notesViewModel.getNotes().observe(viewLifecycleOwner) {noteList ->
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = NotesAdapter(requireContext(), noteList)

            }
        }

        notesViewModel.getNotes().observe(viewLifecycleOwner) {noteList ->
            binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.recycleAllNotes.adapter = NotesAdapter(requireContext(), noteList)

        }

    }

}