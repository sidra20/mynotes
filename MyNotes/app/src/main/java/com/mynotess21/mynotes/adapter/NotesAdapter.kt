package com.mynotess21.mynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.mynotess21.core.models.Note
import com.mynotess21.mynotes.databinding.ItemNoteBinding

class NotesAdapter (private val listener : NotesListener) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {
    private var arrayList:ArrayList<Note> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = arrayList.get(position)
        holder.binding.model = note
        holder.binding.listener = listener
        holder.binding.isNoteChecked.visibility = View.GONE
//        holder.itemView.setOnLongClickListener {
//            holder.binding.isNoteChecked.visibility = View.VISIBLE
//            true
//        }
//
//        holder.binding.isNoteChecked.setOnCheckedChangeListener { compoundButton, b ->
//            if(compoundButton.isChecked){
//                arrayList.get(position).isChecked = true
//            }
//        }



    }
    fun getListOfSelectedNotes() : List<Note>{
        val selectedNotes = ArrayList<Note>()
        for (i in 0..arrayList.size){
            if(arrayList[i].isChecked){
                selectedNotes.add(arrayList[i])
            }
        }


        return selectedNotes ?: mutableListOf()
    }

    fun updateList(new:List<Note>)
    {
        arrayList.clear()
        arrayList.addAll(new)
        notifyDataSetChanged()
    }

    fun filteredList(filterList:ArrayList<Note>){
        this.arrayList = filterList
        notifyDataSetChanged()
    }
    class MyViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    interface NotesListener{
        fun deleteNote(note: Note)
        fun editNote(note: Note)
        fun viewNote(note: Note)

    }
}