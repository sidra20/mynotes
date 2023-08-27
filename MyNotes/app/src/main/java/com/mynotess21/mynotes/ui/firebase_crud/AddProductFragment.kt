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
import com.mynotess21.mynotes.databinding.FragmentAddProductBinding
import com.mynotess21.mynotes.databinding.FragmentFetchDataBinding
import com.mynotess21.mynotes.databinding.FragmentMyNotesBinding
import com.mynotess21.mynotes.ui.authentication.LoginActivity
import com.mynotess21.mynotes.viewmodel.NotesViewModel
import com.mynotess21.mynotes.viewmodel.ProductViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddProductFragment : Fragment() {
    private lateinit var binding:FragmentAddProductBinding
    private val productViewModel : ProductViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_product, container, false)
        binding.viewModel=productViewModel
        binding.lifecycleOwner=viewLifecycleOwner

        productViewModel.message.observe(viewLifecycleOwner) {
            if(it!=null){
                Toast.makeText(context, it+"", Toast.LENGTH_SHORT).show()

            }
        }





        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
      //productViewModel.emptyMessage()
    }



}