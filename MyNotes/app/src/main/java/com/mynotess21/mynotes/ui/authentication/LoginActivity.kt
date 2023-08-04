package com.mynotess21.mynotes.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.mynotess21.mynotes.R
import com.mynotess21.mynotes.databinding.ActivityLoginBinding
import com.mynotess21.mynotes.databinding.ActivityRegisterBinding
import com.mynotess21.mynotes.ui.NotesActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.gotoRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        auth = FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener {
                val email = binding.email.text.toString()
                val password = binding.password.text.toString()
                if(email.isEmpty()){
                    Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(password.isEmpty()){
                    Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Login Successfully!", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, NotesActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else{
                            Log.d("login failed", "onCreate: ${task.exception}")
                            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()

                        }
                    }

        }

    }

    override fun onStart() {
        super.onStart()
        val user = Firebase.auth.currentUser
        if(user!=null){
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{

        }
    }
}