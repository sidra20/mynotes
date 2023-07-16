package com.mynotess21.mynotes.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mynotess21.core.models.Note
import com.mynotess21.mynotes.R
import com.mynotess21.mynotes.adapter.NotesAdapter
import com.mynotess21.mynotes.databinding.FragmentMyNotesBinding
import com.mynotess21.mynotes.viewmodel.NotesViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MyNotesFragment : Fragment(), NotesAdapter.NotesListener {
    private lateinit var binding : FragmentMyNotesBinding
    private lateinit var notesAdapter: NotesAdapter
    private val notesViewModel :NotesViewModel by  sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_notes, container, false)

        binding.floatAdd.setOnClickListener {
            findNavController().navigate(R.id.action_myNotesFragment_to_addNoteFragment)
        }
        binding.viewModel=notesViewModel
        binding.lifecycleOwner = viewLifecycleOwner


        notesAdapter = NotesAdapter(this)
        binding.notesRv.layoutManager = LinearLayoutManager(context)

        binding.notesRv.apply {
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
            adapter = notesAdapter
        }

        notesViewModel.getMyNotes.observe(viewLifecycleOwner) {
            notesAdapter.updateList(it)
            Log.d("insert", "onCreateView: $it ")
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun deleteNote(note: Note) {
        notesViewModel.deleteNote(note)
        notesAdapter.notifyDataSetChanged()
        Toast.makeText(context,"Note deleted!", Toast.LENGTH_SHORT).show()
    }

    override fun editNote(note: Note) {
        notesViewModel.setArguments(note)
        val action = MyNotesFragmentDirections.actionMyNotesFragmentToUpdateNoteFragment(note)
        findNavController().navigate(action)
    }

    override fun viewNote(note: Note) {
        notesViewModel.setArguments(note)
        val action = MyNotesFragmentDirections.actionMyNotesFragmentToViewNoteFragment(note)
        findNavController().navigate(action)
    }
}