package com.mynotess21.mynotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mynotess21.core.models.Note
import com.mynotess21.mynotes.R
import com.mynotess21.mynotes.databinding.FragmentViewNoteBinding
import com.mynotess21.mynotes.viewmodel.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ViewNoteFragment : Fragment() {
    private lateinit var binding:FragmentViewNoteBinding
    private val notesViewModel : NotesViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_note,  container, false)
        binding.viewModel = notesViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        notesViewModel.setArguments(Note(null, "","", null, null))
    }
}