package com.mynotess21.mynotes.ui.firebase_crud

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mynotess21.core.models.Note
import com.mynotess21.mynotes.R
import com.mynotess21.mynotes.adapter.NotesAdapter
import com.mynotess21.mynotes.databinding.FragmentFetchDataBinding
import com.mynotess21.mynotes.databinding.FragmentMyNotesBinding
import com.mynotess21.mynotes.ui.authentication.LoginActivity
import com.mynotess21.mynotes.viewmodel.NotesViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FetchDataFragment : Fragment() {
    private lateinit var binding: FragmentFetchDataBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fetch_data, container, false)

        binding.floatAdd.setOnClickListener {
        }


        val user = Firebase.auth.currentUser
        binding.name.text = user?.displayName
        binding.signout.setOnClickListener {
            Firebase.auth.signOut()
            val i = Intent(requireActivity(), LoginActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }




}