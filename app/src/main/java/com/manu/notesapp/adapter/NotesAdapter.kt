package com.manu.notesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manu.notesapp.R
import com.manu.notesapp.databinding.ItemNotesBinding
import com.manu.notesapp.model.Notes

class NotesAdapter(val context: Context, val notesList: List<Notes>): RecyclerView.Adapter<NotesAdapter.NotesVH>() {
    inner class NotesVH(val binding: ItemNotesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesVH {
        val binding = ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesVH(binding)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NotesVH, position: Int) {
        val item = notesList[position]
        holder.binding.itemtitle.text = item.title
        holder.binding.subtitle.text = item.subTitle
        holder.binding.date.text = item.date
        holder.binding.notes.text = item.notes

        when(item.priority) {
            "1" -> {
                holder.binding.prirority.setBackgroundResource(R.drawable.green)
            }
            "2" -> {
                holder.binding.prirority.setBackgroundResource(R.drawable.yellow)
            }
            "3" -> {
                holder.binding.prirority.setBackgroundResource(R.drawable.red)
            }

        }
    }
}