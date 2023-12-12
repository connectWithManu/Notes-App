package com.manu.notesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.manu.notesapp.R
import com.manu.notesapp.databinding.FragmentCreateNotesBinding
import com.manu.notesapp.model.Notes
import com.manu.notesapp.viewmodel.NotesViewModel
import java.util.Calendar


class CreateNotesFragment : Fragment() {
    private val binding by lazy { FragmentCreateNotesBinding.inflate(layoutInflater) }
    val viewModel: NotesViewModel by viewModels()
    var priority: String = "1"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.green.setImageResource(R.drawable.baseline_done_24)

        binding.btnsavenotes.setOnClickListener {
            createNotes(it)
        }

        binding.red.setOnClickListener {
            priority = "3"
            binding.red.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.green.setImageResource(0)
        }
        binding.green.setOnClickListener {
            priority = "1"
            binding.green.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.red.setImageResource(0)
        }
        binding.yellow.setOnClickListener {
            priority = "2"
            binding.yellow.setImageResource(R.drawable.baseline_done_24)
            binding.red.setImageResource(0)
            binding.green.setImageResource(0)
        }

        binding.red.setOnClickListener {
            priority = "3"
            binding.red.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.green.setImageResource(0)
        }
        binding.green.setOnClickListener {
            priority = "1"
            binding.green.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.red.setImageResource(0)
        }
        binding.yellow.setOnClickListener {
            priority = "2"
            binding.yellow.setImageResource(R.drawable.baseline_done_24)
            binding.red.setImageResource(0)
            binding.green.setImageResource(0)
        }



    }



    private fun createNotes(it: View?) {
        val title = binding.entertitle.text.toString()
        val subTitle = binding.entersub.text.toString()
        val note = binding.enternotes.text.toString()
        val date = Calendar.getInstance().time.toString()

        val notes = Notes(null, title, subTitle, note,date, priority)
        viewModel.addNotes(notes)
        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)

    }
}