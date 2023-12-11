package com.manu.notesapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.manu.notesapp.R
import com.manu.notesapp.databinding.FragmentCreateNotesBinding
import java.util.Calendar


class CreateNotesFragment : Fragment() {
    private val binding by lazy { FragmentCreateNotesBinding.inflate(layoutInflater) }
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
            binding.red.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.green.setImageResource(0)
        }
        binding.green.setOnClickListener {
            binding.green.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.red.setImageResource(0)
        }
        binding.yellow.setOnClickListener {
            binding.yellow.setImageResource(R.drawable.baseline_done_24)
            binding.red.setImageResource(0)
            binding.green.setImageResource(0)
        }
    }

    private fun createNotes(it: View?) {
        val title = binding.entertitle.text
        val subTitle = binding.entersub.text
        val note = binding.enternotes.text
        val date = Calendar.getInstance().time


    }
}