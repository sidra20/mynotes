package com.mynotess21.mynotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mynotess21.mynotes.R
import com.mynotess21.mynotes.databinding.FragmentAddNoteBinding
import com.mynotess21.mynotes.viewmodel.NotesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNoteFragment : Fragment() {
    private lateinit var binding:FragmentAddNoteBinding
    private val notesViewModel : NotesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)
        binding.viewModel = notesViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}