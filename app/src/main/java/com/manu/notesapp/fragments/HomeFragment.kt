package com.manu.notesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.manu.notesapp.R
import com.manu.notesapp.adapter.NotesAdapter
import com.manu.notesapp.databinding.FragmentHomeBinding
import com.manu.notesapp.model.Notes
import com.manu.notesapp.viewmodel.NotesViewModel

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    val notesViewModel: NotesViewModel by viewModels()
    val oldNotes = arrayListOf<Notes>()
    lateinit var adapter: NotesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }



        binding.low.setOnClickListener {
            notesViewModel.getLowNotes().observe(viewLifecycleOwner) {noteList ->
                oldNotes.addAll(noteList)
                adapter = NotesAdapter(requireContext(), noteList)
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = adapter

            }
        }

        binding.high.setOnClickListener {
            notesViewModel.getHighNotes().observe(viewLifecycleOwner) {noteList ->
                oldNotes.addAll(noteList)
                adapter = NotesAdapter(requireContext(), noteList)
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = adapter

            }
        }

        binding.medium.setOnClickListener {
            notesViewModel.getMediumNotes().observe(viewLifecycleOwner) {noteList ->
                oldNotes.addAll(noteList)
                adapter = NotesAdapter(requireContext(), noteList)
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = adapter

            }
        }

        binding.getall.setOnClickListener {
            notesViewModel.getNotes().observe(viewLifecycleOwner) {noteList ->
                oldNotes.addAll(noteList)
                adapter = NotesAdapter(requireContext(), noteList)
                binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.recycleAllNotes.adapter = adapter

            }
        }

        notesViewModel.getNotes().observe(viewLifecycleOwner) {noteList ->
            oldNotes.addAll(noteList)
            adapter = NotesAdapter(requireContext(), noteList)
            binding.recycleAllNotes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.recycleAllNotes.adapter = adapter

        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val item = menu.findItem(R.id.search)
        val searchView = item.actionView as SearchView
        searchView.queryHint = "Enter Title Here..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                notesFilter(newText)
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }




    private fun notesFilter(newText: String?) {
        val newFilteredList = arrayListOf<Notes>()
        for(i in oldNotes) {
            if(i.title.contains(newText!!) || i.subTitle.contains(newText)) {
                newFilteredList.add(i)
            }
        }
        adapter.filter(newFilteredList)
    }

}