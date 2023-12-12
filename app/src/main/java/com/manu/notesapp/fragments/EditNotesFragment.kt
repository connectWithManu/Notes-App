package com.manu.notesapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.manu.notesapp.R
import com.manu.notesapp.databinding.DialougeDeleteBinding
import com.manu.notesapp.databinding.FragmentEditNotesBinding
import com.manu.notesapp.model.Notes
import com.manu.notesapp.viewmodel.NotesViewModel
import java.util.Calendar


class EditNotesFragment : Fragment() {
    private val binding by lazy { FragmentEditNotesBinding.inflate(layoutInflater) }
    val notes by navArgs<EditNotesFragmentArgs>()
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
        binding.editentertitle.setText(notes.data.title)
        binding.editentersub.setText(notes.data.subTitle)
        binding.editenternotes.setText(notes.data.notes)

        setHasOptionsMenu(true)
        when (notes.data.priority) {
            "1" -> {
                priority = "1"
                binding.editgreen.setImageResource(R.drawable.baseline_done_24)
                binding.edityellow.setImageResource(0)
                binding.editred.setImageResource(0)
            }

            "2" -> {
                priority = "2"
                binding.edityellow.setImageResource(R.drawable.baseline_done_24)
                binding.editred.setImageResource(0)
                binding.editgreen.setImageResource(0)
            }

            "3" -> {
                priority = "3"
                binding.editred.setImageResource(R.drawable.baseline_done_24)
                binding.edityellow.setImageResource(0)
                binding.editgreen.setImageResource(0)
            }

        }

        binding.editbtnsavenotes.setOnClickListener {
            updateNotes(it)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menuDelete) {
            val bottomSheet = BottomSheetDialog(requireContext())
            val btl = DialougeDeleteBinding.inflate(layoutInflater)
            bottomSheet.setContentView(btl.root)
            bottomSheet.show()

            btl.no.setOnClickListener {
                bottomSheet.dismiss()
            }
            btl.yes.setOnClickListener {
                viewModel.deleteNotes(notes.data.id!!)
                bottomSheet.dismiss()
                Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun updateNotes(it: View?) {
        val title = binding.editentertitle.text.toString()
        val subTitle = binding.editentersub.text.toString()
        val note = binding.editenternotes.text.toString()
        val date = Calendar.getInstance().time.toString()

        val updateNotes = Notes(notes.data.id, title, subTitle, note,date, priority)
        viewModel.updateNotes(updateNotes)
        Toast.makeText(requireContext(), "Notes Update Successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
    }


}